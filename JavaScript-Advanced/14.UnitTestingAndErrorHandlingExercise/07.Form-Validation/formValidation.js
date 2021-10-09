function validate() {
    const userNameRegex = /(^[a-zA-Z0-9]{3,20}$)/;
    const passwordRegex = /(^[\w]{5,15}$)/;
    const emailRegex = /^[\w]+@[\w]+.[\w]+$/;

    const isValidInput = true;
    const isChecked = false;

    const submitButton = document.getElementById('submit');
    submitButton.addEventListener('click', (ev) => {
        ev.preventDefault();
        const userNameField = document.getElementById('username');
        if (!userNameRegex.test(userNameField.value)) {
            isValidInput = false;
            userNameField.style.borderColor = 'red';
        } else {
            userNameField.style.border = 'none';
        }

        const passwordField = document.getElementById('password');
        const confirmPasswordField = document.getElementById('confirm-password');

        if (!passwordRegex.test(passwordField.value)) {
            isValidInput = false;
            passwordField.style.borderColor = 'red';
        } else {
            passwordField.style.border = 'none';
        }

        if (passwordField.value != confirmPasswordField.value) {
            isValidInput = false;
            confirmPasswordField.style.borderColor = 'red';
        } else {
            confirmPasswordField.style.border = 'none';
        }

        const emailField = document.getElementById('email');
        if (!emailRegex.test(emailRegex)) {
            isValidInput = false;
            emailField.style.borderColor = 'red';
        } else {
            emailField.style.border = 'none';
        }

        const validDiv = document.getElementById('valid');
        if (isValidInput) {
            validDiv.style.display = 'block';
        } else {
            validDiv.style.display = 'none';
        }

        if (isChecked) {
            const cNumber = document.getElementById('companyNumber');
            if (Number(cNumber.value) < 1000 || Number(cNumber.value) > 9999) {
                cNumber.style.borderColor = 'red';
            } else {
                cNumber.style.border = 'none';
            }
        }
    })

    document.getElementById('company').addEventListener('change', (ev) => {
        const companyField = document.getElementById('companyInfo');

        if (ev.target.checked) {
            isChecked = true;
            companyField.style.display = 'block';
        } else {
            isChecked = false;
            companyField.style.display = 'none';
        }
    })
}
