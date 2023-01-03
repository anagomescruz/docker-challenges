# Challenge 1
### Create and run an image where the terminal prints "Hello World!"
Emulate the act of running `echo Hello World` in the terminal

In this challenge we'll learn how to
- Create a Docker image
- Use instructions within the image
- Use [Docker Hub](https://hub.docker.com/) (images repository)
- Run docker images

Extra optional challenges:
- Emulate running a script that echoes Hello World in the terminal with 2 different instructions
- Build and run an image in a single command

Advised time: 2h

### Example solutions and explanations
[Dockerfile](https://docs.docker.com/engine/reference/builder/)
- File without extension
- Default file name expected by Docker is Dockerfile (case sensitive)
- Simple text file that consists of instructions to build Docker images
- Syntax
  - INSTRUCTION arguments
  - #comments

#### Dockerfile to echo Hello World in the terminal
```dockerfile
FROM ubuntu:22.04
CMD echo Hello World
```
Instructions used in Dockerfile
- [FROM](https://docs.docker.com/engine/reference/builder/#from)
  - Initializes a new build stage and sets the Base Image for subsequent instructions
  - Creates a layer from the ubuntu:22.04
- [CMD](https://docs.docker.com/engine/reference/builder/#cmd)
  - There can only be one CMD command per Dockerfile
    - If more than one is present only the last one will be executed
  - Defines the default executable of a Docker image
    - This image can be run as the base of a container without adding command-line arguments
  - Has 3 forms that take different arguments
  - Runs the command `echo hello world`

Command used to [create](https://docs.docker.com/engine/reference/commandline/build/) the image
```
docker build -t helloworld .
```

Command used to [run](https://docs.docker.com/engine/reference/commandline/run/) the image
```
docker run helloworld
```

[Nice to know] Command used to create and run the image
```
docker run $(docker build -q .)
```
<br/>

#### Dockerfile to run script that echoes Hello World
Create a Hello world script in the same folder of the Dockerfile - `script.sh`
```shell
#!/bin/sh
echo "Hello World"
```
```dockerfile
FROM ubuntu:22.04
COPY script.sh .
RUN chmod +x /script.sh
ENTRYPOINT ["/bin/bash", "/script.sh"]
```
Instructions used in Dockerfile
- [FROM](https://docs.docker.com/engine/reference/builder/#from)
  - Creates a layer from the ubuntu:22.04
- [COPY](https://docs.docker.com/engine/reference/builder/#copy)
  - Copies files or directories from a source path to a destination path
    - Source path - is in the local machine, is relative to where the Dockerfile is defined or absolute path of the machine
    - Destination path - is in the filesystem of the container, can be a relative or absolute path
  - Copied file `script.sh` to current folder of the image build
- [RUN](https://docs.docker.com/engine/reference/builder/#run)
  - Execute any commands in a new layer on top of the current image and commit the results
  - The resulting committed image will be used for the next step in the Dockerfile
  - Has 2 forms that take different arguments
  - Giving executable permissions for the script file
- [ENTRYPOINT](https://docs.docker.com/engine/reference/builder/#entrypoint)
  - Allows to configure a container to run as an executable
  - Has 2 forms that take different arguments
  - Calls the executable `/bin/bash` with the script file as the argument
