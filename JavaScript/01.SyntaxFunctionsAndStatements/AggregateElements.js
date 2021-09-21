function arrayOperations(array){
let sum = 0;
for(let i = 0; i < array.length; i++){
    sum += array[i];
}
let inverseSum = 0;
for(let i = 0; i < array.length; i++){
    inverseSum += 1/array[i];
}
let arrayAsString = '';
for(let i = 0; i < array.length; i++){
    arrayAsString += array[i];
}
console.log(sum);
console.log(inverseSum);
console.log(arrayAsString);
}

arrayOperations([1,2,3]);