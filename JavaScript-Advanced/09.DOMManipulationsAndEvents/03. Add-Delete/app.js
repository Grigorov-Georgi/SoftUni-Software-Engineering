function addItem() {
    const inputValue = document.getElementById("newItemText").value;
    const newItem = document.createElement('li');
    newItem.textContent = inputValue;
    
    const button = document.createElement('a');
    button.href = '#';
    button.textContent = '[Delete]';
    button.addEventListener('click', removeElement);

    newItem.appendChild(button);

    const table = document.getElementById("items");
    table.appendChild(newItem);


    function removeElement(ev){
        const parent = ev.target.parentNode;
        parent.remove();
    }
}