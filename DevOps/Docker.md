# Basic Commands

## Basic Workflow to pull, build, run and ship a container on Docker Desktop
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
```
## Basic operations
```
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

# Bibliography

* [Beginner’s guide to use docker (Build, Run, Push and Pull)](https://medium.com/@deepakshakya/beginners-guide-to-use-docker-build-run-push-and-pull-4a132c094d75)
* [Docker For Beginners](https://medium.com/the-andela-way/docker-for-beginners-61e8e0ce6a19)
* [Deploy WAR in Docker tomcat container](https://medium.com/@pra4mesh/deploy-war-in-docker-tomcat-container-b52a3baea448)
* [Docker commands](https://github.com/prameshbhattarai/docker-commands)
* [Best practices for writing Dockerfiles](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)
