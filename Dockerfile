FROM openjdk:22-jdk
WORKDIR /app
COPY build/libs/url_shortener-0.1.0-alpha.jar /app/url_shortener-0.1.0-alpha.jar
EXPOSE 8081
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/spring
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root
ENTRYPOINT ["java", "-jar", "/app/url_shortener-0.1.0-alpha.jar"]