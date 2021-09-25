function solve(matrix){
    let equalSumOfRows = true;
    let equalSumOfCols = true;
    let sumOfRow = 0;
    let sumOfCol = 0;

    for(let i = 0; i < matrix.length; i++){
        let currentSumRow = 0;
        for(let j = 0; j < matrix[i].length; j++){
            currentSumRow += matrix[i][j];
        }
        if(i == 0){
            sumOfRow = currentSumRow;
        } else {
            if(sumOfRow != currentSumRow){
                equalSumOfRows = false;
            }
        }
    }

    for(let i = 0; i < matrix.length; i++){
        let currentSumCol = 0;
        for(let j = 0; j < matrix[i].length; j++){
            currentSumCol += matrix[j][i];
        }
        if(i == 0){
            sumOfCol = currentSumCol;
        } else {
            if(sumOfCol != currentSumCol){
                equalSumOfCol = false;
            }
        }
    }
    
    if(equalSumOfRows && equalSumOfCols && sumOfRow == sumOfCol){
        return true;
    } else {
        return false;
    }
}

console.log(solve([[1, 0, 0],
    [0, 0, 1],
    [0, 1, 0]]     
   ));