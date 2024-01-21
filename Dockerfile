FROM openjdk:21
ADD target/forest-operation.jar forest-operation.jar
ENTRYPOINT ["java","-jar","/forest-operation.jar"]