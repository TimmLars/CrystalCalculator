FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /build
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /build/target/*.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]