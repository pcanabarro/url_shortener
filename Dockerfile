FROM openjdk:21-jdk
WORKDIR /app
COPY build/libs/url_shortener-0.1.0-alpha.jar /app/url_shortener-0.1.0-alpha.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/url_shortener-0.1.0-alpha.jar"]