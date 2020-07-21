#!/usr/bin/env bash
# builds the repo in a docker container

docker build -t kotlin-ddd:0.0.1-SNAPSHOT -f Dockerfile_With_Build_Step .

./run.sh
