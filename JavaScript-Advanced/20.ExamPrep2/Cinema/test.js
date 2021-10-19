const cinema = require('./cinema');
const { expect } = require('chai');


describe("Tests...", () => {
    describe("showMovies Method", () => {
        it('works with 3 movies', () => {
            expect(cinema.showMovies(['King Kong', 'The Tomorrow War', 'Joker'])).to.equal('King Kong, The Tomorrow War, Joker');
            expect(cinema.showMovies(['King Kong'])).to.equal('King Kong');
        })

        it('does not work with empty array', () => {
            let emptyArr = [];
            expect(emptyArr.length).to.equal(0);
            expect(cinema.showMovies(emptyArr)).to.equal("There are currently no movies to show.");
        });
    });

    describe("ticketPrice Method", () => {
        it('does work with correct input', () => {
            expect(cinema.ticketPrice('Premiere')).to.equal(12.00);
            expect(cinema.ticketPrice('Normal')).to.equal(7.50);
            expect(cinema.ticketPrice('Discount')).to.equal(5.50);
        });

        it('...', () => {
            expect(() => cinema.ticketPrice('a')).to.throw("Invalid projection type.");
        });
    });

    describe("swapSeatsInHall Method", () => {
        it('...', () => {
            expect(cinema.swapSeatsInHall('a', 1)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(0, 1)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(21, 1)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1, 'a')).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1, 0)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(-2, 1)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1, -2)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1, 21)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1, 1)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(5, 5)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1.111, 1)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1, 1.1111)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1)).to.equal("Unsuccessful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1, 2)).to.equal("Successful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(20, 1)).to.equal("Successful change of seats in the hall.");
        });

        it('...', () => {
            expect(cinema.swapSeatsInHall(1, 20)).to.equal("Successful change of seats in the hall.");
        });
    });
});