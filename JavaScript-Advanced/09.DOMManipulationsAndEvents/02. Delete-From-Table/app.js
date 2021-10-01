function deleteByEmail() {
    // const neededEmail = document.querySelector("input").value;
    // const namesAndEmails = document.querySelectorAll("td");

    // let emailFound = false;
    // for (let i = 1; i < namesAndEmails.length; i += 2) {
    //     if (namesAndEmails[i].textContent == neededEmail) {
    //         namesAndEmails[i].remove();
    //         namesAndEmails[i - 1].remove();
    //         emailFound = true;
    //     }
    // }
    // const result = document.getElementById("result");
    // if (emailFound) {
    //     result.textContent = "Deleted.";
    // } else {
    //     result.textContent = "Not found.";
    // }

    const inputText = document.querySelector('input[name="email"]').value;
    
    const rows = Array.from(document.querySelector('tbody').children)
    .filter(r => r.children[1].textContent == inputText);
    rows.forEach(r => r.remove());

    document.getElementById("result").textContent = rows.length > 0 ? "Deleted." : "Not found.";
}




