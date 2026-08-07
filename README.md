## **Proyecto creado con las tecnologías:**

1. JAVA Spring boot
2. Thymeleaf
3. Spring Data JPA
4. CSS
5. HTML
6. Mysql
7. Maven
8. Hibernate
9. Bootstrap
10. Java 26

## **Funcionalidades**

- [x] Crear tareas
- [x] Editar tareas
- [x] Eliminar tareas
- [x] Persistencia de datos 
- [ ] Login
- [ ] Usuarios

## **Requisitos**

1. Java
2. Maven
3. MySql Server
   
## **Instrucciones para instalar la aplicación:**

1. Clonar el repositorio.
2. Crear la base de datos:
   
   En MySql ejecutar:
   create database todolist;
3.Configurar conexión:

  Crear el archivo:
  src/main/resources/application.properties con la siguiente configuración:

  spring.application.name=todolist

spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Sustituye TU_USUARIO y TU_CONTRASEÑA por los datos de tu instalación de MySQL.
  
4. Ejecutar aplicación desde VS Code o IntelliJ:

   o:

   Desde la raíz del proyecto:
   
   Windows: mvnw.cmd spring-boot:run
   Linux: ./mvnw spring-boot:run
   
6. Ejecutar la clase principal de Spring Boot.
7. Abrir http://localhost:8080/tareas.
   

## **Futuras implementaciones:**

1. Buscar por id

