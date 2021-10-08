// function sum(arr) {
//     let sum = 0;
//     for (let num of arr){
//         sum += Number(num);
//     }
//     return sum;
// }

// module.exports = sum;

function isSymmetric(arr) {
    if (!Array.isArray(arr)){
        return false; // Non-arrays are non-symmetric
    }
    let reversed = arr.slice(0).reverse(); // Clone and reverse
    let equal = (JSON.stringify(arr) == JSON.stringify(reversed));
    return equal;
}


module.exports = isSymmetric;