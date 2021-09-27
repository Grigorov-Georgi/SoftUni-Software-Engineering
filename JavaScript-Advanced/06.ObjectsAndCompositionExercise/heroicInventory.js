function register(array) {
    const heroRegister = [];

    for (let data of array) {
        const arr = data.split(' / ');
        let name = arr[0];
        let level = Number (arr[1]);
        let items = arr[2];
        items = items ? items.split(', ') : [];
        // if(arr[2].length >= 1){
        // items = arr[2].split(', ');
        // } else {
        //     items = [];
        // }

        heroRegister.push(composeHero(name, level, items));
    }
    function composeHero(name, level, items) {
        const hero = {
            name,
            level,
            items
        };

        return hero;
    }

    return JSON.stringify(heroRegister);
}

console.log(register(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']
));

console.log(register(['Jake / 1000 / ']));