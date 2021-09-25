function solve(rows, cols){
    let x = 0;
    let y = 0;
    let currentNumber = 1;
    let newStopX = 0;
    let newStopY = 0

    function printMatrix(matrix){
        for(let i = 0; i < matrix.length; i++){
            console.log(matrix[i].join(' '));
        }
    }

    function outOfBounds(x, y, matrix){
        if(x >= 0 && y >= 0 && x < matrix.length && y < matrix.length){
            return false;
        }
        return true;
    }

    let matrix = [];
    for(let i = 0; i < rows; i++){
        matrix[i] = [];
        for(let j = 0; j < cols; j++){
            matrix[i][j] = -1;
        }
    }
    matrix[x][y] = currentNumber++;
    while(true){

        
        while(y + 1 < matrix[0].length && matrix[x][y + 1] == -1){
            y++;
            matrix[x][y] = currentNumber++;
        }
        
        while(x + 1 < matrix.length && matrix[x + 1][y] == -1){
            x++;
            matrix[x][y] = currentNumber++;
        }

        while(y - 1 >= 0 && matrix[x][y - 1] == -1){
            y--;
            matrix[x][y] = currentNumber++;
        }
        
        while(x - 1 >= 0 && matrix[x - 1][y] == -1){
            x--;
            matrix[x][y] = currentNumber++;
        }

        if(currentNumber == rows * cols + 1){
            break;
        }
    }

    printMatrix(matrix);
}

solve(3, 7);