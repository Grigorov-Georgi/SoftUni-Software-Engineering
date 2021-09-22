function validityChecker(x1, y1, x2, y2){
    if(Number.isInteger(((x1 ** 2) + (y1 ** 2)) ** (1/2))){
        console.log('{' + x1 + ', ' + y1 + '} to {0, 0} is valid');
    } else {
        console.log('{' + x1 + ', ' + y1 + '} to {0, 0} is invalid');
    }

    if(Number.isInteger(((x2 ** 2) + (y2 ** 2)) ** (1/2))){
        console.log('{' + x2 + ', ' + y2 + '} to {0, 0} is valid');
    } else {
        console.log('{' + x2 + ', ' + y2 + '} to {0, 0} is invalid');
    }

    let c1 = Math.abs(x1 - y1);
    let c2 = Math.abs(x2 - y2);

    if(Number.isInteger(((c1 ** 2) + (c2 ** 2)) ** (1/2))){
        console.log('{' + x1 + ', ' + y1 + '}' + ' to {' + x2 + ', ' + y2 + '} is valid');
    } else {
        console.log('{' + x1 + ', ' + y1 + '}' + ' to {' + x2 + ', ' + y2 + '} is invalid');
    }

}

validityChecker(2, 1, 1, 4);