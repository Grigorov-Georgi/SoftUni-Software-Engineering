(function solve() {

    Array.prototype.last = function () {
        return this[this.length - 1];
    }

    Array.prototype.skip = function (n) {
        const newArr = [];
        for (let i = n; i < this.length; i++) {
            newArr.push(this[i]);
        }
        return newArr;
    }

    Array.prototype.take = function (n) {
        const newArr = [];
        for (let i = 0; i < n; i++) {
            newArr.push(this[i]);
        }
        return newArr;
    }

    Array.prototype.sum = function () {
        let total = 0;
        for (let i of this) {
            total += i;
        }
        return total;
    }

    Array.prototype.average = function () {
        let total = 0;
        for (let i of this) {
            total += i;
        }
        return total / this.length;
    }

})();
let array = [1, 2, 3];
console.log(array.average());
// let getLastElement = array.last();
// console.log(getLastElement);
// let newArray = array.skip(1);
// for (let i of newArray) {
//     console.log(i);
// }