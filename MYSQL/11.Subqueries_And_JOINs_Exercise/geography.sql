use geography;

SELECT 
    mc.country_code, m.mountain_range, p.peak_name, p.elevation
FROM
    mountains AS m
        JOIN
    mountains_countries AS mc ON m.id = mc.mountain_id
        JOIN
    peaks AS p USING (mountain_id)
WHERE
    mc.country_code LIKE 'BG'
        AND p.elevation > 2835
ORDER BY elevation DESC;

-- --------------------------------------------------------------

SELECT 
    mc.country_code, COUNT(m.mountain_range)
FROM
    mountains AS m
        JOIN
    mountains_countries AS mc ON m.id = mc.mountain_id
WHERE
    mc.country_code in ('BG', 'US', 'RU')
GROUP BY country_code
ORDER BY COUNT(m.mountain_range) DESC;

-- -------------------------------------------------------------

SELECT 
    c.country_name, r.river_name
FROM
    countries AS c
        LEFT JOIN
    countries_rivers AS cr USING (country_code)
        LEFT JOIN
    rivers AS r ON r.id = cr.river_id
WHERE
    c.continent_code = 'AF'
ORDER BY country_name ASC
LIMIT 5;

-- -------------------------------------------------------------

SELECT 
    COUNT(*)
FROM
    countries AS c
        LEFT JOIN
    mountains_countries AS mc USING (country_code)
WHERE
    mountain_id IS NULL
GROUP BY mc.mountain_id;

-- -------------------------------------------------------------

SELECT 
    c.country_name, MAX(p.elevation), MAX(r.length)
FROM
    countries AS c
        LEFT JOIN
    countries_rivers AS cr USING (country_code)
        LEFT JOIN
    rivers AS r ON cr.river_id = r.id
        LEFT JOIN
    mountains_countries AS mc USING (country_code)
        LEFT JOIN
    peaks AS p ON mc.mountain_id = p.mountain_id
GROUP BY c.country_name
ORDER BY MAX(p.elevation) DESC , MAX(r.length) DESC , c.country_name ASC
Limit 5;

-- ----------------------------------------------------------------------

SELECT 
    c.continent_code,
    countries.currency_code,
    COUNT(*) AS `currency_usage`
FROM
    continents AS c
        JOIN
    countries USING (continent_code)
GROUP BY c.continent_code , countries.currency_code
HAVING COUNT(*) > 1
    AND currency_usage = (SELECT 
        COUNT(*)
    FROM
        countries AS c2
    WHERE
        c2.continent_code = c.continent_code
    GROUP BY c2.currency_code
    ORDER BY COUNT(*) DESC
    LIMIT 1)
ORDER BY c.continent_code ASC , countries.currency_code ASC;