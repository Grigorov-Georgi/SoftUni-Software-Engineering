class Movie {
    constructor(movieName, ticketPrice) {
        this.movieName = movieName;
        this.ticketPrice = Number(ticketPrice);
        this.screenings = [];
        this.totalProfit = 0;
        this.totalTickets = 0;
    }

    newScreening(date, hall, description) {
        const obj = {
            date,
            hall,
            description
        };

        let isFound = false;
        this.screenings.forEach(s => {
            if (s.date == date && s.hall == hall) {
                isFound = true;
            }
        });
        if (isFound) {
            throw new Error(`Sorry, ${hall} hall is not available on ${date}`);
        } else {
            this.screenings.push(obj);
            return `New screening of ${this.movieName} is added.`
        }
    }

    endScreening(date, hall, soldTickets) {
        let isFound = false;
        let neededIndex = -1;
        this.screenings.forEach(s => {
            if (s.date == date && s.hall == hall) {
                isFound = true;
                neededIndex = this.screenings.indexOf(s);
            }
        });
        if (isFound) {
            let currentProfit = soldTickets * this.ticketPrice;
            this.totalProfit += currentProfit;
            this.totalTickets += soldTickets;
            this.screenings.splice(neededIndex, 1);
            return `${this.movieName} movie screening on ${date} in ${hall} hall has ended. Screening profit: ${currentProfit}`;
        } else {
            throw new Error(`Sorry, there is no such screening for ${this.movieName} movie.`);
        }
    }

    toString() {
        let result = '';

        result += `${this.movieName} full information:\n`;
        result += `Total profit: ${(this.totalProfit).toFixed(0)}$\nSold Tickets: ${this.totalTickets}\n`;
        if (this.screenings.length > 0) {
            result += "Remaining film screenings:\n";
            this.screenings.sort((a, b) => a.hall.localeCompare(b.hall)).forEach(s => result += `${s.hall} - ${s.date} - ${s.description}\n`);
        } else {
            result += "No more screenings!";
        }
        return result.trim();
    }
}

let m = new Movie('Wonder Woman 1984', '10.00');
console.log(m.newScreening('October 2, 2020', 'IMAX 3D', `3D`));
console.log(m.newScreening('October 3, 2020', 'Main', `regular`));
console.log(m.newScreening('October 4, 2020', 'IMAX 3D', `3D`));
console.log(m.endScreening('October 2, 2020', 'IMAX 3D', 150));
console.log(m.endScreening('October 3, 2020', 'Main', 78));
console.log(m.toString());

m.newScreening('October 4, 2020', '235', `regular`);
m.newScreening('October 5, 2020', 'Main', `regular`);
m.newScreening('October 3, 2020', '235', `regular`);
m.newScreening('October 4, 2020', 'Main', `regular`);
console.log(m.toString());

