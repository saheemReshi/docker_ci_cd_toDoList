FROM eclipse-temurin:17-jdk-jammy

COPY target/TODO-1.0-SNAPSHOT-jar-with-dependencies.jar /app/TodoCLI.jar

ENTRYPOINT ["java", "-jar", "/app/TodoCLI.jar"]