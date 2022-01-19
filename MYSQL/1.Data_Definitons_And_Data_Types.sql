CREATE DATABASE `minions`;

USE minions;

CREATE TABLE `minions` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30),
`age` INT
);

CREATE TABLE `towns` (
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30)
);

ALTER TABLE `minions`
ADD CONSTRAINT 
PRIMARY KEY minioins(`id`);
  
ALTER TABLE `towns`
ADD CONSTRAINT 
PRIMARY KEY `towns`(`id`);

ALTER TABLE `towns`
CHANGE COLUMN `id` `town_id` INT;

ALTER TABLE `towns`
CHANGE COLUMN `town_id` `id` INT;

ALTER TABLE `minions`
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY `minions` (`town_id`)
REFERENCES `towns`(`id`);

INSERT INTO `towns` (`id`, `name`)
VALUES ("1", "Sofia"),
("2", "Plovdiv"),
("3", "Varna");

INSERT INTO `minions` (`id`, `name`, `age`, `town_id`)
VALUES ("1", "Kevin", "22", "1"),
("2", "Bob", "15", "3"),
("3", "Steward", NULL, "2");

TRUNCATE TABLE `minions`;

DROP TABLE `minions`;
DROP TABLE `towns`;

CREATE TABLE `people` (
`id` INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(50, 2),
`weight` DOUBLE(50, 2),
`gender` ENUM('m','f') NOT NULL,
`birthdate` DATETIME NOT NULL,
`biography` BLOB
);

INSERT INTO `people` (`id`, `name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`)
VALUES ('1', 'George', '11', '11', '11', 'm', '2000-10-10 10:10:10', 'abv'),
('2', 'a', '11', '11', '11', 'm', '2000-10-10 10:10:10', 'a'),
('3', 'v', '11', '11', '11', 'm', '2000-10-10 10:10:10', 'b'),
('4', 'b', '11', '11', '11', 'm', '2000-10-10 10:10:10', 'v'),
('5', 'c', '11', '11', '11', 'm', '2000-10-10 10:10:10', 'c');

CREATE TABLE `users` (
`id` INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATETIME NOT NULL,
`is_deleted` ENUM('true', 'false')
);

INSERT INTO `users` (`id`, `username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`)
VALUES ('1', 'George', '11', '11', '2000-10-10 10:10:10', 'true'),
('2', 'a', '11', '11', '2000-10-10 10:10:10', 'true'),
('3', 'v', '11', '11', '2000-10-10 10:10:10', 'true'),
('4', 'b', '11', '11', '2000-10-10 10:10:10', 'true'),
('5', 'c', '11', '11', '2000-10-10 10:10:10', 'true');

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY `users`(`id`, `username`);

ALTER TABLE users
CHANGE COLUMN `last_login_time` `last_login_time`
DATETIME DEFAULT NOW();

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_id`
PRIMARY KEY `users`(`id`),
ADD CONSTRAINT users_username_unique UNIQUE (username);

CREATE SCHEMA movies;
use movies;

CREATE TABLE directors(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(40) NOT NULL,
`notes` VARCHAR(50)
);

INSERT INTO `directors` (`id`, `director_name`, `notes`)
VALUES ('1', 'a', 'b'), 
('2', 'a', 'b'), 
('3', 'a', 'b'), 
('4', 'a', 'b'), 
('5', 'a', 'b');

CREATE TABLE genres(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(40) NOT NULL,
`notes` VARCHAR(50)
);

INSERT INTO `genres` (`id`, `genre_name`, `notes`)
VALUES ('1', 'a', 'b'), 
('2', 'a', 'b'), 
('3', 'a', 'b'), 
('4', 'a', 'b'), 
('5', 'a', 'b');

CREATE TABLE categories(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(40) NOT NULL,
`notes` VARCHAR(50)
);

INSERT INTO `categories` (`id`, `category_name`, `notes`)
VALUES ('1', 'a', 'b'), 
('2', 'a', 'b'), 
('3', 'a', 'b'), 
('4', 'a', 'b'), 
('5', 'a', 'b');

CREATE TABLE movies(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(40) NOT NULL,
`director_id` INT,
`copyright_year` DATETIME,
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE(4,2),
`notes` VARCHAR(50)
);

INSERT INTO `movies` (`id`, `title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES ('1', 'a', '1', '2000-10-10 10:10:10', '90', '1', '1', '5', 'a'), 
('2', 'a', '2', '2000-10-10 10:10:10', '90', '2', '2', '5', 'a'),
('3', 'a', '3', '2000-10-10 10:10:10', '90', '3', '3', '5', 'a'),
('4', 'a', '4', '2000-10-10 10:10:10', '90', '4', '4', '5', 'a'),
('5', 'a', '5', '2000-10-10 10:10:10', '90', '5', '5', '5', 'a');

CREATE DATABASE `car_rental`;
use car_rental;

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(20) NOT NULL,
`daily_rate` DOUBLE,
`weekly_rate` DOUBLE, 
`monthly_rate` DOUBLE, 
`weekend_rate` DOUBLE
);

INSERT INTO `categories` (`category`)
VALUES 
('a'),
('b'),
('c');

CREATE TABLE cars (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` TEXT NOT NULL, 
`make` VARCHAR(20), 
`model` VARCHAR(20) NOT NULL, 
`car_year` DATETIME, 
`category_id` INT, 
`doors` INT, 
`picture` BLOB, 
`car_condition` TEXT,
`available` BOOLEAN,
CONSTRAINT fk_cars_categories
FOREIGN KEY cars(category_id) REFERENCES categories(id)
);

INSERT INTO `cars` (`plate_number`, `model`, `category_id`)
VALUES 
('1', 'a', '1'),
('2', 'b', '2'),
('3', 'c', '3');

CREATE TABLE employees (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`first_name` VARCHAR(20) NOT NULL, 
`last_name` VARCHAR(20) NOT NULL, 
`title` VARCHAR(20), 
`notes` TEXT
);

INSERT INTO `employees` (`first_name`, `last_name`)
VALUES 
('a', 'a'),
('b', 'b'),
('c', 'c');

CREATE TABLE customers (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`driver_licence_number` TEXT NOT NULL, 
`full_name` VARCHAR(40) NOT NULL, 
`address` VARCHAR(20), 
`city` VARCHAR(20), 
`zip_code` INT, 
`notes` TEXT
);

INSERT INTO `customers` (`driver_licence_number`, `full_name`)
VALUES 
('1', 'a'),
('2', 'b'),
('3', 'c');

CREATE TABLE rental_orders (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`employee_id` INT, 
`customer_id` INT, 
`car_id` INT, 
`car_condition` TEXT, 
`tank_level` INT,
`kilometrage_start` INT, 
`kilometrage_end` INT, 
`total_kilometrage` INT, 
`start_date`  DATETIME, 
`end_date`  DATETIME,
`total_days` INT, 
`rate_applied` DOUBLE, 
`tax_rate` DOUBLE, 
`order_status` BOOLEAN, 
`notes` TEXT,
CONSTRAINT fk_rental_orders_employees
FOREIGN KEY rental_orders(employee_id) REFERENCES employees(id),
CONSTRAINT fk_rental_orders_customer
FOREIGN KEY rental_orders(customer_id) REFERENCES customers(id),
CONSTRAINT fk_rental_orders_cars
FOREIGN KEY rental_orders(car_id) REFERENCES cars(id)
);



INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`)
VALUES 
('1', '1', '1'),
('2', '2', '2'),
('3', '3', '3');

CREATE DATABASE soft_uni;
use soft_uni;

CREATE TABLE towns (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20)
);


CREATE TABLE addresses (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`address_text` TEXT, 
`town_id` INT,
CONSTRAINT fk_addresses_towns
FOREIGN KEY addresses(town_id) REFERENCES towns(id)
);

CREATE TABLE departments  (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20)
);

CREATE TABLE employees (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`first_name` VARCHAR(20), 
`middle_name` VARCHAR(20), 
`last_name` VARCHAR(20), 
`job_title` VARCHAR(20), 
`department_id` INT, 
`hire_date` DATE, 
`salary` DOUBLE, 
`address_id` INT,
CONSTRAINT fk_employees_departments
FOREIGN KEY employees(department_id) REFERENCES departments(id),
CONSTRAINT fk_employees_addresses
FOREIGN KEY employees(address_id) REFERENCES addresses(id)
);

INSERT INTO towns (`name`)
VALUES 
('Sofia'), 
('Plovdiv'),
('Varna'), 
('Burgas');

INSERT INTO departments (`name`)
VALUES 
('Engineering'), 
('Sales'), 
('Marketing'), 
('Software Development'), 
('Quality Assurance');

INSERT INTO employees (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES
('Ivan', 'Ivanov', 'Ivanov',	'.NET Developer',	'4',	'2013-02-01',	'3500.00'),
('Petar', 'Petrov', 'Petrov',	'Senior Engineer',	'1',	'2004-03-02',	'4000.00'),
('Maria', 'Petrova', 'Ivanova',	'Intern',	'5',	'2016-08-28',	'525.25'),
('Georgi', 'Terziev', 'Ivanov',	'CEO',	'2',	'2007-12-09',	'3000.00'),
('Peter', 'Pan', 'Pan',	'Intern',	'3',	'2016-08-28',	'599.88');


SELECT name FROM towns ORDER BY `name` ASC;
SELECT name FROM departments ORDER BY `name` ASC;
SELECT first_name, last_name, job_title, salary FROM employees ORDER BY `salary` DESC;

UPDATE employees SET salary = salary * 1.1  WHERE id = '1';
UPDATE employees SET salary = salary * 1.1  WHERE id = '2';
UPDATE employees SET salary = salary * 1.1  WHERE id = '3';
UPDATE employees SET salary = salary * 1.1  WHERE id = '4';
UPDATE employees SET salary = salary * 1.1  WHERE id = '5';
SELECT salary FROM employees;

DELETE FROM occupancies;