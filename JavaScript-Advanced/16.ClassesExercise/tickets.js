function solve(array, criteria) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    const arrayOfTickets = [];

    for (let i of array) {
        const tokens = i.split('|');
        const city = tokens[0];
        const price = Number(tokens[1]);
        const status = tokens[2];

        const data = new Ticket(city, price, status);
        arrayOfTickets.push(data);
    }
    
    if (criteria == 'destination' || criteria == 'status') {
        return arrayOfTickets.sort((a, b) => a[criteria].localeCompare(b[criteria]));
    } else {
        return arrayOfTickets.sort((a, b) => a[criteria] - b[criteria]);
    }
}

console.log(solve(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'destination'
));

