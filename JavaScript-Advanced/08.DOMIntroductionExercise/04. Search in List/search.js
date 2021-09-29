function search() {
   const towns = document.querySelectorAll("ul li");
   const input = document.getElementById("searchText").value;
   let count = 0;

   for(let town of Array.from(towns)){
      if(town.textContent.includes(input)){
         town.style.fontWeight = "bold";
         town.style.textDecoration = "underline";
         count++;
      } else {
         town.style.fontWeight = "normal";
         town.style.textDecoration = "";
      }
   }
   
   document.getElementById("result").innerHTML = count + " matches found"; 
}
