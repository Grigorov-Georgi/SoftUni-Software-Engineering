class Hex {
    constructor(value) {
        this.value = value;
    }

    valueOf() {
        return this.value;
    }

    toString() {
        let result = '0x';
        result += this.value.toString(16).toUpperCase();
        return result;
    }

    static parse(string) {
        return parseInt(string, 16);
    }

    plus(hexObj) {
        return new Hex(hexObj.value + this.value);
    }

    minus(hexObj) {
        return new Hex(hexObj.value - this.value);
    }
}

let FF = new Hex(255);
console.log(FF.toString());
FF.valueOf() + 1 == 256;
let a = new Hex(10);
let b = new Hex(5);
console.log(a.plus(b).toString());
console.log(a.plus(b).toString()==='0xF');
console.log(FF.parse('AAA'));

