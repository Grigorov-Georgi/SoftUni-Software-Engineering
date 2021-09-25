function solve(array) {
    let newArray = [];
    newArray.push(array[0]);
    let currentIndex = 0;
    for (let i = 1; i < array.length; i++) {
    
        if (array[i] >= newArray[currentIndex]) {
            newArray.push(array[i]);
            currentIndex++;
        }
    }
    return newArray;
}


console.log(solve([20, 
    3, 
    2, 
    15,
    6, 
    1]
    
))