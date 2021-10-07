function solve(...args) {
    let strings = 0;
    let functions = 0;
    let numbers = 0;

    for (let arg of args) {
        if (typeof (arg) == 'function') {
            functions++;
            console.log(`function: ${arg}`);
        } else if (typeof arg == 'number') {
            numbers++;
            console.log(`number: ${arg}`);
        } else {
            strings++;
            console.log(`string: ${arg}`);
        }
    }
    let obj = {
        string: strings,
        number: numbers,
        function: functions
    }

    Object.entries(obj).sort((a, b) => {
        if (b[1] > a[1]) {
            return b[1];
        } else if (a[1] >= b[1]) {
            return a[1];
        }
    })
        .forEach(d => {
            let type = d[0];
            if (strings != 0 && type == 'string') {
                console.log('string = ' + strings);
            }
            if (numbers != 0 && type == 'number') {
                console.log('number = ' + numbers);
            }
            if (functions != 0 && type == 'function') {
                console.log('function = ' + functions);
            }
        });
}

solve('cat', 'cat', 'cat', 42, 42, 42, function () { console.log('Hello world!'); });

function solve(...input) {
    let typeValue = [];
    let typesCount = {};

    input.forEach(el => {
        let type = typeof el;
        if (!typesCount.hasOwnProperty(type)) {
            typesCount[type] = 0;
        }
        typesCount[type]++;

        let typeValueAsString = type === 'object' ? `${type}:` : `${type}: ${el}`;
        typeValue.push(typeValueAsString);
    });

    typeValue.forEach(el => {
        console.log(el);
    });

    let sortedTypes = Object.keys(typesCount).sort((a, b) => typesCount[b] - typesCount[a]);
    sortedTypes.forEach(key => {
        console.log(`${key} = ${typesCount[key]}`);
    });
}