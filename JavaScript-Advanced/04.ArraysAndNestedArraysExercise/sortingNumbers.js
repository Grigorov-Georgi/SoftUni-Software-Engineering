function solve(array) {
    array.sort((a, b) => a - b);
    let newArray = [];

    for (let i = 0; i < array.length / 2; i++) {
        newArray.push(array[i]);
        if (array.length % 2 == 0 || array[i] != array[array.length - i - 1]) {
            newArray.push(array[array.length - i - 1]);
        }
    }

    return newArray;
}

console.log(solve([1, 2, 3, 4]));