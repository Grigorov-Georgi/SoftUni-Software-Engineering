function solve(array){
    let newArray = [];
    for(let number of array){
        if(number < 0){
            let oldLength = newArray.length;
            let position = 1;
            for(let i = oldLength; i >= 1 ; i--){
                newArray[oldLength - position + 1] = newArray[oldLength - position++];
            }
            newArray[0] = number;
            position = 1;
        } else {
            newArray.push(number);
        }
    }
    return newArray;
}

for(let number of solve([3, -2, 0, -1])){
    console.log(number);
}