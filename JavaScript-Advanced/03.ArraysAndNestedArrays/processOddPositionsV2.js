function solve(myArr){
    return myArr.filter((v, i) => i % 2 != 0).map(n => n * 2).reverse().join(' ');
}

console.log(solve([1, 4, 5, 6]));