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
  - Solution:
    - `FROMubuntu:22.04 `
    - `WORKDIR/challenge3`
- Copy the files in the folder `dockerfile_files`, except file `file4`
  - Solution:
    - `create a .dockerigone file to except the file4`
- Copy `output.tar` file in the Dockerfile where its content is automatically extracted
  - `output.tar` contains `compressed_file1` and `compressed_file2`
  - Solution:
    - `COPY /dockerfile_files/ /challenge3/ `
- Run the image and validate its content
  - Solution:
    - Run image `docker run -dit IMAGE /bin/bash`
    - Enter the container `docker exec -it containerName bash`

### Copying files from the local machine to a container

- Copy the folder `docker_container_files` to the container of the previous challenge
  - Solution:
    - `docker cp {path in your localhost to where the file/folder is stored} {containerId}:{to_the_place_you_want_the_file_to_be}`
    - `docker cp docker_container_files/ 0fe8a98b3a22:/challenge3/`
- Validate the content in the container

### Copying files from a Docker container to the local machine

- Create a file `hello_world` in the container of the previous challenge and copy it to the local machine
  - Solution:
    - Go to the container
      `docker exec -it sharp_stonebraker bash`
    - Create a file
      `touch hello_world`
    - Exit the container
    - Copy hello_world file to the local machine
      - `docker cp {containerId}:/{path_of_the_file_to_copy} {to_the_place_you_want_the_file_in_your_local_machine}`
      - `docker cp 0fe8a98b3a22:/challenge3/hello_world .`
- Validate locally the file was copied
