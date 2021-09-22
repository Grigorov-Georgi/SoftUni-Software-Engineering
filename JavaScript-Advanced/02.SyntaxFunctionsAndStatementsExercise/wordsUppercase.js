function extractingWords(text){
    const words = text.toUpperCase().match(/\w+/g).join(", ");
    console.log(words);
}

extractingWords('Hi, how are you?');