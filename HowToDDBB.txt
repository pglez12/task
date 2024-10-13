# create_load_db.sql

This SQL script creates a database and a table for storing video game sales data, and it also loads data from a CSV file into the table.

## SQL Script

```sql
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
```
### Create Stored Procedure in SQL to Load Data from CSV Files
For additional guidance, refer to the MySQL 8.0 Reference Manual: LOAD DATA Statement.

### Configuration Steps
1. Move the CSV File: Move the file vgsales.csv to the following directory:
`C:/xampp/mysql/data/`
2. Edit MySQL Configuration:

   2.a Open my.ini located in: `c:\xampp\mysql\bin\`

   2.b Uncomment the following line: `local_infile = 1`
4. Edit PHP Configuration:

   3.a Open php.ini.

   3.b Uncomment the following lines and set the path:
    ```
    mysqli.allow_local_infile = 1
    mysqli.local_infile_directory = "c:/xampp/mysql/data/"
    ```

## Additional Notes
Ensure that the MySQL server is restarted after making these configuration changes for them to take effect.
