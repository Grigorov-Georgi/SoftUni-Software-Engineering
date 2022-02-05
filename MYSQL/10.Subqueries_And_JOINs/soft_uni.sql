use soft_uni;

SELECT 
    e.employee_id,
    CONCAT_WS(' ', e.first_name, e.last_name) AS `full_name`,
    d.department_id,
    d.`name` AS `department_name`
FROM
    departments AS d
        JOIN
    employees AS e ON d.manager_id = e.employee_id
ORDER BY e.employee_id
LIMIT 5;

-- ----------------------------------------------------

SELECT 
    t.town_id, t.name, a.address_text
FROM
    towns AS t
        JOIN
    addresses AS a ON a.town_id = t.town_id
WHERE
    t.name IN ('San Francisco' , 'Sofia', 'Carnation')
ORDER BY t.town_id ASC , a.address_id ASC;

-- ---------------------------------------------------

SELECT 
    COUNT(*) AS `count`
FROM
    employees
WHERE
    salary > (SELECT 
            AVG(salary)
        FROM
            employees);

-- ----------------------------------------------------

SELECT 
    employee_id, first_name, last_name, department_id, salary
FROM
    employees
WHERE
    manager_id IS NULL;