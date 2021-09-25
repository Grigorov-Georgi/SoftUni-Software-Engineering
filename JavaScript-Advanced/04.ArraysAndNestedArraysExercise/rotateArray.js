function rotateArray(array, timesOfRotation){
    for(let i = 0; i < timesOfRotation; i++){
        let lastElement = array.pop();
        array.unshift(lastElement);
    }
    console.log(array.join(' '));
}

rotateArray(['Banana', 
'Orange', 
'Coconut', 
'Apple'], 
15
);