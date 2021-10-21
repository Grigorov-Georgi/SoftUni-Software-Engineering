function solve() {
   const section = document.querySelector('main section');
   const archiveSection = document.querySelector('.archive-section ol');
   const [authorBox, titleBox, categoryBox] = Array.from(document.querySelectorAll('form p input'));
   const contentBox = document.querySelector('form p textarea');
   const createBtn = document.querySelector('form button');

   createBtn.addEventListener('click', onClick);

   function onClick(ev) {
      ev.preventDefault();
      const articleElement = document.createElement('article');
      articleElement.innerHTML =
         `<h1>${titleBox.value}</h1>
      <p>Category:
      <strong>${categoryBox.value}</strong>
      </p>
      <p>Creator:
         <strong>${authorBox.value}</strong>
      </p>
      <p>${contentBox.value}</p>
      <div class="buttons">
         <button class="btn delete">Delete</button>
         <button class="btn archive">Archive</button>
      </div>`
      section.appendChild(articleElement);

      const [deleteBtn, archiveBtn] = Array.from(articleElement.querySelectorAll('button'));
      archiveBtn.addEventListener('click', archive);
      deleteBtn.addEventListener('click', deleteAction);

      authorBox.value = '';
      titleBox.value = '';
      categoryBox.value = '';
      contentBox.value = '';
   }

   function archive(ev) {
      const title = ev.target.parentElement.parentElement.querySelector('h1');
      ev.target.parentElement.parentElement.remove();
      const liElement = document.createElement('li');
      liElement.textContent = title.textContent;
      archiveSection.appendChild(liElement);

      Array.from(archiveSection.getElementsByTagName("LI"))
         .sort((a, b) => a.textContent.localeCompare(b.textContent))
         .forEach(li => archiveSection.appendChild(li));
   }

   function deleteAction(ev) {
      ev.target.parentElement.parentElement.remove();
   }
}
