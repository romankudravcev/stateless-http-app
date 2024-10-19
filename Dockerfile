# Build phase
FROM gradle:7.3.0-jdk17 as build
WORKDIR /app
COPY src ./src
COPY build.gradle .
RUN gradle bootJar

# Run phase
FROM openjdk:17-jdk-slim as run
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]