FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY src/main/resources/keycloak.json keycloak.json
RUN bash -c "touch /app.jar"
EXPOSE 8010
ENTRYPOINT ["java","-jar","app.jar"]

# docker run -d -p 18086:8086 --name docker-resource demoservice/resource:1.0