function solve(array) {
    let catalogue = {};

    for (let townInfo of array) {
        let [townName, productName, productPrice] = townInfo.split(' | ');
        productPrice = Number(productPrice);

        if (catalogue[productName] == undefined) {
            catalogue[productName] = {};
        }

        catalogue[productName][townName] = productPrice;

    }

    for(let product in catalogue){
        let sorted = Object.entries(catalogue[product]).sort((a, b) => a[1] - b[1]);
        console.log(product + ' -> ' + sorted[0][1] + ' (' + sorted[0][0] + ')');
    }
}

solve(['Sofia City | Audi | 100000',
    'Sofia City | BMW | 100000',
    'Sofia City | Mitsubishi | 10000',
    'Sofia City | Mercedes | 10000',
    'Sofia City | NoOffenseToCarLovers | 0',
    'Mexico City | Audi | 1000',
    'Mexico City | BMW | 99999',
    'New York City | Mitsubishi | 10000',
    'New York City | Mitsubishi | 1000',
    'Mexico City | Audi | 100000',
    'Washington City | Mercedes | 1000']
);