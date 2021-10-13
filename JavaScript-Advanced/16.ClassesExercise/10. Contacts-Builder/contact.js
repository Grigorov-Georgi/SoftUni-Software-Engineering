class Contact{
    constructor(firstName, lastName, phone, email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this._online = false;
    }

    set online(value){
        if(this.titleDiv && value == false){
            this.titleDiv.classList.remove('online');
        } else {
            this.titleDiv.classList.add('online');
        }
        this._online = value;
    }

    render(id){
        const article = document.createElement('article');
        this.titleDiv = document.createElement('div');
        this.titleDiv.classList.add('title');
        this.titleDiv.innerHTML = `${this.firstName} ${this.lastName}<button>&#8505</button>`;
        
        const button = document.querySelector('.title button');
        button.addEventListener('click', () => {
            infoDiv.style.display = infoDiv.style.display == 'none' ? 'block' : 'none';
        })

        if(this._online){
            this.titleDiv.classList.add('online');
        }

        const infoDiv = document.createElement('div');
        infoDiv.classList.add('info');
        infoDiv.style.display = 'none';
        infoDiv.innerHTML = `<span>&phone; ${this.phone}</span><span>&#9993; ${this.email}</span>`

        article.appendChild(this.titleDiv);
        article.appendChild(infoDiv);

        document.getElementById(id).appendChild(article);
    }
}