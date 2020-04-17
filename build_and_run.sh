#!/usr/bin/env bash
# builds the repo in a docker container

./build.sh

# Alternativ:
#docker build -t kotlin-ddd:0.0.1-SNAPSHOT ./Dockerfile_With_Build_Step
./run.sh
