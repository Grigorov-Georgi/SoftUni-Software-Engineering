function solve(myMatrix){
    let firstDiagonal = 0;
    for(let i = 0; i < myMatrix.length; i++){
        firstDiagonal += myMatrix[i][i];
    }

    let secondDiagonal = 0;
    for(let i = 0; i < myMatrix.length; i++){
        for(let j = myMatrix.length - 1; j >= 0; j--){
            if(j + i == myMatrix.length - 1){
                secondDiagonal += myMatrix[i][j];
            }
        }
    }

    console.log(firstDiagonal + ' ' + secondDiagonal);
}

solve([[20, 40],
      [10, 60]]);