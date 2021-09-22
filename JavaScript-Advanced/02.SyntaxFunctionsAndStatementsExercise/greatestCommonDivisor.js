function gcd(num1, num2){
    let greatestDivider;
    if(num1 >= num2){
    for(let i = 1; i <= num1; i++){
        if(num1 % i == 0 && num2 % i == 0){
            greatestDivider = i;
        }
    }
    } else {
        for(let i = 1; i <= num2; i++){
            if(num1 % i == 0 && num2 % i == 0){
                greatestDivider = i;
            }
        }
    }
    console.log(greatestDivider);
}

gcd(2154, 458);