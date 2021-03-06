package com.example.demo.config;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableAutoConfiguration
public class SpringBootConfigurer extends WebMvcConfigurerAdapter {


	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new GreetingHandlerMethodArgumentResolver());
		argumentResolvers.add(new GreetingAnotherHandlerMethodArgumentResolver());
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToGreetingConverter());
		registry.addConverter(new GreetingCustomerSSNConverter());
		registry.addConverterFactory(new StringToBaseUserConverterFactory());
		registry.addConverter(new GenericBigDecimalConverter());
	}
}