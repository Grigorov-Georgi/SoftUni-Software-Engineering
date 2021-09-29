function solve() {
  const text = document.getElementById("text").value;
  const splittedText = text.split(" ");
  let resultString = "";
  const neededConvention = document.getElementById("naming-convention").value;
  let result = document.getElementById("result");
  if(neededConvention == "Pascal Case"){
    for(let i = 0; i < splittedText.length; i++){
      resultString += splittedText[i][0].toUpperCase() + splittedText[i].slice(1).toLowerCase();
    }
    result.textContent = resultString;
  }else if(neededConvention == "Camel Case"){
    resultString += splittedText[0].toLowerCase();
    for(let i = 1; i < splittedText.length; i++){
      resultString += splittedText[i][0].toUpperCase() + splittedText[i].slice(1).toLowerCase();
    }
    result.textContent = resultString;
  }else{
    result.textContent = "Error!";
  }
}