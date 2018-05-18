package com.example.demo.config;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.bo.Greeting;

public class GreetingValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Greeting.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Greeting greet = (Greeting)target;
		long id = greet.getId();
		if(id<=-1) {
			errors.rejectValue("id", "greeting.id.invalid", "Greeting id is invalid");
		}
	}
}
