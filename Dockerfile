
FROM gradle:7.6.1-jdk21 as build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY gradle/ gradle/
COPY src/ ./src/
RUN gradle build --no-daemon

FROM amazoncorretto:21.0.3
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/url_shortener-0.1.0-alpha.jar"]

