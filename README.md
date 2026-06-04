# Mundial 2026 API

API REST para seguir y gestionar el **FIFA World Cup 2026**, desarrollada con Java y Spring Boot como proyecto personal de aprendizaje.

---

## Estructura del proyecto

```
mundial-26/
├── backend/               # API REST (Spring Boot + Maven)
│   ├── src/main/java/com/mundial2026/
│   │   ├── controller/    # Controladores REST
│   │   ├── exception/     # Manejo global de errores
│   │   ├── model/
│   │   │   ├── entity/    # Entidades JPA
│   │   │   └── enums/     # Enumeraciones
│   │   ├── repository/    # Repositorios JPA
│   │   └── service/       # Lógica de negocio
│   └── pom.xml
├── frontend/              # Frontend (pendiente)
└── README.md
```

---

## ¿Qué es esta app?

Una aplicación backend que permite consultar y gestionar toda la información del Mundial 2026: equipos, jugadores, partidos, grupos y estadios. Incluye documentación automática con Swagger, manejo global de excepciones y una base de datos real.

---

## ¿En qué punto estamos?

- ✅ Proyecto Maven configurado con Spring Boot 3.5.14 y Java 17
- ✅ Conexión a base de datos MariaDB funcionando
- ✅ Servidor arrancando correctamente en puerto 8080
- ✅ 5 entidades creadas (Estadio, Grupo, Equipo, Jugador, Partido)
- ✅ 3 enums creados (EstadoPartido, FasePartido, PosicionJugador)
- ✅ 5 tablas generadas automáticamente en la base de datos
- ✅ 5 repositorios JPA creados
- ✅ 5 servicios creados (interfaz + implementación)
- ✅ 5 controladores REST (Estadio, Equipo, Grupo, Jugador, Partido)
- ✅ Manejo global de excepciones con ResourceNotFoundException
- ✅ Servicios con mensajes de error descriptivos
- ✅ Documentación Swagger/OpenAPI integrada
- ✅ Dependencias JWT añadidas

---
