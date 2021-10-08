const { expect } = require('chai');
//Sum of Numbers Tests

// const sum = require('./myModule');
// describe('Test', () => {
//     it('works with 2 and 3', () => {
//         expect(sum([2, 3])).to.equal(5);
//     });

//     it('works with 0', () => {
//         expect(sum([0])).to.equal(0);
//     });

//     it('works with more than 2 parameters', () => {
//         expect(sum([2, 3, 4, 5, 6])).to.equal(20);
//     });

//     it('works with array of string numbers', () => {
//         expect(sum(['2', '1'])).to.equal(3);
//     });
// });

//Check for Symmetry

const isSymmetric = require('./myModule');

describe('Symmetry Testing', () => {
    it('returns true for symmetric array of even number of numerical elements', () => {
        expect(isSymmetric([1, 2, 2, 1])).to.be.true;
    });

    it('returns true for symmetric array of odd number of numerical elements', () => {
        expect(isSymmetric([1, 2, 3, 2, 1])).to.be.true;
    });

    it('returns true for symmetric array of strings', () => {
        expect(isSymmetric(['a', 'b', 'b', 'a'])).to.be.true;
    });

    it('returns false for symmetric string', () => {
        expect(isSymmetric('sos')).to.be.false;
    });

    it('returns false for type different array', () => {
        expect(isSymmetric([1, 2, 2, '1'])).to.be.false;
    });

    it('Input is not an array', () => {
        expect(isSymmetric('a')).to.be.false;
    });

    it('Input is not an array', () => {
        expect(isSymmetric([1, 3, 2, 1])).to.be.false;
    });
});