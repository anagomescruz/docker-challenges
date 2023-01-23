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