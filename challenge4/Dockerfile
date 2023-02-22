# Extra challenge
# Generate the jar file inside dockerfile and run it.
FROM maven:3.5-jdk-11 AS build
WORKDIR /challenge4
COPY java_helloworld/src src
COPY java_helloworld/pom.xml pom.xml
RUN mvn -f pom.xml clean package

FROM eclipse-temurin:11
COPY --from=build challenge4/target/java_helloworld-1.0-SNAPSHOT.jar java_helloworld-1.0-SNAPSHOT.jar  
CMD ["java","-jar","java_helloworld-1.0-SNAPSHOT.jar"]  


# Challenge
# Copy the jar file and run it
#FROM eclipse-temurin:11

#WORKDIR /challenge4
#COPY java_helloworld.jar .

#CMD [ "java", "-jar", "java_helloworld.jar"]

