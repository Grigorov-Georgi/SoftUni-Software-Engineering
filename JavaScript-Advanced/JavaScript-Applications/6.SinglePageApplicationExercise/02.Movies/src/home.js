import { showCreate } from "./create.js";
import { showView, e } from "./dom.js";
import { showDetails } from "./details.js";


const section = document.getElementById('home-page');
const catalog = document.querySelector('.card-deck.d-flex.justify-content-center');
catalog.addEventListener('click', (ev) => {
    ev.preventDefault();
    let target = ev.target;
    
    if(target.tagName == 'BUTTON'){
        target = target.parentElement;
    }

    if(target.tagName == 'A'){
        const id = target.dataset.id;
        showDetails(id);
    }
})

section.querySelector('#createLink').addEventListener('click', (ev) => {
    ev.preventDefault();
    showCreate();
});
section.remove();

export function showHome() {
    showView(section);
    getMovies();
}

async function getMovies() {
    const url = 'http://localhost:3030/data/movies';

    const res = await fetch(url);
    const data = await res.json();

    catalog.replaceChildren(...data.map(createMovieCard));
}

function createMovieCard(movie) {
    const element = e('div', { className: 'card mb-4' });
    element.innerHTML = 
    `<img class="card-img-top" src="${movie.img}"
        alt="Card image cap" width="400">
    <div class="card-body">
        <h4 class="card-title">${movie.title}</h4>
    </div>
    <div class="card-footer">
        <a data-id=${movie._id} href="#">
            <button type="button" class="btn btn-info">Details</button>
        </a>
    </div>`
    
    return element;
}
window.getMovies = getMovies;