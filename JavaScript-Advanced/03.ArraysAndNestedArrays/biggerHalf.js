function sorting(myArr){
    myArr.sort((a, b) => a - b);
    let length = myArr.length;
    return myArr.splice(length / 2);
}

console.log(sorting([3, 19, 14, 7, 2, 19, 6]));