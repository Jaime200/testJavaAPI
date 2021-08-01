FROM adoptopenjdk/openjdk15:ubi
ADD target/apiRestTest-0.0.1-SNAPSHOT.jar /opt/app/app.jar
CMD ["java", "-jar", "/opt/app/app.jar"]