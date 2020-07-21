#!/usr/bin/env bash

docker network create docker-demo-network || true

#docker rm -f kotlin-ddd || true
#docker run -d --name kotlin-ddd -p 8080:8080 kotlin-ddd:0.0.1-SNAPSHOT

docker-compose down
docker-compose up
