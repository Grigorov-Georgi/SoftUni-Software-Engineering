use gringotts;

SELECT 
    COUNT(*) AS 'count'
FROM
    wizzard_deposits;
    
SELECT 
    MAX(magic_wand_size) AS 'longest_magic_wand'
FROM
    wizzard_deposits;
    
SELECT 
    deposit_group, MAX(magic_wand_size) AS `longest_magic_wand`
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY `longest_magic_wand` ASC , deposit_group ASC;

SELECT 
    deposit_group
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY AVG(magic_wand_size) ASC
LIMIT 1;

SELECT 
    deposit_group, SUM(deposit_amount)
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY SUM(deposit_amount) ASC;

SELECT 
    deposit_group, SUM(deposit_amount)
FROM
    wizzard_deposits
WHERE
    magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group ASC;

SELECT 
    deposit_group, SUM(deposit_amount)
FROM
    wizzard_deposits
WHERE
    magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
HAVING SUM(deposit_amount) < 150000
ORDER BY SUM(deposit_amount) DESC;

SELECT 
    deposit_group,
    magic_wand_creator,
    MIN(deposit_charge) AS 'min_deposit_charge'
FROM
    wizzard_deposits
GROUP BY deposit_group , magic_wand_creator
ORDER BY magic_wand_creator ASC , deposit_group ASC;

SELECT 
    COUNT(id) AS wizard_count
FROM
    wizzard_deposits
GROUP BY age;

SELECT 
    CASE
        WHEN age <= 10 THEN '[0-10]'
        WHEN age <= 20 THEN '[11-20]'
        WHEN age <= 30 THEN '[21-30]'
        WHEN age <= 40 THEN '[31-40]'
        WHEN age <= 50 THEN '[41-50]'
        WHEN age <= 60 THEN '[51-60]'
        ELSE '[61+]'
    END AS 'age_group',
    COUNT(id)
FROM
    wizzard_deposits
GROUP BY age_group
ORDER BY age_group;

SELECT DISTINCT
    LEFT(first_name, 1) AS 'first_letter'
FROM
    wizzard_deposits
WHERE
    deposit_group = 'Troll Chest'
ORDER BY first_letter ASC;

SELECT
    LEFT(first_name, 1) AS 'first_letter'
FROM
    wizzard_deposits
WHERE
    deposit_group = 'Troll Chest'
GROUP BY first_letter
ORDER BY first_letter ASC;

SELECT 
    deposit_group, is_deposit_expired, AVG(deposit_interest) AS 'average_interest'
FROM
    wizzard_deposits
WHERE
    deposit_start_date > '1985/01/01'
GROUP BY deposit_group , is_deposit_expired
ORDER BY deposit_group DESC , is_deposit_expired ASC;