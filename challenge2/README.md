# Challenge 2
### Managing containers & images
Set of challenges to learn how to view and manage containers and images

In these challenges we'll learn how to
- List images
- List containers
- Control lifecycle of images and containers

Setup environment:
- Run the Dockerfile in the challenge folder
- Run `docker run -dit ubuntu /bin/bash`

Repeat the setup step as many times as necessary throughout the challenges.

Advised time: 1h30min

### Listing challenges
Images
- List images
- List all images
- List only the images IDs
- List only images from Ubuntu
- List untagged images

Containers
- List containers
- List all containers
- List containers not running
- List containers by name
  - Optional: give a specific name to a container
- List container by name and not running

### Lifecycle challenges
- Delete the ubuntu image
- Delete the helloworld container
- In a single command, delete all stopped containers
  - Optional: do it in 3 different ways
- In a single command, delete all unused containers and images
- In a single command, remove all images
  - Optional: do it in 2 different ways

### Example solutions and explanations
#### Listing challenges - Images
- [List images](https://docs.docker.com/engine/reference/commandline/images/)
    ```
    docker images
    ```
- List all images
    ```
    docker images -a
    ```
- List only the images IDs
    ```
    docker images -q
    ```
- List only images from Ubuntu
    ```
    docker images ubuntu
    ```
- List untagged images
    ```
    docker images --filter "dangling=true"
    ```

#### Listing challenges - Containers
- [List containers](https://docs.docker.com/engine/reference/commandline/ps/)
    ```
    docker ps
    ```
    ```
    docker container ls
    ```
- List all containers
    ```
    docker ps -a
    ```
- List containers not running
    ```
    docker ps -f "status=exited" 
    ```
- List containers by name
    ```
    docker ps -f "name=stupefied_"
    ```
  - Optional: give a specific name to a container
    ```
    docker run -dit ubuntu --name containerName /bin/bash

    ```
- List container by name and not running
    ```
    docker ps -f "name=stupefied_" -f "status=exited"
    ```

#### Lifecycle challenges
- Delete the ubuntu image
  - [docker kill](https://docs.docker.com/engine/reference/commandline/kill/)
      ```
      docker kill <container ID using image>
      ```
  - [docker rm](https://docs.docker.com/engine/reference/commandline/rm/)
      ```
      docker rm <container ID using the image>
      ```
  - [docker rmi](https://docs.docker.com/engine/reference/commandline/rmi/)
      ```
      docker rmi ubuntu
      ```
- Delete the helloworld container
  ```
  docker rm <container name>
  ```
- In a single command, delete all stopped containers
  ```
  docker rm <container name>
  ```
  ```
  docker rm $(docker ps -a -q status=exited)
  ```
  - [docker container prune](https://docs.docker.com/engine/reference/commandline/container_prune/)
    ```
    docker container prune
    ```
- In a single command, delete all unused containers and images
  - [docker system prune](https://docs.docker.com/engine/reference/commandline/system_prune/)
    ```
    docker system prune -a
    ```
- In a single command, remove all images
  ```
  docker rmi <list of images ID>
  ```
  ```
  docker rmi $(docker images -q)
  ```
