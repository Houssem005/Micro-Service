FROM openjdk:8
EXPOSE 8092
ADD /target/Delivery-1.0.jar Delivery.jar
ENTRYPOINT ["java","-jar","Delivery.jar"]