#!/bin/sh

docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q)
docker image prune -f
docker network prune -f

cd /home/usuario/code/ && docker build -t org/webapi .

docker run --name WP-1 -v /home/usuario/archivos:/home/usuario/archivos -v /tmp:/tmp -d -p 80:8080 org/webapi
