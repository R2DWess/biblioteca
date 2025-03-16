# 🔥 Fase de Construção (Builder)
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

# 🔹 Copia arquivos de configuração do Gradle
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# 🔥 Garante que `gradlew` tem permissão de execução
RUN chmod +x gradlew

# 🔹 Baixa dependências (cache eficiente)
RUN ./gradlew dependencies --no-daemon || return 0

# 🔹 Copia código-fonte
COPY src ./src

# 🔹 Compila a aplicação
RUN ./gradlew build --no-daemon

# 🔥 Fase de Execução (Imagem Final Enxuta)
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app

# 🔹 Copia apenas o JAR compilado para a imagem final
COPY --from=builder /app/build/libs/*.jar app.jar

# 🔥 Define otimização de memória para containers
EXPOSE 8080
CMD ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]
