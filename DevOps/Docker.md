# Basic Commands

## Basic Workflow to build, run and ship a container on Docker Desktop
```
docker build -t devwdougherty/your_path_container .

docker run -it --rm devwdougherty/your_path_container
# or
docker run -i -t your_path_container:version

docker login

docker push devwdougherty/your_path_container
```

**Pull a container image:**
```
docker pull store/oracle/serverjre:8
```

# Bibliography

* [Beginner’s guide to use docker (Build, Run, Push and Pull)](https://medium.com/@deepakshakya/beginners-guide-to-use-docker-build-run-push-and-pull-4a132c094d75)

