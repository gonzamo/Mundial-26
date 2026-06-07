# Mundial 2026

Aplicación full-stack para seguir y gestionar el **FIFA World Cup 2026** — desarrollada con Java/Spring Boot (backend) y Angular 17 (frontend) como proyecto personal de aprendizaje.

---

## Estructura del proyecto

```
mundial-26/
├── backend/                      # API REST (Spring Boot 3 + Maven)
│   ├── src/main/java/com/mundial2026/
│   │   ├── config/               # DataLoader (carga de datos desde JSON)
│   │   ├── controller/           # Controladores REST
│   │   ├── dto/                  # DTOs (LoginRequest, AuthResponse)
│   │   ├── exception/            # Manejo global de errores
│   │   ├── model/
│   │   │   ├── entity/           # Entidades JPA
│   │   │   └── enums/            # Enumeraciones
│   │   ├── repository/           # Repositorios JPA
│   │   ├── security/             # JWT + Spring Security
│   │   └── service/              # Lógica de negocio
│   ├── src/main/resources/       # JSONs de datos + application.properties
│   └── pom.xml
├── frontend/                     # Angular 17 standalone
│   ├── src/app/
│   │   ├── guards/               # auth.guard
│   │   ├── models/               # Interfaces (Equipo, Jugador, Partido...)
│   │   ├── pages/
│   │   │   ├── equipos/          # Página de selecciones + diálogo detalle
│   │   │   ├── grupos/           # Página de grupos
│   │   │   ├── login/            # Login / Registro
│   │   │   └── partidos/         # Página de partidos
│   │   └── services/             # Servicios HTTP
│   └── angular.json
└── README.md
```

---

## Funcionalidades

- Visualización de **grupos** con sus equipos
- Catálogo de **selecciones** con buscador y diálogo de jugadores (coloreados por posición)
- Calendario de **partidos** agrupados por fase con buscador
- **Autenticación** con JWT (login y registro de usuarios)
- Datos reales del Mundial 2026 (48 selecciones, 1248 jugadores, 72 partidos de grupos)

---

## Tecnologías

### Backend
- **Java 21** + **Spring Boot 3.5.x** + **Maven** — lenguaje, framework principal y gestor de dependencias
- **Spring Data JPA** + **MariaDB** — acceso a base de datos y ORM con Hibernate
- **Spring Security** + **JWT (jjwt)** — autenticación y autorización mediante tokens
- **Lombok** — reduce código repetitivo generando getters, setters y constructores automáticamente
- **Jackson** — serialización y deserialización de JSON
- **Swagger/OpenAPI (springdoc)** — documentación interactiva de la API

### Frontend
- **Angular 17 standalone** — framework principal
- **Angular Material** — biblioteca de componentes
- **RxJS** — programación reactiva para manejar peticiones HTTP y eventos asíncronos
- **HttpClient** — cliente HTTP para comunicarse con el backend
---

## Cómo arrancar
### Frontend
```bash
cd frontend
npm install
ng serve
```
La app se abre en `http://localhost:4200`.

---

### Backend
```bash
cd backend
./mvnw spring-boot:run
```
El servidor arranca en `http://localhost:8080`.  
La primera vez carga automáticamente los datos desde los JSON y crea el usuario por defecto **admin / 1234**.


## Endpoints de la API

| Método | Ruta | Descripción |
|--------|------|-------------|
| POST | `/api/auth/login` | Iniciar sesión |
| POST | `/api/auth/registro` | Registrar usuario |
| GET | `/api/grupos` | Listar grupos |
| GET | `/api/equipos` | Listar selecciones |
| GET | `/api/equipos/{id}` | Ver selección con jugadores |
| GET | `/api/jugadores` | Listar jugadores |
| GET | `/api/partidos` | Listar partidos |
| GET | `/api/estadios` | Listar estadios |
| GET | `/swagger-ui.html` | Documentación Swagger |

---

## Estado del proyecto

- ✅ Backend completo con CRUD, seguridad JWT y carga de datos
- ✅ Frontend con páginas de login, grupos, selecciones (con buscador y detalle) y partidos (con buscador)
- ✅ Datos reales del Mundial 2026 en JSON