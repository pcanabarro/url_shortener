
#FROM gradle:8.0 as build
#WORKDIR /app
#COPY build.gradle settings.gradle ./
#COPY gradle/ gradle/
#COPY src/ ./src/
#RUN gradle build
#
#FROM amazoncorretto:21.0.3
#WORKDIR /app
#COPY --from=build /app/build/libs/*.jar app.jar
#EXPOSE 8081
#ENTRYPOINT ["java", "-jar", "/app/url_shortener-1.0.jar"]

#-------------------------------------------------------------

FROM amazoncorretto:21.0.3
WORKDIR /app
COPY /build/libs/url_shortener-1.0.jar /app/build/libs/*.jar app.jar
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql-container:3306/spring
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=root
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
