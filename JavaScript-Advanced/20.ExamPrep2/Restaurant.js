class Restaurant {
    constructor(budgetMoney) {
        this.budgetMoney = Number(budgetMoney);
        this.menu = {};
        this.stockProducts = {};
        this.history = [];
    }

    loadProducts(products) {
        const result = [];
        for (let current of products) {
            let [productName, productQuantity, productTotalPrice] = current.split(' ');
            productTotalPrice = Number(productTotalPrice);
            if (productTotalPrice <= this.budgetMoney) {
                if (this.stockProducts[productName] == undefined) {
                    this.stockProducts[productName] = 0;
                }
                this.stockProducts[productName] += Number(productQuantity);
                this.budgetMoney -= productTotalPrice;
                result.push(`Successfully loaded ${productQuantity} ${productName}`)
                this.history.push(`Successfully loaded ${productQuantity} ${productName}`);
            } else {
                result.push(`There was not enough money to load ${productQuantity} ${productName}`);
                this.history.push(`There was not enough money to load ${productQuantity} ${productName}`);
            }
        }
        return result.join('\n');
    }

    addToMenu(meal, neededProducts, price) {
        if (this.menu[meal] == undefined) {
            this.menu[meal] = {
                products: neededProducts,
                price: price
            }

            if (Object.keys(this.menu).length == 1) {
                return `Great idea! Now with the ${meal} we have 1 meal in the menu, other ideas?`;
            } else {
                return `Great idea! Now with the ${meal} we have ${Object.keys(this.menu).length} meals in the menu, other ideas?`;
            }
        } else {
            return `The ${meal} is already in the our menu, try something different.`;
        }
    }

    showTheMenu() {
        if (Object.keys(this.menu).length == 0) {
            return `Our menu is not ready yet, please come later...`
        } else {
            let result = [];
            for (let meal of Object.entries(this.menu)) {
                result.push(`${meal[0]} - $ ${meal[1].price}`)
            }
            return result.join('\n');
        }
    }

    makeTheOrder(meal) {
        if (this.menu[meal] != undefined) {
            let neededProducts = this.menu[meal].products; //array {name} {productQuantity}
            for (let product of neededProducts) {
                let [name, quantity] = product.split(' ');
                quantity = Number(quantity);
                if (this.stockProducts[name] != undefined) {
                    if (this.stockProducts[name] >= quantity) {
                        this.stockProducts[name] -= quantity;
                    } else {
                        return `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
                    }
                } else {
                    return `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
                }
            };
            this.budgetMoney += this.menu[meal].price;
            return `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${this.menu[meal].price}.`;

        } else {
            return `There is not ${meal} yet in our menu, do you want to order something else?`;
        };
    }

}


let kitchen = new Restaurant(1000);
kitchen.loadProducts(['Yogurt 30 3', 'Honey 50 4', 'Strawberries 20 10', 'Banana 5 1']);
kitchen.addToMenu('frozenYogurt', ['Yogurt 1', 'Honey 1', 'Banana 1', 'Strawberries 10'], 9.99);
console.log(kitchen.makeTheOrder('frozenYogurt'));



