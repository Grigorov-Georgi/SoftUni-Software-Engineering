function solve(area, vol, input) {
    const cubes = JSON.parse(input);
    const arrayOfObjects = [];

    for (let cube of cubes) {
        const cubeArea = area.apply(cube);
        const cubeVolume = vol.apply(cube);
        const obj = {
            area: cubeArea,
            volume: cubeVolume
        }
        arrayOfObjects.push(obj);
    }

    return arrayOfObjects;
}

function area() {
    return Math.abs(this.x * this.y);
};

function vol() {
    return Math.abs(this.x * this.y * this.z);
};

solve(area, vol, `[
    {"x":"1","y":"2","z":"10"},
    {"x":"7","y":"7","z":"10"},
    {"x":"5","y":"2","z":"10"}
    ]`
);
