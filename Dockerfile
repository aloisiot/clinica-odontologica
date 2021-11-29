FROM openjdk:17-jdk-alpine3.14
WORKDIR /api-clinica-odontologica
EXPOSE 8080
COPY target/clinica-odontologica-0.0.1-SNAPSHOT.jar /api-clinica-odontologica/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]