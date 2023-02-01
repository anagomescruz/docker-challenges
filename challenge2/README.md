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
`docker images`
- List all images:
`docker images -a`
- List only the images IDs:
`docker images -q`
- List only images from Ubuntu:
`docker images ubuntu`
- List untagged images:
`docker images --filter "dangling=true"`

Containers

- List containers:
`docker container` or `docker ps`
- List all containers:
`docker container ls -a `
- List containers not running:
`docker ps -f "status=exited"`
- List containers by name
`docker ps -f "name=sad_wilson"`
  - Optional: give a specific name to a container:
    `docker run --name container_name image`
- List containers by name and status running:
`docker ps -f "name=sad_wilson" -f "status=running"`
- List containers by partial name
`docker ps -a -f "name=t"`


### Lifecycle challenges

- Delete the ubuntu image:
  - stop container if it is running && delete image
  `docker stop Image_ID`
  `docker rmi Image_ID`
  `docker rmi ubuntu`
- Delete the helloworld container
  `docker rm helloworld`
- In a single command, delete all stopped containers
  - Optional: do it in 3 different ways
  `docker rm $(docker ps -f status=exited -q)`
  `docker rm $(docker ps -a -q)`
  `docker ps --filter status=exited -q | xargs docker rm`
- In a single command, delete stopped container by partial names
  `docker rm $(docker ps -f status=exited -f name=test2 -q)`
- In a single command, delete all unused containers and images
  `docker system prune -a`
- In a single command, remove all images
  - Optional: do it in 2 different ways
  `docker rmi $(docker images -a -q)`
  `docker rmi image1 image2`