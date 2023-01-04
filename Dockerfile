FROM maven:3.6.0-jdk-11-slim AS build
ENV HOME=/home/user/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN mvn clean package -Pproduction -DnodeVersion="v10.16.0"

FROM openjdk:11-jdk-slim
COPY $HOME/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
