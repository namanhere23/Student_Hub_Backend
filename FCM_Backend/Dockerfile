# Multi-stage build: first stage for building
FROM eclipse-temurin:17-jdk-jammy AS builder

# Set working directory
WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Copy source code
COPY src src

# Install required dependencies and build the application
RUN apt-get update && apt-get install -y findutils && \
    chmod +x gradlew && ./gradlew buildFatJar

# Second stage: runtime
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the fat JAR file from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Set environment variables
ENV PORT=8080

# Run the application
CMD ["java", "-jar", "app.jar"]
