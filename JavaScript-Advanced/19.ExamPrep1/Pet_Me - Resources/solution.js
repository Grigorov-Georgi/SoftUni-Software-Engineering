function solve() {
    const [nameBox, ageBox, kindBox, ownerBox] = Array.from(document.querySelectorAll('#add input'));
    const addBtn = document.querySelector('#add button');
    const petList = document.querySelector('#adoption ul');
    const adoptedList = document.querySelector('#adopted ul');



    addBtn.addEventListener('click', onClick);

    function onClick(ev) {
        ev.preventDefault();

        if (nameBox.value != '' && ageBox.value != '' && !isNaN(Number(ageBox.value)) && kindBox.value != '' && ownerBox.value != '') {

            const element = document.createElement('li');
            element.innerHTML =
                `<p><strong>${nameBox.value}</strong> is a <strong>${ageBox.value}</strong> year old <strong>${kindBox.value}</strong></p><span>Owner: ${ownerBox.value}</span><button>Contact with owner</button>`;
            petList.appendChild(element);

            const contactBtn = element.querySelector('button');
            contactBtn.addEventListener('click', contact);

            nameBox.value = '';
            ageBox.value = '';
            kindBox.value = '';
            ownerBox.value = '';

            function contact(ev) {
                const div = document.createElement('div');
                div.innerHTML =
                    `<input placeholder="Enter your names">
                <button>Yes! I take it!</button>`
                element.appendChild(div);
                element.removeChild(contactBtn);

                const textBox = element.querySelector('div input');
                const takeItBtn = element.querySelector('div button');
                takeItBtn.addEventListener('click', takeIt.bind(null, textBox, element));
            }
        }

        function takeIt(textBox, element) {
            if (textBox.value.trim() != '') {
                const checkBtn = document.createElement('button');
                checkBtn.innerHTML = 'Checked';
                element.querySelector('span').innerHTML = `New Owner: ${textBox.value}`;
                element.querySelector('div').remove();
                element.appendChild(checkBtn);

                adoptedList.appendChild(element);
                checkBtn.addEventListener('click', () => {
                    element.remove();
                });
            }
        }



    }
}

