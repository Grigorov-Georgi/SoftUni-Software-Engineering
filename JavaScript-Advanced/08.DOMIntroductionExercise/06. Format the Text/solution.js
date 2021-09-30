function solve() {
  const input = document.getElementById("input").value;
  const output = document.getElementById("output");
  let result = "<p>";
  let finalString = "";
  const array = input.split(".");
  array.pop();
  
  for(let i = 0; i < array.length; i++){
    if((i + 1) % 3 == 0){
      result += `${array[i]}.</p>`;
      finalString += result;
      result = "<p>";
    } else {
      result += `${array[i]}.`
    }

    if(array.length % 3 == 1 && i == array.length - 1){
      finalString += result;
    }

    if(array.length % 3 == 2 && i == array.length - 1){
      finalString += result;
    }
    
  }

  output.innerHTML += finalString;
}