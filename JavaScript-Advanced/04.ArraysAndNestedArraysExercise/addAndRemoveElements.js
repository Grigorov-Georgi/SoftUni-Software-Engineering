function solve(array){
    let initialNumber = 1;
    let newArray = [];

    for(let command of array){
        if(command == 'add'){
            newArray.push(initialNumber);
        }else{
            newArray.splice(newArray.length - 1);
        }
        initialNumber++;
    }

    if(newArray.length == 0){
        console.log('Empty');
    } else {
        console.log(newArray.join('\n'));
    }
}

solve(['add', 
'add', 
'remove', 
'add', 
'add']

);