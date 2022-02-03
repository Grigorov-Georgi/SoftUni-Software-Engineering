use camp;

CREATE TABLE mountains (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40)
);

CREATE TABLE peaks (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40),
    mountain_id INT,
    CONSTRAINT `fk_peaks_mountains` FOREIGN KEY (`mountain_id`)
        REFERENCES `mountains` (`id`)
);

SELECT 
    v.driver_id,
    v.vehicle_type,
    CONCAT_WS(' ', first_name, last_name) AS 'driver_name'
FROM
    campers AS c
        JOIN
    vehicles AS v ON v.driver_id = c.id;

CREATE TABLE mountains (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40)
); 

CREATE TABLE peaks (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40),
    mountain_id INT,
    CONSTRAINT `fk_peaks_mountains` FOREIGN KEY (`mountain_id`)
        REFERENCES `mountains` (`id`)
        ON DELETE CASCADE
);

SELECT 
    starting_point AS 'route_starting_point',
    end_point AS 'route_ending_point',
    r.leader_id,
    CONCAT_WS(' ', c.first_name, c.last_name) AS 'leader_name'
FROM
    routes AS r
        JOIN
    campers AS c ON r.leader_id = c.id