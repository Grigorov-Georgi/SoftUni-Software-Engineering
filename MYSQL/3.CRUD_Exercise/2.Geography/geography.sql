SELECT * FROM geography.peaks;

SELECT peak_name FROM peaks ORDER BY peak_name ASC;

SELECT country_name, population FROM countries 
WHERE continent_code = 'EU' 
ORDER BY population DESC, country_name ASC 
LIMIT 30;

SELECT country_name, country_code,
	CASE 
		WHEN currency_code = 'EUR' THEN 'Euro'
        WHEN currency_code != 'EUR' THEN 'Not Euro'
	END AS currency
FROM countries
ORDER BY country_name ASC;