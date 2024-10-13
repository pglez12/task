# How to use Juegos.sql
Para utilizar el script juegos.sql, que contiene un volcado de SQL de una base de datos de videojuegos, sigue estos pasos:

## Requisitos Previos
1. **Servidor de Base de Datos**: Necesitas tener un servidor de base de datos como MySQL o MariaDB instalado y funcionando.
2. **Herramienta de Gestión**: Puedes usar phpMyAdmin, MySQL Workbench o cualquier cliente de línea de comandos de MySQL.

## Pasos para Importar el Script
1. Accede a tu Herramienta de Gestión

    Si usas phpMyAdmin, accede a la interfaz web.

    Si usas MySQL Workbench o un cliente de línea de comandos, asegúrate de conectarte al servidor.
2. Crear una Nueva Base de Datos (opcional)
 
  Si deseas crear una nueva base de datos para este script:
```
CREATE DATABASE videojuegos;
USE videojuegos;
```
3. Importar el Script

⋅⋅* **phpMyAdmin**:

⋅⋅1. Selecciona la base de datos en la que deseas importar el script.

⋅⋅2. Ve a la pestaña "Importar".

⋅⋅3. Selecciona el archivo juegos.sql y haz clic en "Ejecutar".

⋅⋅* **MySQL Workbench**:

⋅⋅1. Abre una nueva ventana de consulta.

⋅⋅2. Copia el contenido del script juegos.sql y pégalo en la ventana de consulta.

⋅⋅3. Ejecuta el script.

## Estructura de la Tabla juegos
La tabla juegos tendrá las siguientes columnas:

* `id`: Identificador único para cada juego.
* `rank`: Clasificación del juego.
* `name`: Nombre del juego.
* `platform`: Plataforma en la que se lanzó el juego.
* `year`: Año de lanzamiento.
* `genre`: Género del juego.
* `publisher`: Publicador del juego.
* `naSales`, `euSales`, `jpSales`, `otherSales`, `globalSales`: Ventas en diferentes regiones.
