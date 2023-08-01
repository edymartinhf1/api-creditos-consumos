FROM openjdk:11.0.16
WORKDIR /app
COPY ./target/api-creditos-consumos-0.0.1-SNAPSHOT.jar .
EXPOSE 8085
ENTRYPOINT ["java","-jar","api-creditos-consumos-0.0.1-SNAPSHOT.jar"]


