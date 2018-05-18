package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.Greeting;
import com.example.demo.bo.GreetingAnother;
import com.example.demo.config.GreetingMessageCodesResolver;
import com.example.demo.config.GreetingValidator;
import com.example.demo.service.Business1;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private Business1 business1;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(new GreetingValidator());
		binder.setMessageCodesResolver(new GreetingMessageCodesResolver());
	}


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
	public ResponseEntity<Object> getStringToEmployee(
			@RequestParam("greet") Greeting greet) {
		return ResponseEntity.ok(greet);
	}

	@PostMapping("/string-to-greeting1")
	public ResponseEntity<Object> getStringToEmployee1(@RequestBody Greeting greet) {
		BeanPropertyBindingResult result = new BeanPropertyBindingResult(greet, "greet");
		ValidationUtils.invokeValidator(new GreetingValidator(), greet, result);
		return ResponseEntity.ok(greet);
	}

	@PostMapping("/string-to-greeting2")
	public ResponseEntity<Object> getStringToEmployee2(@Validated @RequestBody Greeting greet,BindingResult bindingResult,Errors errors) {
		if(bindingResult.hasErrors()) {
			for (ObjectError err : errors.getAllErrors()) {
				String msg = err.getCode();
				return ResponseEntity.ok(msg);
			}
		}
		return ResponseEntity.ok(greet);
	}


	@GetMapping("/aop")
	public ResponseEntity<Object> getaop() {
		business1.calculateSomething();
		return ResponseEntity.ok("OK");
	}

}
