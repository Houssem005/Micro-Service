FROM openjdk:8
EXPOSE 8035
ADD /target/reclamation-ms-1-0.0.1-SNAPSHOT.jar reclamation.jar
ENTRYPOINT ["java" , "-jar" , "reclamation.jar"]