# Build stage
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy pom.xml files for better layer caching
COPY pom.xml .
COPY */pom.xml ./

# Download dependencies (cached layer)
RUN mvn dependency:go-offline -B -f discovery-server/pom.xml

COPY discovery-server/src ./discovery-server/src
# Build the application
RUN mvn clean package -DskipTests -f discovery-server/pom.xml

# Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Create non-root user
RUN addgroup -g 1001 -S spring && adduser -u 1001 -S spring -G spring

# Install curl for health checks
RUN apk add --no-cache curl

# Copy the JAR file
COPY --from=builder /app/discovery-server/target/*.jar app.jar

# Change ownership to spring user
RUN chown -R spring:spring /app
USER spring

EXPOSE 8761

HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:8761/actuator/health || exit 1

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]