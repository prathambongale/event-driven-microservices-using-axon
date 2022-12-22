# event-driven-microservices-using-axon
Practise event-driven using axon framework

### docker command to start axon server
`sudo docker run -d --name axonserver -p 8024:8024 -p 8124:8124 -v "/home/prathambongale/docker-data/data":/data -v "/home/prathambongale/docker-data/eventdata":/eventdata -v "/home/prathambongale/docker-data/config":/config axoniq/axonserver`

If you facing issues with axon docker images download then first pull the images usign below command and then run the above command.

`docker pull axoniq/axonserver`