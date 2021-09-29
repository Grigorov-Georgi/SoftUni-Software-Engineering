function extract(content) {
    const text = document.getElementById(content).textContent;

    const result = '';
    const pattern = /\((.+?)\)/g;

    let match = pattern.exec(text);

    while(match != null){
        result += match[1];
        result += '; ';
        match = pattern.exec(text);
    }

    return result;
}