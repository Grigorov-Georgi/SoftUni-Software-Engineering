function toggle() {
    let button1 = (document.getElementsByClassName("button"));
    let text = document.getElementById("extra");

    if(button1[0].textContent == "More"){
        console.log("changed to less");
        button1[0].textContent = "Less";
        text.style.display = 'block';
    } else {
        button1[0].textContent = "More";
        text.style.display = 'none';
    }
}