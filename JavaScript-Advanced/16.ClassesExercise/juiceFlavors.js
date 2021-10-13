function solve(array){
    let bottles = new Map();
    const juices = {};

    for(let pair of array){
        let [product, count] = pair.split(' => ');
        count = Number(count);
        if(!juices[product]){
            juices[product] = 0;
        }
        juices[product] += count;

        if(juices[product] >= 1000){
            let newBottles = Math.floor(juices[product] / 1000);
            juices[product] %= 1000;
            if(!bottles.has(product)){
                bottles.set(product, 0);
            }
            bottles.set(product, bottles.get(product) + newBottles);  
        }
    }
    for(let curr of bottles){
        console.log(curr[0] + " => " + curr[1]);
    }
    
}


solve(['Orange => 2000',
'Peach => 1432',
'Banana => 450',
'Peach => 600',
'Strawberry => 549']);


solve(['Kiwi => 234',
'Pear => 2345',
'Watermelon => 3456',
'Kiwi => 4567',
'Pear => 5678',
'Watermelon => 6789']
);