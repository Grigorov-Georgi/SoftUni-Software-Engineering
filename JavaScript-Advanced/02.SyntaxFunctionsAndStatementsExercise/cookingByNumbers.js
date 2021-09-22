function cooking(number, op1, op2, op3, op4, op5){
    let num = parseInt(number);

    switch(op1){
        case 'chop': num /= 2; break;
        case 'dice': num **= 1/2; break;
        case 'spice': num += 1; break;
        case 'bake': num *= 3; break;
        case 'fillet': num *= 0.8; break;
    }

    console.log(num.toFixed(1));

    switch(op2){
        case 'chop': num /= 2; break;
        case 'dice': num **= 1/2; break;
        case 'spice': num += 1; break;
        case 'bake': num *= 3; break;
        case 'fillet': num *= 0.8; break;
    }

    console.log(num.toFixed(1));

    switch(op3){
        case 'chop': num /= 2; break;
        case 'dice': num **= 1/2; break;
        case 'spice': num += 1; break;
        case 'bake': num *= 3; break;
        case 'fillet': num *= 0.8; break;
    }

    console.log(num.toFixed(1));

    switch(op4){
        case 'chop': num /= 2; break;
        case 'dice': num **= 1/2; break;
        case 'spice': num += 1; break;
        case 'bake': num *= 3; break;
        case 'fillet': num *= 0.8; break;
    }

    console.log(num.toFixed(1));

    switch(op5){
        case 'chop': num /= 2; break;
        case 'dice': num **= 1/2; break;
        case 'spice': num += 1; break;
        case 'bake': num *= 3; break;
        case 'fillet': num *= 0.8; break;
    }

    console.log(num.toFixed(1));

}

cooking('9', 'dice', 'spice', 'chop', 'bake', 'fillet');