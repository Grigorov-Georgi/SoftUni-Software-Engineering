function walk(steps, meters, km) {
    let totalMeters = steps * meters;
    let time = Math.round(totalMeters / km * 3.6);
    time += Math.floor(totalMeters / 500) * 60;


    let result =new Date(time * 1000).toISOString().substr(11, 8)
    console.log(result);
}

walk(4000, 0.60, 5);
