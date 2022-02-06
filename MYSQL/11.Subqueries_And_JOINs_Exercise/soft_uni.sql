use soft_uni;

SELECT 
    e.employee_id, e.job_title, a.address_id, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a USING (address_id)
ORDER BY address_id ASC
LIMIT 5;

-- ---------------------------------------------------------

SELECT 
    e.first_name, e.last_name, t.`name`, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a USING (address_id)
        JOIN
    towns AS t USING (town_id)
ORDER BY first_name ASC , last_name ASC
LIMIT 5;

-- --------------------------------------------------------

SELECT 
    e.employee_id, e.first_name, e.last_name, d.`name`
FROM
    employees AS e
        JOIN
    departments AS d USING (department_id)
WHERE
    d.`name` LIKE 'Sales'
ORDER BY employee_id DESC;

-- ------------------------------------------------------

SELECT 
    e.employee_id, e.first_name, e.salary, d.`name`
FROM
    employees AS e
        JOIN
    departments AS d USING (department_id)
WHERE
    e.salary > 15000
ORDER BY department_id DESC
LIMIT 5;

-- ------------------------------------------------------

SELECT 
    e.employee_id, e.first_name
FROM
    employees AS e
        LEFT JOIN
    employees_projects AS ep USING (employee_id)
WHERE
    ep.project_id IS NULL
ORDER BY employee_id DESC
LIMIT 3;

-- ------------------------------------------------------

SELECT 
    first_name, last_name, hire_date, d.`name`
FROM
    employees
        JOIN
    departments AS d USING (department_id)
WHERE
    DATE(hire_date) > 1999 - 01 - 01
        AND d.`name` IN ('Sales' , 'Finance')
ORDER BY hire_date ASC;

-- ----------------------------------------------------

SELECT 
    e.employee_id, e.first_name, p.`name`
FROM
    employees AS e
		JOIN
    employees_projects AS ep USING (employee_id)
        JOIN
    projects AS p USING (project_id)
WHERE
    p.start_date > '2002-08-13 23:59:59'
        AND p.end_date IS NULL
ORDER BY e.first_name ASC , p.`name` ASC
LIMIT 5;

-- -------------------------------------------------

SELECT 
    employee_id,
    first_name,
    CASE
        WHEN YEAR(p.start_date) >= 2005 THEN NULL
        ELSE p.`name`
    END AS `project_name`
FROM
    employees
        LEFT JOIN
    employees_projects AS ap USING (employee_id)
        LEFT JOIN
    projects AS p USING (project_id)
WHERE
    employee_id = 24
ORDER BY p.`name` ASC;

-- ----------------------------------------------

SELECT 
    e.employee_id,
    e.first_name,
    e.manager_id,
    (SELECT 
            first_name
        FROM
            employees AS e1
        WHERE
            e1.employee_id = e.manager_id)
FROM
    employees AS e
WHERE
    manager_id IN (3 , 7)
ORDER BY e.first_name ASC;

-- ---------------------------------------------

SELECT 
    e.employee_id,
    CONCAT_WS(' ', e.first_name, e.last_name) as `employee_name`,
    (SELECT 
            concat_ws(' ', first_name, last_name) as `manager_name`
        FROM
            employees AS e1
        WHERE
            e1.employee_id = e.manager_id) as `manager_name`,
    d.`name`
FROM
    employees AS e
        JOIN
    departments AS d USING (department_id)
WHERE
    e.manager_id IS NOT NULL
ORDER BY employee_id asc
LIMIT 5;

-- ------------------------------------------------------------------

SELECT 
    AVG(salary)
FROM
    employees
GROUP BY department_id
ORDER BY AVG(salary) ASC
LIMIT 1; 