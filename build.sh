#!/usr/bin/env bash

./gradlew clean build
docker build -t kotlin-ddd:0.0.1-SNAPSHOT .
