function compose(workerObj) {
    if (workerObj.dizziness == true) {
        let waterIntake = 0.1 * workerObj.weight * workerObj.experience;
        workerObj.levelOfHydrated += waterIntake;
        workerObj.dizziness = false;
    }

    return (workerObj);
}

console.log(compose({
    weight: 80,
    experience: 1,
    levelOfHydrated: 0,
    dizziness: true
}
));

console.log(compose({
    weight: 120,
    experience: 20,
    levelOfHydrated: 200,
    dizziness: true
}
));

console.log(compose({
    weight: 95,
    experience: 3,
    levelOfHydrated: 0,
    dizziness: false
}
));