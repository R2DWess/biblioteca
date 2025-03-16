FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

RUN apk add --no-cache bash curl tar unzip git

RUN mkdir -p /home/gradle/.gradle

ENV GRADLE_USER_HOME /home/gradle/.gradle

COPY build.gradle settings.gradle gradlew ./

COPY gradle ./gradle

RUN --mount=type=cache,target=/home/gradle/.gradle ./gradlew dependencies --no-daemon || return 0

COPY src ./src

RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]