window.addEventListener('load', solve);

function solve() {
    const [model, year, price] = Array.from(document.querySelectorAll('form input'));
    const description = document.querySelector('form textarea');

    const addBtn = document.querySelector('form button');
    addBtn.addEventListener('click', onClick);

    const furnitureList = document.querySelector('#furniture-list');

    let totalPrice = document.querySelector('.total-price');

    function onClick(ev) {
        ev.preventDefault();

        if (model.value != '' && description.value != '' && Number(year.value) > 0 && year.value != '' && Number(price.value) > 0 && price.value != '') {
            const infoTR = document.createElement('tr');
            infoTR.classList.add('info');
            infoTR.innerHTML =
                `<td>${model.value}</td>
            <td>${Number(price.value).toFixed(2)}</td>
            <td>
            <button class="moreBtn">More Info</button>
            <button class="buyBtn">Buy it</button>
            </td>`;

            const hideTR = document.createElement('tr');
            hideTR.classList.add('hide');
            hideTR.innerHTML =
                `<td>Year: ${year.value}</td>
            <td colspan="3">Description: ${description.value}</td>`;
            furnitureList.appendChild(infoTR);
            furnitureList.appendChild(hideTR);

            const moreInfoButtons = infoTR.querySelectorAll('button');
            moreInfoButtons[0].addEventListener('click', moreInfo);
            moreInfoButtons[1].addEventListener('click', buyFurniture);



            model.value = '';
            year.value = '';
            description.value = '';
            price.value = '';
        }


        function moreInfo(ev) {
            const moreInfoTr = ev.target.parentElement.parentElement.nextElementSibling;

            if (ev.target.textContent == 'More Info') {
                ev.target.textContent = 'Less Info';
                moreInfoTr.style.display = 'contents';
            } else {
                ev.target.textContent = 'More Info';
                moreInfoTr.style.display = 'none';
            }


        }

        function buyFurniture(ev) {
            const currPrice = ev.target.parentElement.previousElementSibling.textContent;
            totalPrice.textContent = (Number(totalPrice.textContent) + Number(currPrice)).toFixed(2);
            ev.target.parentElement.parentElement.nextElementSibling.remove();
            ev.target.parentElement.parentElement.remove();
        }

    }
}
