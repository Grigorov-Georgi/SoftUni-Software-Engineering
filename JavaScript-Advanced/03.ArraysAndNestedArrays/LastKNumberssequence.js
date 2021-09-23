function solve(n, k){
    let array = [1];
    for(let i = 0; i < n - 1; i++){
        let nextNumber = 0;
        for(let j = 0; j < k; j++){
            if(i - j >= 0){
                nextNumber += array[i - j];
            }
        }
        array.push(nextNumber);
    }
    return array;
}

console.log(solve(8, 2));