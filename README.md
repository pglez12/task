# CapStream
## 🎯 Objetivo del Proyecto
El objetivo de CapStream es crear una plataforma de gestión de juegos online que facilite la administración y el acceso a un catálogo diverso y especializado. A través de un sistema eficiente de gestión de datos, se espera ofrecer una experiencia de usuario mejorada tanto para administradores como para futuros clientes.

## 💻 Tecnologías Utilizadas
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Thymeleaf**
- **MySQL**
- **Maven**

## 📂 Estructura de Carpetas
```
Videogames/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ejemplo/
│   │   │           ├── controller/
│   │   │           │   └── JuegoController.java
│   │   │           ├── model/
│   │   │           │   └── Juego.java
│   │   │           ├── repository/
│   │   │           │   └── JuegoDAO.java
│   │   │           ├── service/
│   │   │           │   ├── JuegoService.java
│   │   │           │   └── JuegoServiceImp.java
│   │   │           └── VideogamesApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       │   └── css/
│   │       │       └── styles.css
│   │       └── templates/
│   │           ├── form.html
│   │           └── list.html
└── ...
```

## ⁉️ Cómo Usar el Proyecto
### Requisitos Previos
- JDK 11 o superior
- Maven
- MySQL o cualquier base de datos compatible

### Configuración de la Base de Datos
Crea una base de datos llamada videojuegos.
Modifica el archivo application.properties con tus credenciales de base de datos:
```
spring.datasource.url=jdbc:mysql://localhost:3306/videojuegos
spring.datasource.username=root
spring.datasource.password=
```
## ▶️ Iniciar el Proyecto
Clona el repositorio:
git clone <URL_DEL_REPOSITORIO>
cd Videogames
Compila y ejecuta la aplicación:
bash
Copy code
mvn spring-boot:run
Accede a la aplicación en tu navegador en http://localhost:4242.
## 🔌Rutas
`GET /juegos`: Muestra la lista de videojuegos disponibles.
`GET /juegos/new`: Carga el formulario para agregar un nuevo juego.
`GET /edit?id={id}`: Carga el formulario para editar un juego existente.
`POST /save`: Guarda un juego (nuevo o editado).
`GET /delete?id={id}`: Elimina un juego específico.
`GET /siglo20`: Muestra los juegos del siglo 20.
`GET /juegos/nintendo`: Muestra los juegos publicados por Nintendo.
`GET /juegos/year?year={año}`: Muestra los juegos publicados en un año específico.
`GET /juegos/genre?genre={género}`: Muestra los juegos de un género específico.
