function solve(array) {
    const sorted = array.sort(function (a, b){
        if (a.length > b.length) {
            return 1;
        } else if (b.length > a.length) {
            return -1;
        }

        return a.localeCompare(b);
    });

    console.log(sorted.join('\n'));
}

solve(['alpha',
    'beta',
    'gamma']
);