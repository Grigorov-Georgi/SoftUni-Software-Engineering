function makeSquareOfStars(n){
    let neededString = '';
    for(let j = 0; j < n; j++){
        neededString += '* ';
    }
    for(let i = 0; i < n; i++){
        console.log(neededString);
    }
}

makeSquareOfStars(5);