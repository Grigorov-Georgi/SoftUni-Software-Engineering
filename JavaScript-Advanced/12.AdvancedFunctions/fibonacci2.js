function getFibonator(){
    let n1 = 0;
    let n2 = 1;

    function nextNumberFunction(){
        let nextN = n1 + n2;
        n1 = n2;
        n2 = nextN;
        return n1;
    }

    return nextNumberFunction;
}


let fib = getFibonator();
console.log(fib()); // 1
console.log(fib()); // 1
console.log(fib()); // 2
console.log(fib()); // 3
console.log(fib()); // 5
console.log(fib()); // 8
console.log(fib()); // 13
