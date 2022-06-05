# configuracion del entorno
FROM openjdk:17-jdk-alpine

# mover archivo .jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# ejecucion de la aplicacion
ENTRYPOINT ["java", "-jar", "/app.jar"]
CMD gunicorn --bind 0.0.0.0:$PORT wsgi