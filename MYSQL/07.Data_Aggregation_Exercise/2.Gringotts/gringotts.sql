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


