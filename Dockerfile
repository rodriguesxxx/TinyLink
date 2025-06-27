# Build
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY /api .
RUN mvn clean install -DskipTests -Dmaven.test.skip=true -Dmaven.build.dest=/app/target/

# Aplication
FROM openjdk:21

WORKDIR /app

COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]