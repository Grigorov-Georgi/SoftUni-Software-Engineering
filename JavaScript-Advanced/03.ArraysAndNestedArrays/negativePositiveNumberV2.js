function solve(array){
    let newArray = [];

    for(let item of array){
        if(item >= 0){
            newArray.push(item);
        } else {
            newArray.unshift(item);
        }
    }
    return newArray;
}

console.log(solve([7, -2, 8, 9]));