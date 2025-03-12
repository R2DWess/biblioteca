# Etapa de build
FROM gradle:8.12-jdk21 AS builder
WORKDIR /app

# Copia os arquivos do Gradle primeiro para aproveitar o cache de dependências
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
RUN ./gradlew build --no-daemon  # Baixa as dependências antes para otimizar o cache

# Copia o restante do código-fonte para o build final
COPY src ./src
RUN ./gradlew build --no-daemon

# Etapa de produção
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia apenas o JAR gerado na etapa de build
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
