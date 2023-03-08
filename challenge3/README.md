# Challenge 3
### Copying files and validating them in running containers
Set of challenges to copy files from and to the container and local machine

In these challenge we'll learn how to
- Copy files through instructions on the Dockerfile
- Ignoring content to be copied
- Copy files from the local machine to a container
- Copy files from the container to the local machine
- Interact with running containers

### Copying files through the Dockerfile challenge
- Create an image where your working directory is challenge3
- Copy the files in the folder `dockerfile_files`, except file `file4`
- Copy `output.tar` file in the Dockerfile where its content is automatically extracted
  - `output.tar` contains `compressed_file1` and `compressed_file2` 
- Run the image and validate its content

### Copying files from the local machine to a container
- Copy the folder `docker_container_files` to the container of the previous challenge
- Validate the content in the container

### Copying files from a Docker container to the local machine
- Create a file `hello_world` in the container of the previous challenge and copy it to the local machine
- Validate locally the file was copied


### Example solutions and explanations
### Copying files through the Dockerfile challenge
`[.dockerignore](https://docs.docker.com/engine/reference/builder/#dockerignore-file0)`
```.dockerignore
dockerfile_files/file4
```
Paths defined in this file will be ignored when being copied in the COPY instruction in a Dockerfile. This file should be in the same path as the Dockerfile.

Dockerfile
```dockerfile
FROM ubuntu:22.04
WORKDIR challenge3
# COPY dockerfile_files/[^file4] .  -> alternative option to avoid docker ignore
COPY dockerfile_files .
ADD output.tar .
```
Intructions:
- [FROM](https://docs.docker.com/engine/reference/builder/#from)
  - Initializes a new build stage and sets the Base Image for subsequent instructions
  - Creates a layer from the ubuntu:22.04
- [WORKDIR](https://docs.docker.com/engine/reference/builder/#workdir)
  - Defines the working directory on image build from this step forward 
  - Creates and sets `challenge3` as the working directory
- [COPY](https://docs.docker.com/engine/reference/builder/#copy)
  - Copied the files in `dockerfile_files` to the current folder of the image build 
  - Regex exclusion option 
    - Commented option where you can exclude the file name(`[^file4]`) of just the number(`file[^4]`)
    - Not useful when there are several files to be copied and the name pattern differs
- [ADD](https://docs.docker.com/engine/reference/builder/#add)
  - similar to COPY 
  - Allows adding files from URLs and extracting directly the content of compressed files 
  - Copied and extracted the files in output.tar to the current folder of the image build

**Create the image**
```
docker build -t helloworld .
```

**[Run the image](https://docs.docker.com/engine/reference/commandline/run/) and keep the container running**
```
docker run -dit test /bin/bash
```
Options:
- `--detach` , `-d`
  - Runs the container in background and prints the container ID
- `--interactive` , `--tty`, `-it`
  - Starts the container in the interactive mode
  - Keeps STDIN open even if not attached
  - Allocates a pseudo-TTY connected to the container’s stdin, creating an interactive bash shell in the container
  - `/bin/bash`
    - Path of the executable file to interact with

**[Access the running container](https://docs.docker.com/engine/reference/commandline/exec/) and validate its content**
````
docker exec -it <container ID> bash
````
Command:
- `exec`
  - Runs a new command in a running container
  - Container defined through the container ID
  - An executable file must be defined as the command

### [Copy files](https://docs.docker.com/engine/reference/commandline/cp/) from the local machine to a container
````
docker cp docker_container_files/ <container ID>:.
````
Access the running container and validate its content

### [Copy files](https://docs.docker.com/engine/reference/commandline/cp/) from the container to the local machine
Access the container and create the `hello_world` file
````
$ docker exec -it <container ID> bash
root@<container ID>:/# touch hello_world
````
Copy the hello world file from container to current folder in local machine
````
docker cp <container ID>:hello_world .
````
