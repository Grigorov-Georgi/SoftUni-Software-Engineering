const { expect } = require('chai');
const { createCalculator } = require('./addAndSubtract');

describe('Tests: ', () => {
    let instance = null;

    beforeEach(() => {
        instance = createCalculator();
    });

    it('has all properties', () => {
        expect(instance).to.has.ownProperty('add');
        expect(instance).to.has.ownProperty('subtract');
        expect(instance).to.has.ownProperty('get');
    });


    it('adds number', () => {
        instance.add(1);
        expect(instance.get()).to.equal(1);
    })

    it('adds numbers', () => {
        instance.add(1);
        instance.add(21);
        expect(instance.get()).to.equal(22);
    })

    it('subtract numbers from 100', () => {
        instance.add(100);
        instance.subtract(1);
        instance.subtract(21);
        expect(instance.get()).to.equal(78);
    })

    it('subtract number from 100', () => {
        instance.add(100);
        instance.subtract(21);
        expect(instance.get()).to.equal(79);
    })

    it('adds number as string', () => {
        instance.add('1');
        expect(instance.get()).to.equal(1);
    })
})