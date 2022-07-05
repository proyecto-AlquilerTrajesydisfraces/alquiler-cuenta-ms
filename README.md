# Proyecto de Ciclo IV: Tienda alquiler trajes y disfraces - arquitectura microservicios
Este proyecto está enfocado en la creación de una aplicación web que permita de forma sistemática el almacenamiento y gestion de inventarios de productos elaborados por las comunidades indigenas del pais y en una versión siguiente de manera adicional se planea mejorar el frontend con imagenes referentes a cada producto ingresado.

### Backend 2: cuenta y alquiler de prendas
para la realizacion de este microservicio se utilizo el framework Spring Boot, con el lenguaje de programacion java, y sistema de base de datos NoSQL MongoDb, las pruebas correspondientes se realizaron en postman 

### Contenido de Este repositorio: 

 1. Se tiene una carpeta llamada .mvn/wrapper creada por maven, esta contiene dos archivos: maven-wrapper.jar y maven-wrapper.properties

 2. al abrir la carpeta src -> main -> java -> com/TiendaDyT/backend_cuenta_ms, se encuentran las carpetas correpondientes a la creación del proyecto: controllers,           exceptions, models, repositories y un archivo creado automaticamente por el framework llamado: BackendCuentaMsApplication.java

 3. al abrir la carpeta src -> main -> resources, encontramos el archivo:application.properties que permite configurar la conexión a la base de datos y el puerto

 4. se creo un archivo dockerfile el cual es un archivo de texto plano que contiene una serie de instrucciones necesarias para crear una imagen en un contenedor

 5. se tienen el archivo de configuracion pom.xml y dos archivos de maven, creados por defecto desde la creación del proyecto y que permiten iniciar un servidor web de manera local y en la nube.

 ### Requerimientos 
```
<java.version>11</java.version>
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-spring-web</artifactId>
			<version>3.0.0</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.6.4</version>
		</dependency>
	</dependencies>
```

### Ejecución del proyecto

para ejecutar el proyecto en local:

1. Se descarga el proyecto comprimido o se clona de GitHub
   ```
    git clone https://github.com/proyecto-AlquilerTrajesydisfraces/alquiler-cuenta-ms.git
   ```
2. Al tener el proyecto en el ordenador, por la consola de comandos de ingresa al proyecto utilizando el comando cd:
   ```
    cd alquiler-cuenta-ms-main
   ```
3. se debe ingresar el siguiente comando para ejecutar el proyecto en local(computador personal o servidor):

   ```
    ./mvnw spring-boot:run
   ```
- Es posible comprobar su funcionamiento en local ingresando a la url asignada http://localhost:8080.

El proyecto se encuentra desplegado en la plataforma heroku:

https://tienda-tyd-cuenta-ms.herokuapp.com/

### Diagrama de despliegue 

la parte sombreada hace referencia al despliegue de componentes de la parte backend 2(cuenta) del proyecto

![image](https://user-images.githubusercontent.com/84297258/176787485-5f31154c-7b8c-4ce9-ac75-ea2d06f5f2ce.png)

### Documentación de API

 https://tienda-tyd-cuenta-ms.herokuapp.com/swagger-ui/index.html

### Pruebas

La ejecución de los casos de prueba se hizo por medio de la aplicacion postman:

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/17863004-f196d2dd-244f-4f03-8832-8c7078cdef69?action=collection%2Ffork&collection-url=entityId%3D17863004-f196d2dd-244f-4f03-8832-8c7078cdef69%26entityType%3Dcollection%26workspaceId%3D7bcc2d18-e9d7-4ab3-8b52-f701bc8801d1)
