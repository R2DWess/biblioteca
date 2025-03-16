FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
RUN ./gradlew build --no-daemon || return 0

COPY src ./src
RUN ./gradlew build --no-daemon

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]
