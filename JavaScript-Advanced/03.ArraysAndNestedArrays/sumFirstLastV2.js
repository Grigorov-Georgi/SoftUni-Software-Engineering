function solve(array){
    return Number(array.pop()) + Number(array.shift());
}

console.log(solve([1, 2, 3, 4]));
console.log(solve([4]));
