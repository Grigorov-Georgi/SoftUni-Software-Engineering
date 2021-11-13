import { updateNav } from "./app.js";
import { showView } from "./dom.js";
import { showHome } from "./home.js";

const section = document.getElementById('form-sign-up');
const form = section.querySelector('form');
form.addEventListener('submit', onClick);
section.remove();

export function showRegister() {
    showView(section);
}

async function onClick(ev) {
    ev.preventDefault();
    const formData = new FormData(form);
    const email = formData.get('email');
    const password = formData.get('password');
    const repass = formData.get('repeatPassword');

    if (email.trim() == '' || password.trim() == '' || repass.trim() == '') {
        alert('All fields are required!');
        return;
    }

    if (password != repass) {
        alert('Passwords don\'t match!');
        return;
    }

    if (password.length < 6) {
        alert('Password must be at least 6 symbols!');
        return;
    }

    try {
        const res = await fetch('http://localhost:3030/users/register', {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password })
        });

        if(res.ok != true){
            const error = await res.json();
            throw new Error(error.message);
        }

        const data = await res.json();

        sessionStorage.setItem('userData', JSON.stringify({
            email: data.email,
            id: data._id,
            token: data.accessToken
        }));

        form.reset();
        updateNav();
        showHome();

    } catch (err) {
        alert(err.message);
    }
}