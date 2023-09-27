FROM openjdk:11.0.16-jre-slim
USER root

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]