use restaurant;

SELECT 
    department_id, COUNT(id) AS `Nuber of employees`
FROM
    employees
GROUP BY department_id;

SELECT 
    department_id, ROUND(AVG(salary), 2) AS `Average Salary`
FROM
    employees
GROUP BY department_id;

SELECT 
    department_id, MIN(salary) AS `Min Salary`
FROM
    employees
GROUP BY department_id
HAVING `Min Salary` > 800;

SELECT 
    COUNT(id) AS `Count`
FROM
    products
WHERE
    price > 8
GROUP BY category_id
HAVING category_id = 2;

SELECT 
    category_id,
    ROUND(AVG(price), 2) AS `Average Price`,
    ROUND(MIN(price), 2) AS `Cheapest Product`,
    ROUND(MAX(price), 2) AS `Most Expensive Product`
FROM
    products
GROUP BY category_id;