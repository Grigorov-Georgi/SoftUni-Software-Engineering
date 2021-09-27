function compose(array) {
    const result = {};

    for (let i = 0; i < array.length; i += 2) {
        result[array[i]] = Number(array[i + 1]);
    }

    console.log(result);
}

compose(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);

compose(['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42']);

