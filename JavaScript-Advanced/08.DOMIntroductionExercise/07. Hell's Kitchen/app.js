function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
      let inputArray = JSON.parse(document.querySelector("textarea").value);
      let restaurantsMap = {};

      for (let restaurant of inputArray) {
         let elements = restaurant.split(" - ");
         let restaurantsName = elements[0];
         let workersAndSalary = elements[1].split(", ");

         if (restaurantsMap[restaurantsName] == undefined) {
            restaurantsMap[restaurantsName] = {};
         }

         let obj = {}
         for (let worker of workersAndSalary) {
            let tokens = worker.split(" ");
            let workerName = tokens[0];
            let workerSalary = Number(tokens[1]);
            obj[workerName] = workerSalary;
         }
         restaurantsMap[restaurantsName] = obj;
      }

      let bestRestaurant = [];

      for (let restaurant in restaurantsMap) {
         let averageSalary = 0;
         let total = 0;
         let numberOfWorkers = 0;

         Object.entries(restaurantsMap[restaurant]).forEach(el => {
            total += el[1]
            numberOfWorkers++;
         });

         averageSalary = total / numberOfWorkers;
         if (bestRestaurant.length == 0) {
            bestRestaurant.push(restaurant);
            bestRestaurant.push(averageSalary);
         }
         if (bestRestaurant[1] < averageSalary) {
            bestRestaurant[0] = restaurant;
            bestRestaurant[1] = averageSalary;
         }
      }
      let resultAsString = "";
      Object.entries(restaurantsMap[bestRestaurant[0]]).sort((a, b) => {
         b[1] - a[1];
      }).forEach(el => {
         resultAsString += `Name: ${el[0]} With Salary: ${el[1]} `;
      });

      let biggestSalary = Number(resultAsString.split(" ")[4]).toFixed(2);

      // let result1 = document.getElementById("bestRestaurant").children[2];
      let result1 =  document.querySelector('#bestRestaurant p');
      result1.textContent = `Name: ${bestRestaurant[0]} Average Salary: ${bestRestaurant[1].toFixed(2)} Best Salary: ${biggestSalary}`;

      // let result2 = document.getElementById("workers").children[2];
      let result2 = document.querySelector('#workers p');
      result2.textContent = resultAsString.trim();

   }
}