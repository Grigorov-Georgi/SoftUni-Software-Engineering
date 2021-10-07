function sum(number) {
    let sum = number;

    function add(num2) {
        sum += num2;
        return add;
    }

    add.toString = () => {
        return sum;
    }

    return add;
}

console.log(sum(1).toString());
console.log(sum(1)(6)(-3).toString());