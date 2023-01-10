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
    --- To check: `docker run -it --name test image_name??` or `docker run -d --name test ubuntu`
- List containers by name and status running:
`docker ps -f "name=sad_wilson" -f "status=running"`
- List containers by partial name

### Lifecycle challenges

- Delete the ubuntu image:
  - stop container if it is running && delete image
  `docker stop Image_ID`
  `docker rmi Image_ID`
- Delete the helloworld container
- In a single command, delete all stopped containers
  - Optional: do it in 3 different ways
- In a single command, delete all unused containers and images
- In a single command, remove all images
  - Optional: do it in 2 different ways