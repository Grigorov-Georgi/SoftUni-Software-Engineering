const { expect } = require('chai');
const mathEnforcer = require('./module');

describe('Tests:', () => {
    describe('addFive Test', () => {
        it('should return correct result with a non-number parameter', () => {
            expect(mathEnforcer.addFive('a')).to.be.undefined;
        });

        it('works fine with number parameter', () => {
            expect(mathEnforcer.addFive(3)).to.equal(8);
        });

        it('works fine with negative number parameter', () => {
            expect(mathEnforcer.addFive(-3)).to.equal(2);
        });

        it('works fine with floating-point number parameter', () => {
            expect(mathEnforcer.addFive(3.3)).to.closeTo(8.3, 0.01);
        });
    });

    describe('subtractTen Test', () => {
        it('should return correct result with a non-number parameter', () => {
            expect(mathEnforcer.subtractTen('a')).to.be.undefined;
        });

        it('works fine with number parameter', () => {
            expect(mathEnforcer.subtractTen(11)).to.equal(1);
        });

        it('works fine with negative number parameter', () => {
            expect(mathEnforcer.subtractTen(-3)).to.equal(-13);
        });

        it('works fine with floating-point number parameter', () => {
            expect(mathEnforcer.subtractTen(3.3)).to.closeTo(-6.7, 0.01);
        });
    });

    describe('sum Test', () => {
        it('should return correct result with a non-number parameter', () => {
            expect(mathEnforcer.sum('a', 3)).to.be.undefined;
        });

        it('should return correct result with a non-number parameter', () => {
            expect(mathEnforcer.sum(3, 'asd')).to.be.undefined;
        });

        it('should return correct result with two non-number parameters', () => {
            expect(mathEnforcer.sum('a', 'b')).to.be.undefined;
        });

        it('works fine with number parameters', () => {
            expect(mathEnforcer.sum(3, 5)).to.equal(8);
        });

        it('works fine with negative number parameters', () => {
            expect(mathEnforcer.sum(-3, -19)).to.equal(-22);
        });

        it('works fine with floating-point number parameter', () => {
            expect(mathEnforcer.sum(3.3, 2.2)).to.closeTo(5.5, 0.01);
        });
    });
});


// const lookupChar = require('./module');

// describe('Tests:', () => {
//     it('does not work with non-string first parameter', () => {
//         expect(lookupChar(3, 3)).to.be.undefined;
//     });

//     it('does not work with non-string first parameter second test', () => {
//         expect(lookupChar(true, 3)).to.be.undefined;
//     });

//     it('does not work with non-string second parameter', () => {
//         expect(lookupChar('add', 'blue')).to.be.undefined;
//     });

//     it('does not work because of bigger index', () => {
//         let str = 'add';
//         let strLength = str.length;
//         expect(lookupChar(str, strLength + 1)).to.equal('Incorrect index');
//     });
//     it('does not work because of index equals length', () => {
//         let str = 'add';
//         let strLength = str.length;
//         expect(lookupChar(str, strLength)).to.equal('Incorrect index');
//     });

//     it('does not work because of negative index', () => {
//         expect(lookupChar('str', -1)).to.equal('Incorrect index');
//     });

//     it('does not work with floating-point index', () => {
//         expect(lookupChar('str', 3.3)).to.be.undefined;
//     });

//     it('works fine', () => {
//         expect(lookupChar('blue', 0)).to.equal('b');
//     })

//     it('works fine test 2', () => {
//         expect(lookupChar('red', 2)).to.equal('d');
//     })
// })



// const isOddOrEven = require('./module').isOddOrEven;

// describe("Tests:", () => {
//     it('does not work with number', () => {
//         expect(isOddOrEven(3)).to.be.undefined;
//     })

//     it('works with even string', () => {
//         expect(isOddOrEven('blue')).to.equal('even');
//     })

//     it('works with odd string', () => {
//         expect(isOddOrEven('red')).to.equal('odd');
//     })
// })
