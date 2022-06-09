# Setting Up and using Partitions

- Execute Each Request 

http://localhost:8080/customerdetails?fastpassid=800
http://localhost:8080/customerdetails?fastpassid=801
http://localhost:8080/customerdetails?fastpassid=802

# Docker for RabbitMQ

`docker run -d --hostname local-rabbit --name pluralsight-rmq -p 15672:15672 -p 5672:5672 rabbitmq:3.9.9-management`

- Services
- Start the fastpass-service, then fastpass-ui and toll-rate

- For Partition-1
`mvn spring-boot:run -Dspring-boot.run.arguments=--spring.cloud.stream.instanceIndex=0`


- For Partition-2
`mvn spring-boot:run -Dspring-boot.run.arguments=--spring.cloud.stream.instanceIndex=1`


- For Partition-3
`mvn spring-boot:run -Dspring-boot.run.arguments=--spring.cloud.stream.instanceIndex=2`

<img width="803" alt="Screenshot 2022-06-09 at 10 31 24 PM" src="https://user-images.githubusercontent.com/54174687/172903672-eac52a3d-5f1b-48ca-9530-3e42f04e23ac.png">

<img width="614" alt="Screenshot 2022-06-09 at 10 31 11 PM" src="https://user-images.githubusercontent.com/54174687/172903687-fb24bdeb-dea2-4b7d-9c8e-87967090aafa.png">

<img width="1052" alt="Screenshot 2022-06-09 at 10 29 50 PM" src="https://user-images.githubusercontent.com/54174687/172903689-eb9146c4-9971-46c7-a6e6-b65f55ac8d51.png">

-----------------
<img width="1241" alt="Screenshot 2022-06-09 at 10 33 48 PM" src="https://user-images.githubusercontent.com/54174687/172903865-4daae1c0-0b3d-4cba-9644-cfb3086cdc99.png">

<img width="1235" alt="Screenshot 2022-06-09 at 10 33 32 PM" src="https://user-images.githubusercontent.com/54174687/172903872-bc4a33ae-fdb3-4030-b859-2193afe80aca.png">

<img width="1242" alt="Screenshot 2022-06-09 at 10 33 57 PM" src="https://user-images.githubusercontent.com/54174687/172903841-282a2e31-4c4e-412a-9a9c-cdd08c6bb6c4.png">
