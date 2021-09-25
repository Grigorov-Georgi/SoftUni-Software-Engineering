function solve(array){
    function outOfBounds(x, y, matrix){
        if(x >= 0 && y >= 0 && x < matrix.length && y < matrix.length){
            return false;
        }
        return true;
    }

    function printMatrix(matrix){
        for(let row of matrix){
            console.log(row.join(' '));
        }
    }

    function matrixIsFull(rows, cols, matrix){
        for(let i = 0; i < rows; i++){
            for(let j = 0; j < cols; j++){
                if(matrix[i][j] == -1){
                    return false;
                }
            }
        }

        return true;
    }
    
    let rows = array[0];
    let cols = array[1];
    let x = array[2];
    let y = array[3];
    
    let matrix = [];
    for(let i = 0; i < rows; i++){
        matrix[i] = [];
        for(let j = 0; j < cols; j++){
            matrix[i][j] = -1;
        }
    }
    
    let number = 1;
    let range = 0;
    let oldNumber = [1];
    matrix[x][y] = number++;

    while(true){
        for(let i = - 1 - range; i <= 1 + range ; i++){
            for(let j = - 1 - range; j <= 1 + range ; j++){
                if(!outOfBounds(x + i, y + j, matrix)){
                    if(!oldNumber.includes(matrix[x + i][y + j])){
                    matrix[x + i][y + j] = number;
                    }
                }
            }
        }

        oldNumber.push(number);
        number++;
        range++;

        if(matrixIsFull(rows, cols, matrix)){
            break;
        }
    }


    printMatrix(matrix);
}

(solve([4, 4, 0, 0]));