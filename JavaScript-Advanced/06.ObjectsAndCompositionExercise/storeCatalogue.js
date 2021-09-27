function solve(arr) {
    const productCatalogue = {};

    arr.forEach(element => {
        let [productName, price] = element.split(' : ');
        price = Number(price);
        const index = productName[0];
        if (!productCatalogue[index]) {
            productCatalogue[index] = {};
        }

        productCatalogue[index][productName] = price;
    });

    let initialSort = Object.keys(productCatalogue).sort((a,b) => a.localeCompare(b));

    for(let key of initialSort){
        let currentArrayOfObjects = productCatalogue[key];
        let secondSort = Object.keys(currentArrayOfObjects).sort((a, b) => a.localeCompare(b));

        console.log(key);
        for(let part of secondSort){
            console.log(`  ${part}: ${productCatalogue[key][part]}`)
        }
    }

}

solve(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']
);