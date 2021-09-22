function neededTime(steps, stepLength, speedInKMH) {
    let speed = speedInKMH / 3.6;
    let distance = steps * stepLength;
    let breakTime = Math.floor(distance / 500) * 60;
    let totalTimeInSeconds = breakTime + Math.ceil(distance / speed);

    let hrs = ~~(totalTimeInSeconds / 3600);
    let mins = ~~((totalTimeInSeconds % 3600) / 60);
    let secs = ~~totalTimeInSeconds % 60;


    let ret = "";
    if (hrs > 0) {
        if (hrs > 9) {
            ret += "" + hrs + ":" + (mins < 10 ? "0" : "");
        } else{
            ret += "0" + hrs + ":" + (mins < 10 ? "0" : "");
        }
    } else {
        ret += '00:';
    }
    ret += "" + mins + ":" + (secs < 10 ? "0" : "");
    ret += "" + secs;

    console.log(ret);
}

neededTime(4000, 0.60, 5);