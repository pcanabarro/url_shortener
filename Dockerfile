FROM openjdk:21-jdk
WORKDIR /app
COPY build/libs/your-app.jar /app/your-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/your-app.jar"]