function sameNumber(num){
    let neededNumber = num % 10;
    let result = true;
    let sum = 0;
    while(num > 0){
        if(num % 10 == neededNumber){
            sum += num % 10;
            num -= num % 10;
            num /= 10;
        } else {
            result = false;
            sum += num % 10;
            num -= num % 10;
            num /= 10;
        }
    }
    console.log(result);
    console.log(sum);
}

sameNumber(1234);