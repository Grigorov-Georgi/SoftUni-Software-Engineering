function solve() {
    const openSection = Array.from(document.querySelectorAll('section'))[1];
    const inProgressSection = Array.from(document.querySelectorAll('section'))[2];
    const completeSection = Array.from(document.querySelectorAll('section'))[3];

    const taskBox = document.getElementById('task');
    const descriptionBox = document.getElementById('description');
    const dateBox = document.getElementById('date');
    const addBtn = document.getElementById('add');

    addBtn.addEventListener('click', onClick);

    function onClick(ev) {
        ev.preventDefault();

        if (taskBox.value != '' && taskBox.value != '' && dateBox.value != '') {
            const articleElement = document.createElement('article');
            articleElement.innerHTML =
                `<h3>${taskBox.value}</h3>
            <p>Description: ${descriptionBox.value}</p>
            <p>Due Date: ${dateBox.value}</p>
            <div class="flex">
                <button class="green">Start</button>
                <button class="red">Delete</button>
            </div>`;

            const neededDiv = openSection.querySelectorAll('div')[1];
            neededDiv.appendChild(articleElement);

            const [leftBtn, rightBtn] = Array.from(articleElement.querySelectorAll('button'));
            leftBtn.addEventListener('click', start);
            rightBtn.addEventListener('click', deleteArticle);

            taskBox.value = '';
            descriptionBox.value = '';
            dateBox.value = '';
        }
    }

    function deleteArticle(ev) {
        ev.target.parentElement.parentElement.remove();
    }

    function start(ev) {
        const neededDiv = document.getElementById('in-progress');

        const currentArticle = ev.target.parentElement.parentElement;
        neededDiv.appendChild(currentArticle);

        ev.target.remove();

        const finishBtn = document.createElement('button');
        finishBtn.textContent = 'Finish';
        finishBtn.className = 'orange';
        currentArticle.querySelector('.flex').appendChild(finishBtn);
        finishBtn.addEventListener('click', finish);

    }

    function finish(ev){
        const neededDiv = completeSection.querySelectorAll('div')[1];

        const currentArticle = ev.target.parentElement.parentElement;
        neededDiv.appendChild(currentArticle);

        currentArticle.querySelector('.flex').remove();
        
    }
}