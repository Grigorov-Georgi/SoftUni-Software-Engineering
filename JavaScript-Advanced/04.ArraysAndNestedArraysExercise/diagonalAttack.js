function solve(matrix) {
    function transformMatrix(matrix) {
        let reworkedMatrix = [];
        for (let i = 0; i < matrix.length; i++) {
            reworkedMatrix[i] = matrix[i].split(' ').map(n => Number(n));
        }
        return reworkedMatrix;
    }

    function printMatrix(matrix) {
        for (let row of matrix) {
            console.log(row.join(' '));
        }
    }

    matrix = transformMatrix(matrix);
    let sumOfPrimaryDiagonal = 0;
    let sumOfSecondaryDiagonal = 0;
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (i == j) {
                sumOfPrimaryDiagonal += matrix[i][j];
            }
            if (i + j + 1 == matrix.length) {
                sumOfSecondaryDiagonal += matrix[i][j];
            }
        }
    }
    if (sumOfPrimaryDiagonal == sumOfSecondaryDiagonal) {
        for (let i = 0; i < matrix.length; i++) {
            for (let j = 0; j < matrix[i].length; j++) {
                if (i != j && i + j + 1 != matrix.length) {
                    matrix[i][j] = sumOfPrimaryDiagonal;
                }
            }
        }

    }
    printMatrix(matrix);

}

solve(['5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1']
);

solve(['1 1 1',
    '1 1 1',
    '1 1 0']
);