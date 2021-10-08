const { expect } = require('chai');
const rgbToHexColor = require('./rgbToHex').rgbToHexColor;

describe('Tests: ', () => {
    it('converts white', ()  => {
        expect(rgbToHexColor(255, 255, 255)).to.equal('#FFFFFF');
    });

    it('converts black', ()  => {
        expect(rgbToHexColor(0, 0, 0)).to.equal('#000000');
    });

    it('converts dark blue', ()  => {
        expect(rgbToHexColor(35, 68, 101)).to.equal('#234465');
    });

    it('returns invalid for missing params', ()  => {
        expect(rgbToHexColor(35, 68)).to.be.undefined;
    });

    it('returns invalid for values out of range', ()  => {
        expect(rgbToHexColor(35, 68, 11111)).to.be.undefined;
    });

    it('returns invalid for values out of range 2', ()  => {
        expect(rgbToHexColor(35, 68, -1)).to.be.undefined;
    });

    it('returns invalid param type', ()  => {
        expect(rgbToHexColor(35, 42, 'a')).to.be.undefined;
    });
})