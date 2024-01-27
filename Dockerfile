FROM maven:3.8.5-openjdk-19 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/tgBot-1.0-SNAPSHOT.jar tgBot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tgBot.jar"]