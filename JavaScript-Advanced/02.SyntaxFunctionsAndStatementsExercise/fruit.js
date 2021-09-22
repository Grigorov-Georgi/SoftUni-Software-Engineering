function calculatePrise(fruit, weight, pricePerKilogram){
    let kilograms = weight / 1000; 
    let total = kilograms * pricePerKilogram;
    console.log(`I need $${total.toFixed(2)} to buy ${kilograms.toFixed(2)} kilograms ${fruit}.`)
}

calculatePrise('orange', 2500, 1.80); 