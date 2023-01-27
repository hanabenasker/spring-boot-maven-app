FROM openjdk:8-jre-alphine

EXPOSE 8080

COPY ./target/spring-boot-maven-app-*.jar /usr/app/
WORKDIR /usr/app

CMD java -jar spring-boot-maven-app-*.jar