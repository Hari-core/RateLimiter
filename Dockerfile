# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/RateLimiter-1.0.jar /app/rate-limiter.jar

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/rate-limiter.jar"]
