function solve(matrix) {
    let numberOfNeighbors = 0;
    let array = [];
    for(let i = 0; i < matrix.length; i++){
        for(let j = 0; j < matrix[i].length; j++){
            if(matrix[i][j] == matrix[i + 1][j] ||
                matrix[i][j] == matrix[i - 1][j] ||
                matrix[i][j] == matrix[i][j + 1] ||
                matrix[i][j] == matrix[i][j - 1]){
                    if(!array.includes(matrix[i][j])){
                        numberOfNeighbors++;
                        array.push(matrix[i][j]);
                    }
                }
        }
    }
    return numberOfNeighbors;
}

console.log(solve([['2', '3', '4', '7', '0'],
['4', '0', '5', '3', '4'],
['2', '3', '5', '4', '2'],
['9', '8', '7', '5', '4']]));
