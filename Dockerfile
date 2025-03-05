FROM openjdk:21-jdk-slim
WORKDIR /app
COPY ./target/sortapp-0.0.1-SNAPSHOT.jar sortingapp.jar
ENTRYPOINT [ "java", "-jar", "/app/sortingapp.jar" ]
