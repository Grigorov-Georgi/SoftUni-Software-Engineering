function rectangle(width, height, color) {
    return {
        width,
        height,
        color: color[0].toUpperCase() + color.substring(1),
        calcArea(){
            return this.width * this.height;
        }
    }
    
    
    // let correctColor = color[0].toUpperCase() + color.substring(1);
    // let obj = {
    //     width,
    //     height,
    //     color: correctColor,
    //     calcArea() {
    //         return this.width * this.height;
    //     }
    // }

    // return obj;
}

let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());


