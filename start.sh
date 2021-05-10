#!/bin/bash
docker stop feed-server
docker rm feed-server
docker build --tag feed-server:1.0 .
docker run --name feed-test-01 feed-server:1.0