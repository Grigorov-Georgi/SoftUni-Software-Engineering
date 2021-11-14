import { el } from './dom.js';
import comments from './comments.js';

let main;
let section;
let currentForm;
const baseUrl = 'http://localhost:3030/jsonstore/collections/myboard/posts';

function setTopic(tagName, targetSection) {
    main = tagName;
    section = targetSection;

    const form = targetSection.querySelector('form');
    currentForm = form;
    form.querySelector('button.public').addEventListener('click', onPost);
    form.querySelector('button.cancel').addEventListener('click', (ev) => {
        ev.preventDefault();
        form.reset();
    });
}

async function onPost(ev) {
    ev.preventDefault();
    const formData = new FormData(ev.target.parentElement.parentElement);

    const title = formData.get('topicName');
    const username = formData.get('username');
    const postText = formData.get('postText');

    const today = new Date();
    const currDate = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();

    if (title.trim() == '' || username.trim() == '' || postText.trim() == '') {
        alert('All fields are required!');
        return
    }

    try {
        const res = await fetch(baseUrl, {
            method: 'post',
            headers: { 'Content-Type': 'application.json' },
            body: JSON.stringify({
                title,
                username,
                postText,
                currDate,
            })
        });

        if (res.status !== 200) {
            throw new Error();
        }

    } catch (error) {
        alert('An error occurred! Please try again later.');
    }
    
    showTopics();
    currentForm.reset();
}

async function showTopics() {
    main.innerHTML = '';
    main.appendChild(section);

    const res = await fetch(baseUrl);
    const data = await res.json();
    
    const topics = Object.values(data).map(createTopic);

    const topicContainer = section.querySelector('div.topic-container');
    topicContainer.textContent = '';
    topicContainer.append(...topics);
}

function createTopic(topic) {
    let result = el('div', { class: 'topic-name-wrapper' },
        el('div', { class: 'topic-name' },
            el('a', { href: '#', class: 'normal' },
                el('h2', {}, topic.title)
            ),
            el('div', { class: 'columns' },
                el('div', {},
                    el('p', {},
                        'Date:',
                        el('time', {}, topic.currDate)
                    ),
                    el('div', { class: 'nick-name' },
                        el('p', {},
                            'Username: ',
                            el('span', {}, topic.username)
                        )
                    )
                ),
            )
        )
    )
    result.querySelector('a').addEventListener('click', () => comments.showComments(topic._id))
    return result;
}

export default {
    setTopic,
    showTopics,
}