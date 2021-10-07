function solve(...args) {
    const baseObj = {};

    for (let arg of args) {
        if (baseObj[typeof arg] == undefined) {
            baseObj[typeof arg] = [];
        }
        baseObj[typeof arg].push(arg);
        console.log(`${typeof arg}: ${arg}`);
    }

    Object.entries(baseObj).sort((a, b) => b[1].length - a[1].length).forEach(e => console.log(`${e[0]} = ${e[1].length}`));

    return baseObj;
}

console.log(solve('cat', 'cdat', 42, function () { console.log('Hello world!'); }, 'cst'));
console.log('-----------------------------------');
console.log(solve('cat', 42, function () { console.log('Hello world!'); }));
console.log('-----------------------------------');
console.log(solve(1, 2, 3, 'cat', 'cat', 'cat'));