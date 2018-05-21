package com.example.demo.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.example.demo.bo.BaseUser;

public class StringToBaseUserConverterFactory implements
ConverterFactory<String, BaseUser> {

	@Override
	public <T extends BaseUser> Converter<String, T> getConverter (Class<T> targetType) {
		return new StringToBaseUserConverter<>(targetType);
	}
}