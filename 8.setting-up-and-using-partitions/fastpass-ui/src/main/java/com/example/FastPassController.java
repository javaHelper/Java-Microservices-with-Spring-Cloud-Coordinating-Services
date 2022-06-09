package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class FastPassController {

    @Autowired
	StreamBridge streamBridge;


    @RequestMapping(path="/customerdetails")
	public String getFastPassCustomerDetails(@RequestParam(defaultValue = "800") String fastpassid, Model m) {

        WebClient client = WebClient.create();

        FastPassCustomer customer = client.get()
            .uri("http://localhost:8091/fastpass?fastpassid=" + fastpassid)
            .retrieve()
            .bodyToMono(FastPassCustomer.class)
            .block();
		
		System.out.println("fastpassid: " + fastpassid);
		m.addAttribute("customer", customer);

		System.out.println("Customer : "+ customer);
		
        //send message to stream endpoint first
        streamBridge.send("generatetollcharge-out-0", new FastPassToll(fastpassid, "1000", 1.05f));

        //return view name
		return "console";

    }
    
}
