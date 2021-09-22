function givePreviousDay(year, month, day) {
    const date = new Date(year, month - 1, day);
    const resultDate = new Date(date);
    resultDate.setDate(date.getDate() - 1);
    console.log(`${resultDate.getFullYear()}-${resultDate.getMonth() + 1}-${resultDate.getDate()}`);
}

givePreviousDay(2016, 10, 1);