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
- Run the image of the previous step detached and give the container a name 
- View the logs of the container to confirm if the application is up 
- Do an HTTP request to the endpoint `GET /hello-world`
  - Output expected: `Hello world!`

### Provide the missing env vars
- The response returned by `GET /hello-world` has two env values missing provide them:
  - Provide the first value through an option of the docker command
  - Provide the second value through a file

### Provide the missing env vars
- The REST service exposes the port 8080, expose this port at port 8095