function solve(array) {
    function hasWin(field, coordinates) {
        const [x, y] = coordinates;

        if (field[0][y] == field[1][y] && field[0][y] == field[2][y] && field[0][y] != false) {
            return true;
        }

        if (field[x][0] == field[x][1] && field[x][0] == field[x][2] && field[x][0] != false) {
            return true;
        }

        if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] != false) {
            return true;
        }

        if (field[0][2] == field[1][1] && field[0][2] == field[2][0] && field[0][2] != false) {
            return true;
        }

        return false;
    }

    function matrixIsFull(matrix){
        let isFull = true;
        for(let row of matrix){
            for(let col of row){
                if(col == false){
                    isFull = false;
                }
            }
        }

        return isFull;
    }

    function printResult(matrix) {
        for (let row of matrix) {
            console.log(row.join('\t'));
        }
    }

    const matrix = [[false, false, false],
    [false, false, false],
    [false, false, false]];

    let currentPlayerSign = 'X';
    let gameWon = false;

    for (let i = 0; i < array.length; i++) {
        const [x, y] = array[i].split(' ');  // const splitted = array[i].split(' ');  const x = splitted[0];  const y = splitted[1];

        if (matrix[x][y]) {
            console.log('This place is already taken. Please choose another!');
    
        } else {
            matrix[x][y] = currentPlayerSign;

            if (hasWin(matrix, [x, y])) {
                gameWon = true;
                console.log(`Player ${currentPlayerSign} wins!`)
                printResult(matrix);
                break;
            }
            currentPlayerSign = currentPlayerSign == "X" ? "O" : "X";
        }

        if(matrixIsFull(matrix)){
            break;
        }
    }

    if (!gameWon) {
        console.log("The game ended! Nobody wins :(")
        printResult(matrix);
    }

}


solve(["0 1",
"0 0",
"0 2",
"2 0",
"1 0",
"1 2",
"1 1",
"2 1",
"2 2",
"0 0"]
);