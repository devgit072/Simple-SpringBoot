FROM openjdk:8u131-jdk-alpine

MAINTAINER Devraj Singh "devrajvit@gmail.com"

EXPOSE 8080

WORKDIR /usr/local/bin

COPY ./target/simple-sprintboot-1.0-SNAPSHOT.jar springboot.jar

CMD ["java","-jar","springboot.jar"]

## Build with command: docker image build -t springboot-tut .
## Run with command:
# docker container run -p 80:8080 -it springboot-tut
# Access the web-page with url: localhost/books (default port is 80)
