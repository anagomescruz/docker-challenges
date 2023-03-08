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
- Run the image of the previous step
  - Output expected: `Hello world!`

### Push an image to Docker Hub
- Publish the image of the previous challenge/step to Docker Hub to your repository with the tag 1.0
- Remove the published image from your machine and run the image by fetching it from Docker Hub