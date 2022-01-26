use diablo;

SELECT 
    `name`, DATE_FORMAT(`start`, '%Y-%m-%d') as `start`
FROM
    games
WHERE
    YEAR(`start`) IN (2011 , 2012)
ORDER BY `start` ASC , `name` ASC
LIMIT 50;

SELECT 
    user_name,
    SUBSTRING(email, LOCATE('@', email) + 1) AS `email provider`
FROM
    users
ORDER BY `email provider` ASC , user_name ASC;

SELECT 
    user_name, ip_address
FROM
    users
WHERE
    ip_address LIKE '___.1%.%.___'
ORDER BY user_name ASC;

SELECT 
    `name` AS game,
    CASE
        WHEN HOUR(g.`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(g.`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END AS 'Part of the Day',
    CASE
        WHEN g.duration <= 3 THEN 'Extra Short'
        WHEN g.duration BETWEEN 4 AND 6 THEN 'Short'
        WHEN g.duration BETWEEN 7 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS 'Duration'
FROM
    games AS g;
    
    


