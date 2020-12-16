FROM openjdk:8-jdk-alpine
WORKDIR /spring-project
COPY target/spring-project-1.0.0.jar sp.jar
EXPOSE 9090
ENTRYPOINT [ "sh","-c","java -jar sp.jar" ]