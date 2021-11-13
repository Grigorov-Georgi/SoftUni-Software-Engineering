import { showDetails } from "./details.js";
import { showView } from "./dom.js";

const section = document.getElementById('edit-movie');
let targetId;
const form = section.querySelector('form');
form.addEventListener('submit', onEdit);
section.remove();

export function showEdit(movie) {
    showView(section);
    targetId = movie._id;
}

async function onEdit(ev) {
    ev.preventDefault();
    const formData = new FormData(form);
    const title = formData.get('title');
    const description = formData.get('description');
    const img = formData.get('imageUrl');

    // const body = JSON.stringify({
    //     title,
    //     description,
    //     img
    // });

    const url = `http://localhost:3030/data/movies/${targetId}`;
    const userData = JSON.parse(sessionStorage.getItem('userData'));


    try {
        const res = await fetch(url, {
            method: 'put',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': userData.token
            },
            body: JSON.stringify({
                title,
                description,
                img
            })
        });

        showDetails(targetId);
    } catch (err) {
        alert(err.message);
    }
}