FROM ubuntu:22.04

WORKDIR /challenge3
#Option to discard one file using regex expression.
#COPY /dockerfile_files/file[^4]* /challenge3/

#Other option using .dockerignore file
COPY /dockerfile_files/ /challenge3/


##Copy `output.tar` file in the Dockerfile where its content is automatically extracted
#Option1
#COPY output.tar /challenge3/
#RUN tar -xf output.tar && rm output.tar

#Option2
ADD output.tar /challenge3/
