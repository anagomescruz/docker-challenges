# Challenge 4

### Run “Hello World” Java Project and push image to Docker Hub

In this challenge we'll learn how to

- Create an image to run a `.jar`
- Connect to [Docker Hub](https://hub.docker.com/)
- Publish images to [Docker Hub](https://hub.docker.com/)

Note: The provided HelloWorld maven project is only illustrative of what is present in the
`.jar`, there is no need to know how to compile/package/run it

### Create and run a jar file in Docker challenge

- Create an image which runs the provided `.jar` file
  - How to run a `.jar` file: `java -jar <.jar path>.jar`
  - **Solution**:
    - create a Dockerfile with a java image with verson 11
      `FROM eclipse-temurin:11`
    - copy the jar file to the Docker
      `COPY java_helloworld.jar .`
    - create the command to execute the jar
      `CMD [ "java", "-jar", "java_helloworld.jar" ]`
    - create the docker image
      `docker build -t challenge4 .`
- Run the image of the previous step
  - Output expected: `Hello world!`
  - **Solution**:
    - `docker run challenge4` and see the expected output

### Push an image to Docker Hub

- Publish the image of the previous challenge/step to Docker Hub to your repository with the tag 1.0
  - **Solution**:
    - First create an account if you don't still have one on [https://hub.docker.com/](https://hub.docker.com/)
    - Create a new repository into it.
    - Login into the Docker Hub from the command line:
      - `docker login --username=yourhubusername`
      - Enter your password when prompted
    - tag the image:
      - `docker image tag <yourImageName:yourImageTag> <yourHubUsername/repositoryName:NewTag>`
        example: `docker image tag challenge4:latest anagomescruz/dockerchallenge:challenge4`
    - push your image to the repository you created:
      - `docker push yourHubUsername/repositoryName:NewTag`
        example: `docker push anagomescruz/dockerchallenge:challenge4`
- Remove the published image from your machine and run the image by fetching it from Docker Hub
  - **Solution**:
    - `docker rmi <image_id>`
    - `docker pull anagomescruz/dockerchallenge:challenge4`
    - `docker run anagomescruz/dockerchallenge:challenge4`
    - OR
    - `docker rmi <image_id>`
    - `docker run anagomescruz/dockerchallenge:challenge4`


### [Extra Challenge] Create and run a jar file in Docker challenge
- Creates an image which generate and runs the `.jar` file.
  - **Solution**:
    - Create a DockerFile with two images
      - MVN image
        - create a Dockerfile with a mvn image for version 11
          `FROM maven:3.5-jdk-11 AS build`
        - create a workdir
          `WORKDIR /challenge4`
        - copy the java project and POM file to the Docker
          `COPY java_helloworld/src src`
          `COPY java_helloworld/pom.xml pom.xml`
        - create the command to build the project
          `RUN mvn -f pom.xml clean package`
      - Java image
        - create a Dockerfile with a java image with verson 11
          `FROM eclipse-temurin:11`
        - copy the jar file generated in previous step
          `COPY --from=build challenge4/target/java_helloworld-1.0-SNAPSHOT.jar java_helloworld-1.0-SNAPSHOT.jar`
        - create the command to execute the jar
          `CMD ["java","-jar","java_helloworld-1.0-SNAPSHOT.jar"] `
  

###### Tutorials:
- [How to push to Docker Hub](https://jsta.github.io/r-docker-tutorial/04-Dockerhub.html)
- [Docker Hub Push](https://docs.docker.com/engine/reference/commandline/push/)