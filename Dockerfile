# Layer 1
FROM openjdk:11.0.6-jre

# Layer 2
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]

# Layer 3
COPY ./build/libs/*.jar app.jar
