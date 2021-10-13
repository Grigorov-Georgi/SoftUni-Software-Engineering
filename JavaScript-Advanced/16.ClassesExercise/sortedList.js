class List {
    constructor() {
        this.size = 0;
        this.numbers = [];
    }

    add(number) {
        this.numbers.push(number);
        this.numbers.sort((a, b) => a - b);
        this.size++;
    }

    get(index) {
        if (index < 0 || index >= this.size) {
            throw new Error('No such index in list');
        } else {
            return this.numbers[index];
        }
    }

    remove(index) {
        if (index < 0 || index >= this.size) {
            throw new Error('No such index in list');
        } else {
            this.numbers.splice(index, 1);
            this.size--;
        }
    }

}

let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1)); 
list.remove(1);
console.log(list.get(1));
