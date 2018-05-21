package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.Greeting;
import com.example.demo.bo.GreetingAnother;
import com.example.demo.bo.GreetingCustomerSSN;
import com.example.demo.service.Business1;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private Business1 business1;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}

	@RequestMapping(path="/greeting",method=RequestMethod.POST, consumes= {MediaType.APPLICATION_JSON_VALUE} )
	public GreetingAnother greetingPut(GreetingAnother greetAnother) {
		System.out.println("greetAnother Actual String=============="+greetAnother.toString());
		return greetAnother;
	}

	@GetMapping("/string-to-greeting")
	public ResponseEntity<Object> getStringToEmployee(@RequestParam("greet") Greeting greet) {
		return ResponseEntity.ok(greet);
	}

	@GetMapping("/aop")
	public ResponseEntity<Object> getaop() {
		business1.calculateSomething();
		return ResponseEntity.ok("OK");
	}

	@PostMapping("/greetingCustomerSSN")
	public GreetingCustomerSSN greeting(@RequestParam("greetingCustomerSsn") GreetingCustomerSSN greetingCustomerSsn) {
		return greetingCustomerSsn;
	}
}
