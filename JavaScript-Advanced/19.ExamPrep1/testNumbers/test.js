const testNumbers = require('./testNumbers');
const { expect } = require('chai');

describe('Test Numbers', () => {
    describe('sumNumbers', () => {
        it('works with valid numbers', () => {
            expect(testNumbers.sumNumbers(3, 5)).to.equal('8.00');
            expect(testNumbers.sumNumbers(-3, 5)).to.equal('2.00');
        });

        it('does not work with non-numerical params', () => {
            expect(testNumbers.sumNumbers('a', 5)).to.be.undefined;
            expect(testNumbers.sumNumbers(4, 'a')).to.be.undefined;
            expect(testNumbers.sumNumbers('a', 'b')).to.be.undefined;
            expect(testNumbers.sumNumbers('a', true)).to.be.undefined;
            expect(testNumbers.sumNumbers('a', false)).to.be.undefined;
        });

        it('returns a number rounded to second number after decimal point', () => {
            expect(testNumbers.sumNumbers(3, 5)).to.equal('8.00');
            let result = testNumbers.sumNumbers(3, 5);
            expect(result.length).to.equal(4);
            expect(typeof result).to.equal('string');
        });
    });

    describe('NumberChecker', () => {
        it('works with numbers', () => {
            expect(testNumbers.numberChecker(3)).to.equal("The number is odd!");
            expect(testNumbers.numberChecker(2)).to.equal("The number is even!");
        });

        it('works with from strubg parsed numbers', () => {
            expect(testNumbers.numberChecker('3')).to.equal("The number is odd!");
            expect(testNumbers.numberChecker('272')).to.equal("The number is even!");
        });

        it('does not work with strings that are not numbers', () => {
            expect(() => testNumbers.numberChecker('aa')).to.throw('The input is not a number!');
        });
        // it('does not work with booleans', () => {
        //     expect(() => testNumbers.numberChecker(false)).to.throw('The input is not a number!');
        // });
    });

    describe('averageSumArray', () => {
        it('works with an array', () => {
            expect(testNumbers.averageSumArray([1, 2, 3])).to.equal(2);
            expect(testNumbers.averageSumArray([4, 4, 4, 4])).to.equal(4);
        });
    });
})