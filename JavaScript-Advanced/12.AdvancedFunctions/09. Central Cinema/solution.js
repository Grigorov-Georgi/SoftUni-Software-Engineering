function solve() {
    const addSection = document.querySelectorAll('#container input');
    const nameBox = addSection[0];
    const hallBox = addSection[1];
    const ticketPriceBox = addSection[2];
    const onScreenBtn = document.querySelector('#container button');
    onScreenBtn.addEventListener('click', onClick);
    const archiveSection = document.querySelector('#archive ul');
    const clearBtn = document.querySelector('#archive button');
    console.log(clearBtn);
    clearBtn.addEventListener('click', () => {
        archiveSection.innerHTML = '';
    });
    console.log(archiveSection);

    const moviesList = document.querySelector('#movies ul');

    function onClick(ev) {
        ev.preventDefault();

        if (nameBox.value != '' && hallBox != '' && ticketPriceBox.value != '' && !isNaN(Number(ticketPriceBox.value))) {
            const element = document.createElement('li');
            element.innerHTML =
                `<span>${nameBox.value}</span>
        <strong>Hall: ${hallBox.value}</strong>
        <div>
        <strong>${Number(ticketPriceBox.value).toFixed(2)}</strong>
        <input placeholder="Tickets Sold">
        <button>Archive</button>
        </div>`
            moviesList.appendChild(element);

            const ticketSoldBtn = moviesList.querySelector('div button');
            ticketSoldBtn.addEventListener('click', ticketSoldFunc);

            nameBox.value = '';
            hallBox.value = '';
            ticketPriceBox.value = '';
        }
    }


    function ticketSoldFunc(ev) {
        const movieName = ev.target.parentNode.parentNode.querySelector('span');
        const price = ev.target.parentNode.querySelector('strong');
        const amount = ev.target.parentNode.querySelector('input');

        if (amount.value != '' && !isNaN(Number(amount.value))) {
            const newLiElement = document.createElement('li');
            newLiElement.innerHTML =
                `<span>${movieName.textContent}</span>
        <strong>Total amount: ${(Number(price.textContent) * Number(amount.value)).toFixed(2)}</strong>
        <button>Delete</button>`
            archiveSection.appendChild(newLiElement);

            const deleteBtn = newLiElement.querySelector('button');
            deleteBtn.addEventListener('click', deleteElement);

            ev.target.parentNode.parentNode.remove();
        }
    }

    function deleteElement(ev) {
        const delElement = ev.target.parentNode.remove();
    }

}
