#!/bin/sh

docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q)
docker image prune -f
docker network prune -f
#docker network create --subnet=172.18.200.0/24 ptracnet

#cd /home/zeke/NGINX-PTRAC-IMAGE/ && docker build -t subdere/nginx-ptrac .
cd /home/zeke/PTRAC-IMAGE/ && docker build -t subdere/ptrac .

#docker run --net ptracnet --ip 172.18.200.2 --name NGINX-PTRAC -p 80:80 -d subdere/nginx-ptrac
#docker run --net ptracnet --ip 172.18.200.3  --name PTRAC-1 -v /home/zeke/archivos:/home/zeke/archivos -v /tmp:/tmp -d subdere/ptrac
#docker run --net ptracnet --ip 172.18.200.4 --name PTRAC-2 -v /home/zeke/archivos:/home/zeke/archivos -v /tmp:/tmp -d subdere/ptrac
#docker run --net ptracnet --ip 172.18.200.5 --name PTRAC-3 -v /home/zeke/archivos:/home/zeke/archivos -v /tmp:/tmp -d subdere/ptrac
docker run --name PTRAC-1 -v /home/zeke/archivos:/home/zeke/archivos -v /tmp:/tmp -d -p 80:8080 subdere/ptrac
zeke@subdere-ptrac:~$ ls
