function solve(myArr){
let secondArray = [];
for(let i = 1; i < myArr.length; i += 2){
    secondArray.push(myArr[i] * 2);
}

return secondArray.reverse();

}

console.log(solve([10, 15, 20, 25]).join(' '));