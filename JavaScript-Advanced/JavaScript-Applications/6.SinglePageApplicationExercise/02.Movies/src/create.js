import { showView } from "./dom.js";
import { showHome } from "./home.js";

const section = document.getElementById('add-movie');
const form = section.querySelector('form');
form.addEventListener('submit', onClick);
section.remove();

export function showCreate() {
    showView(section);
}

async function onClick(ev) {
    ev.preventDefault();

    const formData = new FormData(form);

    const title = formData.get('title');
    const description = formData.get('description');
    const imageUrl = formData.get('imageUrl');

    if (title.trim() == '' || description.trim() == '' || imageUrl.trim() == '') {
        alert('All fields are required!!');
        return;
    }
    const userData = JSON.parse(sessionStorage.getItem('userData'));
    
    try {
        const res = await fetch('http://localhost:3030/data/movies ', {
            method: "post",
            headers: {
                'Content-Type': 'application.json',
                'X-Authorization': userData.token
            },
            body: JSON.stringify({
                title,
                description,
                imageUrl,
                _ownerId: userData.id
            })
        });

        if (res.ok != true) {
            throw Error('The server does not respond, please, try again later');
        }

        if (res.status == 401) {
            throw Error('Unauthorized! You must be login to do that action!');
        }

        form.reset();
        showHome();
    } catch (err) {
        alert(err.message);
    }
}