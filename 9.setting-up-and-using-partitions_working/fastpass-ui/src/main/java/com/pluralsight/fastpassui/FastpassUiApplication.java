package com.pluralsight.fastpassui;

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

	//@Bean
	public Supplier<FastPassToll> generateTollCharge() {
		return () -> new FastPassToll("800", "1001", 1.05f);
	}

	//@Bean
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

			return() -> Flux.fromIterable(tolls);
	}

}
