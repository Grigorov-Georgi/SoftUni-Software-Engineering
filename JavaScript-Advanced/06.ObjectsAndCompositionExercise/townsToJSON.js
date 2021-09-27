function solve(arr) {
    const result = [];
    const splitted = arr[0].split('|');
    const town = splitted[1].trim();
    const latitude = splitted[2].trim();
    const longitude = splitted[3].trim();
    // console.log(town, latitude, longitude);
    for (let i = 1; i < arr.length; i++) {
        let obj = {};
        spittedEntry = arr[i].split('|');
        obj[town] = spittedEntry[1].trim();
        obj[latitude] = Number(Number(spittedEntry[2].trim()).toFixed(2));
        obj[longitude] = Number(Number(spittedEntry[3].trim()).toFixed(2));
        result.push(obj);
    }
    
    return JSON.stringify(result);
}


console.log(solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
));