const numberOperations = require('./numberOperations');
const { expect } = require('chai');

describe('Test...', () => {
    describe('powNumber tests:', () => {
        it('works', () => {
            expect(numberOperations.powNumber(2)).to.be.equal(4);
            expect(numberOperations.powNumber(6)).to.be.equal(36);
            expect(numberOperations.powNumber(-1)).to.be.equal(1);
        });
    });

    describe('numberChecker tests:', () => {
        it('works', () => {
            expect(numberOperations.numberChecker(99)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker('99')).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker('99.12')).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker(111.121)).to.equal('The number is greater or equal to 100!');
        });

        it('does not work', () => {
            expect(() => numberOperations.numberChecker('a')).to.throw('The input is not a number!');
        });
    });

    describe('sumArrays tests:', () => {
        it('work', () => {
            expect(numberOperations.sumArrays([1, 2, 3], [3, 2, 1])).to.eql([4, 4, 4]);
            expect(numberOperations.sumArrays([1, 2], [3, 2, 1])).to.eql([4, 4, 1]);
            expect(numberOperations.sumArrays([1, 2, 3], [3, 2])).to.eql([4, 4, 3]);
        });
    });
})