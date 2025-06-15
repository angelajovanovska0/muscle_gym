# Build stage
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy parent pom.xml first for better layer caching
COPY pom.xml .

# Copy the api-gateway module
COPY api-gateway/pom.xml ./api-gateway/
COPY api-gateway/src ./api-gateway/src

# Download dependencies (cached layer)
RUN mvn dependency:go-offline -B -f api-gateway/pom.xml

# Build the application
RUN mvn clean package -DskipTests -f api-gateway/pom.xml

# Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Create non-root user
RUN addgroup -g 1001 -S spring && adduser -u 1001 -S spring -G spring

# Install curl for health checks
RUN apk add --no-cache curl

# Copy the JAR file
COPY --from=builder /app/api-gateway/target/*.jar app.jar

# Change ownership to spring user
RUN chown -R spring:spring /app
USER spring

EXPOSE 8088

HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:8088/actuator/health || exit 1

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]