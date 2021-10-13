FROM openjdk:8u131-jdk-alpine
FROM maven:3.6.0-jdk-11-slim AS build
MAINTAINER Devraj Singh "devrajvit@gmail.com"

EXPOSE 8080

WORKDIR /home/ubuntu/projects/Simple-SpringBoot
COPY ./ ./
RUN mvn -f ./pom.xml clean install
# COPY ./target/simple-sprintboot-1.0-SNAPSHOT.jar springboot.jar

CMD ["java","-jar","./target/simple-sprintboot-1.0-SNAPSHOT.jar"]
