function solve(input){
    let innerCollection = []

    let commands = {
        add: (value) => {
            innerCollection.push(value);
        },
        remove: (value) => {
            innerCollection = innerCollection.filter(data => data != value);
        },
        print: () => {
            console.log(innerCollection.join(','));
        }
    }

    for(let args of input){
        let [command, value] = args.split(' ');
        commands[command](value);
    }
}



solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);

console.log('----------------------------------------')

solve(['add pesho', 'add george', 'add peter', 'remove peter','print']);