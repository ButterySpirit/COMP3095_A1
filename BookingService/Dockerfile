# Dockerfile for BookingService
FROM openjdk:22-jdk-slim
VOLUME /tmp
COPY build/libs/BookingService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the service port
EXPOSE 8082
