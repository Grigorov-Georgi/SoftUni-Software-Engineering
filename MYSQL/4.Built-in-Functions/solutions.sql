USE book_library;

SELECT replace(title, 'The', '***') FROM books
WHERE substring(title, 1, 3) = 'The';

SELECT concat(first_name, ' ', last_name) AS 'Full Name' , timestampdiff(day, born, died) AS 'Days Lived' FROM authors;

SELECT SUM(cost) FROM books;

SELECT title FROM books
WHERE substring(title, 1, 5) = 'Harry'
ORDER BY id ASC;

SELECT title FROM books
WHERE title LIKE 'Harry%'
ORDER BY id ASC;