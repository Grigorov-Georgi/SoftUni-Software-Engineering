function solve(array, type){
    if(type == 'asc'){
        array.sort((a, b) => a - b);
    } else {
        array.sort((a, b) => b - a);
    }

    return array;
}


console.log(solve([14, 7, 17, 6, 8], 'asc'));
console.log(solve([14, 7, 17, 6, 8], 'desc'));