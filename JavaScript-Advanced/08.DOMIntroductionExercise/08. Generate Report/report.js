function generateReport() {
    const boxes = Array.from(document.querySelectorAll("tbody tr td"));
    let array = [];
    for (let i = 0; i < boxes.length; i += 7) {
        let object = {
            employee: boxes[i].value,
            department: boxes[i + 1].value,
            status: boxes[i + 2].value,
            date: boxes[i + 3].value,
            benefits: boxes[i + 4].value,
            compensation: boxes[i + 5].value,
            rating: boxes[i + 6].value
        }
        array.push(object);
    }

    
    let employeeCheckBox = document.getElementsByName("employee");
    let departmentCheckBox = document.getElementsByName("department");
    let statusCheckBox = document.getElementsByName("status");
    let dateHiredCheckBox = document.getElementsByName("dateHired");
    let benefitsCheckBox = document.getElementsByName("benefits");
    let salaryCheckBox = document.getElementsByName("salary");
    let ratingCheckBox = document.getElementsByName("rating");

    let arrayWithNeededInfo = [];
    if (employeeCheckBox[0].checked) {
        arrayWithNeededInfo.push("employee");
    }
    if (departmentCheckBox[0].checked) {
        arrayWithNeededInfo.push("department");
    }
    if (statusCheckBox[0].checked) {
        arrayWithNeededInfo.push("status");
    }
    if (dateHiredCheckBox[0].checked) {
        arrayWithNeededInfo.push("date");
    }
    if (benefitsCheckBox[0].checked) {
        arrayWithNeededInfo.push("benefits");
    }
    if (salaryCheckBox[0].checked) {
        arrayWithNeededInfo.push("compensation");
    }
    if (ratingCheckBox[0].checked) {
        arrayWithNeededInfo.push("rating");
    }
    console.log(arrayWithNeededInfo);

    const result = document.getElementById("output");
    let string = "";
    for (let person of array) {
        let resultObj = {};
        for (let element of arrayWithNeededInfo) {
            resultObj[element] = person[element];
        }
        string += JSON.stringify(resultObj, null, 2) + '\n';
    }
    result.value = string;
}