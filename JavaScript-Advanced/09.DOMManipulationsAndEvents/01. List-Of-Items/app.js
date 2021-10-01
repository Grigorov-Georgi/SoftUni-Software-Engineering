function addItem() {
    const newItem = document.createElement('li');
    const inputValue = document.getElementById("newItemText").value;
    newItem.textContent = inputValue;

    const table = document.getElementById("items");
    table.appendChild(newItem);
}