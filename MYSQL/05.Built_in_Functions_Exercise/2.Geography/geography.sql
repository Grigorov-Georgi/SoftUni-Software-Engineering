use geography;

SELECT country_name, iso_code FROM countries
WHERE country_name LIKE '%a%a%a%'
ORDER BY iso_code ASC;

SELECT 
    p.peak_name,
    r.river_name,
    LOWER(CONCAT(peak_name, SUBSTRING(river_name, 2))) AS `mix`
FROM
    peaks AS p,
    rivers AS r
WHERE
    LOWER(RIGHT(p.peak_name, 1)) = LOWER(LEFT(r.river_name, 1))
ORDER BY mix ASC;