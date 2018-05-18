package com.example.demo.config;

import org.springframework.core.convert.converter.Converter;

import com.example.demo.bo.Greeting;

public class StringToGreetingConverter implements Converter<String, Greeting> {

	@Override
	public Greeting convert(String from) {
		String[] data = from.split(",");
		return new Greeting(Long.valueOf(data[0]),data[1]);
	}
}
