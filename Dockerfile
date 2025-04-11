# Build stage
FROM gradle:8.2.1-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Create a non-root user
RUN addgroup --system --gid 1001 spring && \
    adduser --system --uid 1001 --gid 1001 spring

# Copy the built jar from the build stage
COPY --from=build /app/build/libs/spring-0.0.1-SNAPSHOT.jar app.jar

# Set ownership and permissions
RUN chown spring:spring /app && \
    chmod 755 /app

# Switch to non-root user
USER spring

# Add health check
HEALTHCHECK --interval=30s --timeout=3s \
    CMD curl -f http://localhost:8085/actuator/health || exit 1

# Set labels
LABEL maintainer="Your Name <your.email@example.com>" \
    version="1.0" \
    description="Spring Boot Application"

# Expose port
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
