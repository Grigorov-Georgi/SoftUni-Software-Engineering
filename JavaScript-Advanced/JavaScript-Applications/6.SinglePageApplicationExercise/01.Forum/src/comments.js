import { el } from './dom.js';

let main;
let section;
let topicId;
let form;
let answerDiv;

function setComment(tagName, targetSection, answerDivTarget) {
    main = tagName;
    section = targetSection;
    answerDiv = answerDivTarget;

    form = targetSection.querySelector('form');
    form.addEventListener('submit', createComment);
}

async function showComments(id) {
    topicId = id;

    main.innerHTML = '';
    main.appendChild(section);

    const topic = await getTopic(topicId);
    const titleElement = createTopic(topic);
    const allComments = await getAllComments();

    const commentsDiv = section.querySelector('.comment');
    commentsDiv.innerHTML = '';

    const themeContent = section.querySelector('.theme-content');
    themeContent.innerHTML = '';

    commentsDiv.appendChild(createPost(topic));
    commentsDiv.append(...allComments);

    themeContent.append(titleElement);
    themeContent.append(commentsDiv);
    themeContent.append(answerDiv);
}

function createTopic(topic) {
    const title = el('div', { class: 'theme-title' },
        el('div', { class: 'theme-name-wrapper' },
            el('div', { class: 'theme-name' },
                el('h2', {}, topic.title)
            ),
        ),
    );

    return title;
}

function createPost(topic) {
    const post = el('div', { class: 'header' },
        el('img', { src: './static/profile.png' }, ''),
        el('p', {},
            el('span', {}, topic.username),
            ' posted on ',
            el('time', {}, topic.currDate)
        ),
        el('p', { class: 'post-content' }, topic.postText)
    )

    return post;
}

async function createComment(ev) {
    ev.preventDefault();
    const formData = new FormData(form);

    const comment = formData.get('postText');
    const username = formData.get('username');

    if (comment.trim() === '' || username.trim() === '') {
        alert('All fields are required!');
        return;
    }

    const today = new Date();
    const currDate = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();

    try {
        const res = await fetch('http://localhost:3030/jsonstore/collections/myboard/comments', {
            method: 'post',
            headers: { 'Content-Type': 'application.json' },
            body: JSON.stringify({
                comment,
                username,
                topicId,
                currDate
            })
        });

        if (res.status != 200) {
            throw Error();
        }
    } catch (error) {
        alert('An error occurred! Please try again later.')
    }

    form.reset();
    showComments(topicId);
}

async function getTopic(topicId) {
    const res = await fetch('http://localhost:3030/jsonstore/collections/myboard/posts/' + topicId);
    const data = await res.json();

    return data;
}

async function getAllComments() {
    try {
        const res = await fetch('http://localhost:3030/jsonstore/collections/myboard/comments')

        if (res.status != 200 && res.status != 204) {
            throw Error();
        }

        if (res.status == 204) {
            return {};
        }
        const comments = await res.json();
        const result = Object.values(comments).filter(x => x.topicId == topicId).map(createUserComment);
        return result;

    } catch (error) {
        alert('An error occurred! Please try again later.')
    }
}

function createUserComment(user) {
    const comment = el('div', { class: 'user-comment' },
        el('div', { class: 'topic-name-wrapper' },
            el('div', { class: 'topic-name' },
                el('p', {},
                    el('strong', {}, user.username),
                    ' commented on ',
                    el('time', {}, user.currDate),
                ),
                el('div', { class: 'post-content' },
                    el('p', {}, user.comment)
                )
            ),
        )
    )

    return comment;
}


export default {
    setComment,
    showComments,
}