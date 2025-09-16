# Use OpenJDK 21 base image
FROM openjdk:21

# Set working directory inside container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/devops-app-1.0-SNAPSHOT.jar app.jar

# Run the JAR file when container starts
CMD ["java", "-jar", "app.jar"]
