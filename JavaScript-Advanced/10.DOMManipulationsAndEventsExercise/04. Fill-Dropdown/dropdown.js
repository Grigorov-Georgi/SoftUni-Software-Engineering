function addItem() {
    const newTextItem = document.getElementById('newItemText');
    const newValueItem = document.getElementById('newItemValue');

    const optionCell = document.createElement('option');
    const selectMenu = document.getElementById('menu');

    optionCell.value = newValueItem.value;
    optionCell.textContent = newTextItem.value;
    selectMenu.appendChild(optionCell);

    newTextItem.value = '';
    newValueItem.value = '';

}