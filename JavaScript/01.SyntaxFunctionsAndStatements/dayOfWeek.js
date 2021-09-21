function print(dayAsString){
    let number;
switch(dayAsString){
    case 'Monday': number = 1; break; 
    case 'Tuesday': number = 2; break; 
    case 'Wednesday': number = 3; break; 
    case 'Thursday': number = 4; break; 
    case 'Friday': number = 5; break; 
    case 'Saturday': number = 6; break; 
    case 'Sunday': number = 7; break; 
    default : number = 'Invalid';
}
if(typeof(number) == 'number'){
console.log(number);
} else {
console.log('error');
}
}

print('Monday');
print('Invalid');