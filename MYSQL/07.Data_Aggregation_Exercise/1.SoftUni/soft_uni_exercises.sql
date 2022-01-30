use soft_uni;

SELECT 
    department_id, MIN(salary)
FROM
    employees
WHERE
    department_id IN (2 , 5, 7)
        AND DATE(hire_date) > '2000-01-01'
GROUP BY department_id
ORDER BY department_id ASC;

-- ------------------------------------
SELECT 
    department_id,
    IF(department_id = 1,
        AVG(salary) + 5000,
        AVG(salary)) AS `avg_salary`
FROM
    employees
WHERE
    salary > 30000 AND manager_id != 42
GROUP BY department_id
ORDER BY department_id;

-- ------------------------------------

SELECT 
    department_id, MAX(salary) AS `max_salary`
FROM
    employees
GROUP BY department_id
HAVING `max_salary` NOT BETWEEN 30000 AND 70000
ORDER BY department_id ASC;

-- ------------------------------------

SELECT 
    COUNT(employee_id)
FROM
    employees
WHERE
    manager_id IS NULL;
    
-- ------------------------------------

SELECT 
    department_id, SUM(salary)
FROM
    employees
GROUP BY department_id
ORDER BY department_id;

-- ------------------------------------

SELECT 
    department_id,
    (SELECT DISTINCT
            salary
        FROM
            employees AS e2
        WHERE
            e1.department_id = e2.department_id
        ORDER BY salary DESC
        LIMIT 1 OFFSET 2) AS `third_highest_salary`
FROM
    employees AS e1
GROUP BY department_id
HAVING third_highest_salary IS NOT NULL
ORDER BY department_id;

-- -----------------------------------------------

SELECT 
    e1.first_name, e1.last_name, e1.department_id
FROM
    employees as e1
        JOIN
    (SELECT 
        e2.department_id, AVG(e2.salary) AS salary
    FROM
        employees AS e2
    GROUP BY e2.department_id) AS dep_average on e1.department_id = dep_average.department_id
WHERE
    e1.salary > dep_average.salary
ORDER BY e1.department_id , e1.employee_id
LIMIT 10;

