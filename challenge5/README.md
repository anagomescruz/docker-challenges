# Challenge 5
### Run “Hello World” REST Service

In this challenge we'll learn how to
- Run a REST Service 
- Name containers 
- Provide environment variables to a container 
- View detached container's logs

Notes: The provided `rest_helloworld` maven project is only illustrative of what is present in the `.jar`, there is no need to know how to compile/package/run it

### Create an image to run a REST service in Docker challenge
- Create an image which runs the provided `.jar` file
  - How to run a `.jar` file: `java -jar <.jar path>.jar`
  - **Solution**:
    - create a Dockerfile with a java image with verson 17 `FROM eclipse-temurin:17`
    - copy the jar file to the Docker `COPY java_helloworld-1.0-SNAPSHOT-runner.jar .`
    - create the command to execute the jar CMD `[ "java", "-jar", "java_helloworld.jar" ]`
    - create the docker image `docker build -t challenge5 .`
- Run the image of the previous step detached and give the container a name
  - **Solution**:
    - `docker run -d --name challenge5 challenge5`
- View the logs of the container to confirm if the application is up 
  - **Solutions**:
    - `docker logs <ContainerName>`
    - `docker logs challenge5`
- Do an HTTP request to the endpoint `GET /hello-world`
  - Output expected: `Hello world!`
  - **Solution**:
    - Expose the port in order to communicate:
      - `docker run -d --name challenge5 -p 8080:8080 challenge5`
    - Go to postam and do a GET request:
      - `http://0.0.0.0:8080/hello-world`

### Provide the missing env vars
- The response returned by `GET /hello-world` has two env values missing provide them:
  - Provide the first value through an option of the docker command
    - **Solution**:
      - `docker run -d --name challenge5 -p 8080:8080 -e ORG_EXAMPLE_USER_NAME=hello challenge5`
  - Provide the second value through a file
    - **Solution**:
      - `docker run -d --name challenge5 -p 8080:8080 -e ORG_EXAMPLE_USER_NAME=hello --env-file file challenge5`

### Provide the missing env vars
- The REST service exposes the port 8080, expose this port at port 8095
  - **Solution**
    - `docker run -d --name challenge5 -p 8095:8080 -e ORG_EXAMPLE_USER_NAME=hello --env-file file challenge5`

### Expose ports
- Instead of using the port flag `-p 8080:8080` try it in another easier way, using command line
- **Solution**:
  - `todo`