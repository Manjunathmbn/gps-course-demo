# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built jar file
COPY target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
