function extractText() {
    const items = document.getElementById('items').children;
    const result = [];

    for (let item of items) {
        result.push(item.textContent);
    }

    document.getElementById('result').textContent = result.join('\n');

}