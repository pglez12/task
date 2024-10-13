# How to DataBase
Este script SQL crea una base de datos y una tabla para almacenar datos de ventas de videojuegos, y también carga datos desde un archivo CSV en la tabla.

## SQL Script

```
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
## Pasos de Configuración
1. Mover el Archivo CSV: Mueve el archivo vgsales.csv al siguiente directorio:
`C:/xampp/mysql/data/`
2. Editar la Configuración de MySQL:
   
   2.a Abre my.ini ubicado en:  `c:\xampp\mysql\bin\`

   2.b Descomenta la siguiente línea: `local_infile = 1`

3. Editar la Configuración de PHP:

    3.a Abre php.ini.

    3.b Descomenta las siguientes líneas y establece la ruta:
    ```
    mysqli.allow_local_infile = 1
    mysqli.local_infile_directory = "c:/xampp/mysql/data/"
    ```
    
## Additional Notes
Ensure that the MySQL server is restarted after making these configuration changes for them to take effect.
