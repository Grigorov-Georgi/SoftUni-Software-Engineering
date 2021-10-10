function returnArrayOfPersons() {
    class Person {
        constructor(firstName, lastName, age, email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.email = email;
        }

        toString() {
            return (`${this.firstName} ${this.lastName} (age: ${this.age}, email: ${this.email})`)
        }
    }

    const arrayOfPersons = [];

    arrayOfPersons.push(new Person('Anna', 'Simpson', 22, 'anna@yahoo.com'));
    arrayOfPersons.push(new Person('Softuni'));
    arrayOfPersons.push(new Person('steohan', 'Johanson', 25));
    arrayOfPersons.push(new Person('Gabriel', 'Peterson', 24, 'g.p@gmail.com'));

    return arrayOfPersons;
}

console.log(returnArrayOfPersons());