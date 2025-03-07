package com.javatechie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@RestController
public class GreetingController {

	private static final Logger logger = Logger.getLogger(GreetingController.class.getName());
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info(String.format(template, name));
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
