CREATE DATABASE videojuegos;
USE videojuegos;

CREATE TABLE juegos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rank INT,
    name VARCHAR(255),
    platform VARCHAR(255),
    year INT,
    genre VARCHAR(255),
    publisher VARCHAR(255),
    na_sales DECIMAL(10,2),
    eu_sales DECIMAL(10,2),
    jp_sales DECIMAL(10,2),
    other_sales DECIMAL(10,2),
    global_sales DECIMAL(10,2)
);

LOAD DATA LOCAL INFILE 'C:/xampp/mysql/data/vgsales.csv'
INTO TABLE juegos
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(rank, name, platform, year, genre, publisher, na_sales, eu_sales, jp_sales, other_sales, global_sales);
