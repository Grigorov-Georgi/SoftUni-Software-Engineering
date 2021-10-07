function solution() {
    //apple - made with 1 carbohydrate and 2 flavour
    //lemonade - made with 10 carbohydrate and 20 flavour
    //burger - made with 5 carbohydrate, 7 fat and 3 flavour
    //eggs - made with 5 protein, 1 fat and 1 flavour
    //turkey - made with 10 protein, 10 carbohydrate, 10 fat and 10 flavour


    const recipeLibrary = {
        apple: { carbohydrate: 1, flavour: 2 },
        lemonade: { carbohydrate: 10, flavour: 20 },
        burger: { carbohydrate: 5, fat: 7, flavour: 3 },
        eggs: { protein: 5, fat: 1, flavour: 1 },
        turkey: { protein: 10, carbohydrate: 10, fat: 10, flavour: 10 }
    };

    const robotStorage = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    }

    function closureFunc(str) {
        let tokens = str.split(' ');
        let command = tokens[0];

        switch (command) {
            case 'restock':
                let microelement = tokens[1];
                let quantity = Number(tokens[2]);
                robotStorage[microelement] += quantity;
                return 'Success';
                break;
            case 'prepare':
                let recipe = tokens[1];
                let quantity2 = Number(tokens[2]);
                const neededElements = recipeLibrary[recipe];
                for (let curr of Object.entries(neededElements)) {
                    if (curr[1] * quantity2 > robotStorage[curr[0]]) {
                        return `Error: not enough ${curr[0]} in stock`;
                    } else {
                        robotStorage[curr[0]] -= curr[1] * quantity2;
                    }
                }
                return 'Success';
                break;
            case 'report':
                return `protein=${robotStorage['protein']} carbohydrate=${robotStorage['carbohydrate']} fat=${robotStorage['fat']} flavour=${robotStorage['flavour']}`
                break;
        }
    }

    return closureFunc;
}

let manager = solution();

console.log(manager("restock flavour 50"));
console.log(manager("prepare lemonade 4"));
console.log(manager("restock carbohydrate 10"));
console.log(manager("restock flavour 10"));
console.log(manager("prepare apple 1"));
console.log(manager("restock fat 10"));
console.log(manager("prepare burger 1"));
console.log(manager("report"));
