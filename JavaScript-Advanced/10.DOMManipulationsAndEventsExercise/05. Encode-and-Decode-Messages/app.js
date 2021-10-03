function encodeAndDecodeMessages() {
    const encodeBtn = document.querySelectorAll('button')[0];
    const decodeBtn = document.querySelectorAll('button')[1];

    encodeBtn.addEventListener('click', encode);
    decodeBtn.addEventListener('click', decode);

    const firstTextArea = document.querySelectorAll('textarea')[0];
    const secondTextArea = document.querySelectorAll('textarea')[1];

    function encode(ev) {

        let text = firstTextArea.value;
        let reworkedTextArray = [];
        for (let char of text.split('')) {
            let currentChar = char.charCodeAt(0);
            let reworkedChar = String.fromCharCode(currentChar + 1);
            reworkedTextArray.push(reworkedChar);
        }
        secondTextArea.value = reworkedTextArray.join('');
        firstTextArea.value = '';
    }


    function decode(ev) {
        let text = secondTextArea.value;
        let reworkedTextArray = [];
        for (let char of text.split('')) {
            let currentChar = char.charCodeAt(0);
            let reworkedChar = String.fromCharCode(currentChar - 1);
            reworkedTextArray.push(reworkedChar);
        }
        secondTextArea.value = reworkedTextArray.join('');
    }
}