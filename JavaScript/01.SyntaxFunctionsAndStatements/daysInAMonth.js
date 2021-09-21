function getDays(month, year){
    const d = new Date(year, month, 0).getDate(); 
    console.log(d);
}

getDays(1, 2012);
