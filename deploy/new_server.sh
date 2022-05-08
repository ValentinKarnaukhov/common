sudo apt update
sudo apt install docker.io -y
sudo apt install docker-compose -y

HOST_IP=`wget -qO- ipecho.net/plain`
export HOST_IP=${HOST_IP}
docker-compose up -d