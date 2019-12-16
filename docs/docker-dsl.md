# Docker DSL

The docker dsl uses the jenkins docker plugin. It is distinct from, but similar to docker agents.

With the docker dsl you can build, pull, run, and push containers.  You can run steps inside of a container.

https://jenkins.io/doc/book/pipeline/docker/

Pipelinekt library includes a base implementation for the docker dsl; it also includes a custom DockerDsl class
which exposes a simple "insideContainer" method.

## Run in an existing container

## Run in a Dockerfile

## Run With Sidecars 

