import { showView, e } from "./dom.js";
import { showHome } from "./home.js";
import { showEdit } from "./edit.js";

const section = document.getElementById('movie-details');
section.remove();

export function showDetails(id) {
    showView(section);
    getMovie(id);
}

async function getMovie(id) {
    const requests = [
        fetch('http://localhost:3030/data/movies/' + id),
        fetch(`http://localhost:3030/data/likes?where=movieId%3D%22${id}%22&distinct=_ownerId&count`)
    ];

    const userData = JSON.parse(sessionStorage.getItem('userData'));
    if (userData != null) {
        requests.push(fetch(`http://localhost:3030/data/likes?where=movieId%3D%22${id}%22%20and%20_ownerId%3D%22${userData.id}%22&count`))
    }

    const [movieRes, likesRes, hasLikedRes] = await Promise.all(requests);

    const [movieData, likes, hasLiked] = await Promise.all([
        movieRes.json(),
        likesRes.json(),
        hasLikedRes && hasLikedRes.json()
    ]);

    section.replaceChildren(createDetails(movieData, likes, hasLiked));

}

function createDetails(movie, likes, hasLiked) {
    const controls = e('div', { className: 'col-md-4 text-center' },
        e('h3', { className: 'my-3' }, 'Movie Description'),
        e('p', {}, movie.description)
    );

    const userData = JSON.parse(sessionStorage.getItem('userData'));

    if (userData != null) {
        if (userData.id == movie._ownerId) {
            const deleteA = e('a', { className: 'btn btn-danger', href: '#' }, 'Delete');
            controls.appendChild(deleteA);
            deleteA.addEventListener('click', () => {
                deleteMovie(movie._id);
            });

            const editA = e('a', { className: 'btn btn-warning', href: '#' }, 'Edit');
            controls.appendChild(editA);
            editA.addEventListener('click', async () => showEdit(movie));

        } else {
            if (hasLiked) {
                controls.appendChild(e('a', { className: 'btn btn-primary', href: '#' }, 'Unlike'));
            } else {
                controls.appendChild(e('a', { className: 'btn btn-primary', href: '#', onClick: onLike }, 'Like'));
            }

        }
    }
    controls.appendChild(e('span', { className: 'enrolled-span' }, `Liked ${likes}`));

    const element = e('div', { className: 'container' },
        e('div', { className: 'row bg-light text-dark' },
            e('h1', {}, `Movie title: ${movie.title}`),
            e('div', { className: 'col-md-8' },
                e('img', { className: 'img-thumbnail', src: movie.img, alt: 'Movie' })
            ),
            controls
        )
    );

    return element;

    async function onLike() {
        await fetch('http://localhost:3030/data/likes', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': userData.token
            },
            body: JSON.stringify({
                movieId: movie._id
            })
        });
        showDetails(movie._id);
    }

    async function deleteMovie(targetId) {
        const res = await fetch('http://localhost:3030/data/movies/' + targetId, {
            method: 'delete',
            headers: { 'X-Authorization': userData.token }
        });
        showHome();
    }
}




/* <div class="container">
    <div class="row bg-light text-dark">
        <h1>Movie title: Black Widow</h1>
        <div class="col-md-8">
            <img class="img-thumbnail"
                src="https://miro.medium.com/max/735/1*akkAa2CcbKqHsvqVusF3-w.jpeg" alt="Movie">
        </div>
        <div class="col-md-4 text-center">
            <h3 class="my-3 ">Movie Description</h3>
            <p>Natasha Romanoff aka Black Widow confronts the darker parts of her ledger when a
                dangerous
                conspiracy
                with ties to her past arises. Comes on the screens 2020.</p>
            <a class="btn btn-danger" href="#">Delete</a>
            <a class="btn btn-warning" href="#">Edit</a>
            <a class="btn btn-primary" href="#">Like</a>
            <span class="enrolled-span">Liked 1</span>
        </div>
    </div>
</div> */