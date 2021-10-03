function lockedProfile() {
    Array.from(document.querySelectorAll('.profile button')).forEach(a => a.addEventListener('click', onClick));

    function onClick(ev) {
        //overkill for purpose of the problem
        //const infoDif = ev.target.parentElement.querySelector('div');
        const parent = ev.target.parentElement;
        const isActive = parent.querySelector('input[type="radio"][value="unlock"]').checked;
        
        if (isActive) {
            const infoDif = Array
            .from(parent.querySelectorAll('div'))
            .find(d => d.id.includes('HiddenFields'));
            
            if (ev.target.textContent == 'Show more') {
                infoDif.style.display = 'block';
                ev.target.textContent = 'Hide it';
            } else {
                infoDif.style.display = '';
                ev.target.textContent = 'Show more';
            }
        }
    }
}