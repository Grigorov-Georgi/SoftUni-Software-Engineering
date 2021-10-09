function validate() {
    const inputField = document.getElementById('email');

    const validEmailPattern = /^[\w]+[@][\w]+[.][\w]+$/gm
    inputField.addEventListener('change', () => {
        if(!validEmailPattern.test(inputField.value)){
            inputField.classList.add('error');
        } else {
            inputField.classList.remove('error');
        }
    });
}