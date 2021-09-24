function solve(matrix){
    let maximum = Number.MIN_SAFE_INTEGER;


    for(let i = 0; i < matrix.length; i++){
        for(let j = 0; j < matrix[i].length; j++){
            if(matrix[i][j] > maximum){
                maximum = matrix[i][j];
            }
        }
    }
    

    console.log(maximum);
}

solve([[1, 22, 3], [2, 444, 234]]);