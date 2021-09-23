function printEvenIndexes(stringArray){
    let result = '';

    for(let i = 0; i < stringArray.length; i += 2){
        result += stringArray[i] + ' ';
    }
    console.log(result);
}

printEvenIndexes(['5', '10']);