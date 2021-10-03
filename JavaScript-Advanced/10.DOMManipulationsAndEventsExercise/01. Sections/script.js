function create(words) {
   const content = document.getElementById('content');

   for (let i = 0; i < words.length; i++) {
      const currentDiv = document.createElement('div');
      const currentPara = document.createElement('p');
      currentPara.textContent = words[i];
      currentDiv.appendChild(currentPara);

      currentPara.style.display = 'none';

      content.appendChild(currentDiv);
   }

   content.addEventListener('click', onClick);

   function onClick(ev) {
      if (ev.target.tagName == 'DIV' && ev.target != content) {
         const neededPara = ev.target.children[0];
         neededPara.style.display = '';
      }
   }
}