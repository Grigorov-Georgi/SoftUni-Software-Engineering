class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
    }

    increase(value) {
        this.innerLength += value;
    }

    decrease(value) {
        if (this.innerLength - value <= 0) {
            this.innerLength = 0;
        } else {
            this.innerLength -= value;
        }
    }

    toString() {
        let result = '';

        if (this.innerString.length <= this.innerLength) {
            result = this.innerString;
        } else {
            for(let i = 0; i < this.innerLength; i++){
                result += this.innerString[i];
            }
            result += '...';
        }
        return result;
    }
}

let test = new Stringer("Test", 5);
console.log(test.toString()); // Test

test.decrease(3);
console.log(test.toString()); // Te...

test.decrease(5);
console.log(test.toString()); // ...

test.increase(4); 
console.log(test.toString()); // Test

