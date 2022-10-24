FROM openjdk:8
EXPOSE 8089
ADD /target/packages-0.0.1.jar packages.jar
ENTRYPOINT ["java" , "-jar" , "packages.jar"]