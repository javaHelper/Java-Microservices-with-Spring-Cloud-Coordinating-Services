# Using Processors And Conditional Subscribers

- Add new exchange as "fastpassprocessor" and queue as "statusqueue" and bind exchange with the queue as shown below

<img width="706" alt="Screenshot 2022-06-07 at 11 47 58 PM" src="https://user-images.githubusercontent.com/54174687/172454325-c29eb28d-e457-4d4d-b8c8-331177b34765.png">

Start the fastpass-ui

Start the toll-intake

<img width="1366" alt="Screenshot 2022-06-07 at 11 50 10 PM" src="https://user-images.githubusercontent.com/54174687/172454675-fb4e1cd3-268d-4a4f-95e2-19fbee0480d6.png">

fastpass-ui application.properties

```sh
server.port=8080
spring.application.name=fastpass-ui
#eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
#eureka.client.register-with-eureka=true
#eureka.client.fetch-registry=true
#eureka.instance.hostname=localhost

spring.cloud.stream.bindings.generatetollcharge-out-0.destination=tolltopic
spring.cloud.stream.bindings.generatetollcharge-out-0.content-type=application/json


spring.cloud.stream.bindings.generatethreecharges-out-0.destination=tolltopic
spring.cloud.stream.bindings.generatethreecharges-out-0.content-type=application/json

spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

FastpassUiApplication.java

```sh
package com.example;

import java.util.ArrayList;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import reactor.core.publisher.Flux;


@SpringBootApplication
public class FastpassUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastpassUiApplication.class, args);
	}

	// This bean will send the messages for every sec
	//@Bean
	public Supplier<FastPassToll> generateTollCharge() {
		return () -> new FastPassToll("800", "1001", 1.05f);
	}

	@Bean
	public Supplier<Flux<Message<FastPassToll>>> generateThreeCharges() {

		ArrayList<Message<FastPassToll>> tolls = new ArrayList<Message<FastPassToll>>();
		tolls.add(MessageBuilder
				.withPayload(new FastPassToll("800", "1001", 1.05f))
				.setHeader("speed", "slow")
				.build());
		
		tolls.add(MessageBuilder
				.withPayload(new FastPassToll("801", "1001", 1.05f))
				.setHeader("speed", "fast")
				.build());
		
		tolls.add(MessageBuilder
				.withPayload(new FastPassToll("802", "1001", 1.05f))
				.setHeader("speed", "slow")
				.build());

		return () -> Flux.fromIterable(tolls);
	}
}
```
