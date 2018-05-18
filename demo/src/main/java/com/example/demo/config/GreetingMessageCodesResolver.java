package com.example.demo.config;

import org.springframework.validation.MessageCodesResolver;

public class GreetingMessageCodesResolver implements MessageCodesResolver  {

	@Override
	public String[] resolveMessageCodes(String errorCode, String objectName) {
		System.out.println(errorCode + objectName);
		String customErrorCode = "Greeting-/" + objectName + "/" + errorCode;
		return new String[]{customErrorCode};
	}

	@Override
	public String[] resolveMessageCodes(String errorCode, String objectName, String field, Class<?> fieldType) {
		String customErrorCode = "Greeting-/" + objectName + "/" + fieldType.getName() + "/" + field + "/" + errorCode;
		return new String[]{customErrorCode};
	}

}
