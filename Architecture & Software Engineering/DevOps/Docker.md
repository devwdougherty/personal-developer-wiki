# Docker

## Basic Commands

### Build

Normally:
```bash
$ docker build -t my-container .
```

Build with no-cache (information/data of the previous builds)
```bash
$ docker build --no-cache -t dt:v1 .
```

Build with parent directory : -f
```bash
$ docker build --no-cache -t dt:v1 -f docker/Dockerfile API
```

### Run

First tutorial container

```
$ docker run -d -p 80:80 docker/getting-started
```

**Flags:**

+ -d run the container in detached mode (in the background)
+ -p 80:80 map port 80 of the host to port 80 in the container
+ docker/getting-started the image to use.

Run your container in a silent mode (without get control of terminal)
```bash
$ docker run -d -p 80:80 my-image
```

Run a previous built container:
```
$ docker run -it --rm --name my-running-container my-container
```

Run and enter in your container:
```
sudo docker run -it dt:v1
```

### Basic Workflow to pull, build, run and ship a container on Docker Desktop

```
docker pull store/oracle/serverjre:8

docker build -t devwdougherty/your_path_container .

docker run -it --rm devwdougherty/your_path_container
# or
docker run -i -t your_path_container:version

docker login

docker push devwdougherty/your_path_container

docker build -t your_container .

docker run -it your_container

docker container exec -it my-container bash

docker run -it --publish 8081:8080 your_name/some-app-image
```

### Basic CRUD Operations

```bash
docker info
docker image ls
docker search your_search
docker ps
docker ps -l
# inside container:
exit
docker stop image_id
docker start image_id
docker rm image_id
docker rm container_id
```

### Delete

Delete an image

```bash
docker rmi image_id
```

## DockerFile example

```dockerfile
FROM frolvlad/alpine-gcc

RUN apk add --no-cache g++
RUN apk add --no-cache cmake
RUN apk add --no-cache make
RUN apk add --no-cache curl
RUN apk add --no-cache nano
RUN apk add --no-cache openssh

COPY /API/ /usr/src/project/API
COPY /Serial/ /usr/src/mate/Serial
COPY ./start.sh /usr/src/project/start.sh
COPY ./Makefile /usr/src/project/Makefile

WORKDIR /usr/src/project

RUN make local -C /usr/src/project

EXPOSE 9080

# WORKDIR /usr/src/project

# RUN g++ -o myapp API/test.cpp
# CMD ["./myapp"]
```

Difference between ```CMD``` and ```RUN```

- ```CMD```: The commands using CMD will occur every time the image starts
- ```RUN```: The commands using CMD will occur every time the image compiles


## Bibliography

* [Beginner’s guide to use docker (Build, Run, Push and Pull)](https://medium.com/@deepakshakya/beginners-guide-to-use-docker-build-run-push-and-pull-4a132c094d75)
* [Docker For Beginners](https://medium.com/the-andela-way/docker-for-beginners-61e8e0ce6a19)
* [Deploy WAR in Docker tomcat container](https://medium.com/@pra4mesh/deploy-war-in-docker-tomcat-container-b52a3baea448)
* [Docker commands](https://github.com/prameshbhattarai/docker-commands)
* [Best practices for writing Dockerfiles](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)
- [How to run database, backend and frontend in a single-click with Docker Compose](https://medium.com/@wkrzywiec/how-to-run-database-backend-and-frontend-in-a-single-click-with-docker-compose-4bcda66f6de)
- [How To Remove Docker Images, Containers, and Volumes](https://www.digitalocean.com/community/tutorials/how-to-remove-docker-images-containers-and-volumes)
+ [Quick Start for Apache Kafka using Confluent Platform Community Components (Docker)](https://docs.confluent.io/platform/current/quickstart/cos-docker-quickstart.html)
