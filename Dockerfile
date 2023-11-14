FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./gradlew bootJar --no-deamon

WORKDIR /app
FROM opoenjdk:17-jdk-slim
EXPOSE 8080
COPY --from=build /app/target/libs/demo-1.jar app.jar
LABEL authors="tyty2"

ENTRYPOINT ["java", "-jar", "app.jar"]