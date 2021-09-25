function solve(array, number){
    let newArray = [];
    for(let i = 0; i < array.length; i += number){
        newArray.push(array[i]);
    }
    return newArray;
}

console.log(solve(['1', 
'2',
'3', 
'4', 
'5'], 
6
));