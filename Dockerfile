FROM openjdk:17

WORKDIR /app

COPY target/api-valhalla-kitchen.0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]