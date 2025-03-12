# Etapa de build
FROM gradle:8.12-jdk17 AS builder
WORKDIR /app

# Instalar Java 21 manualmente no container
RUN apt-get update && apt-get install -y openjdk-21-jdk

# Definir JAVA_HOME para Gradle encontrar o JDK correto
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Copia apenas os arquivos necessários para otimizar o cache
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
RUN ./gradlew build --no-daemon || return 0  # Baixa dependências para cache

# Copia o restante da aplicação e faz o build final
COPY src ./src
RUN ./gradlew build -x test --no-daemon  # Compila sem testes para agilizar

# Etapa de produção
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia apenas o JAR gerado na etapa de build
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
