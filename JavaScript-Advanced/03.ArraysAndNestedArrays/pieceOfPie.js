function solve(myArr, pie1, pie2){
    let index1 = myArr.indexOf(pie1);
    let index2 = myArr.indexOf(pie2);
    return myArr.splice(index1, index2 - index1 + 1);
}

console.log(solve(['Pumpkin Pie',
'Key Lime Pie',
'Cherry Pie',
'Lemon Meringue Pie',
'Sugar Cream Pie'],
'Key Lime Pie',
'Lemon Meringue Pie'
));