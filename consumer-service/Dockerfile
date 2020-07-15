FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/product-service-*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
