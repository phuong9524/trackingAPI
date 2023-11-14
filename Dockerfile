FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
WORKDIR /app
COPY . .
RUN ./gradlew bootJar --no-daemon

# Use a lightweight base image for the runtime
FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/build/libs/demo-1.jar app.jar
LABEL authors="tyty2"

ENTRYPOINT ["java", "-jar", "app.jar"]