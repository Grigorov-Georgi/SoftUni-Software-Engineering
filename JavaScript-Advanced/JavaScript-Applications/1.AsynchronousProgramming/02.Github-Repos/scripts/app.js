function loadRepos() {
	const username = document.getElementById('username').value;
	const url = `https://api.github.com/users/${username}/repos`;

	fetch(url)
		.then(res => {
			if (res.ok == false) {
				throw new Error(`${res.status} ${res.statusText}`);
			}
			return res.json()
		})
		.then(data => handleResponse(data))
		.catch(err => console.log(err));

	function handleResponse(data) {
		const list = document.getElementById('repos');
		list.innerHTML = '';
		
		for (let repo of data) {
			const liElement = document.createElement('li');
			liElement.innerHTML = 
			`<a href="${repo.html_url}">
            ${repo.full_name}
            </a>`;
			list.appendChild(liElement);
		}
	}
}