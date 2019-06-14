FROM openjdk:8u151-jdk
COPY target/evenetos.jar /app/eventos.war
#COPY application.properties /app/application.properties
CMD java -jar /app/eventos.war #--spring.config.location=/app/