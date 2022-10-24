FROM openjdk:8
EXPOSE 8086
ADD /target/Fournisseur-0.0.1-SNAPSHOT.jar Fournisseur.jar
ENTRYPOINT ["java" , "-jar" , "Fournisseur.jar"]
