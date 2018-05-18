package com.example.demo.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.demo.bo.Greeting;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GreetingHandlerMethodArgumentResolver  implements HandlerMethodArgumentResolver {

	/** JSON object mapper */
	private ObjectMapper _objectMapper = new ObjectMapper();

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(Greeting.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		Greeting greet = getRequestBody(webRequest);
		if(greet!=null && "Greeting".equalsIgnoreCase(greet.getContent())){
			return greet;
		}
		return  new Greeting(0l,"Greeting_Blank");
	}

	private Greeting getRequestBody(NativeWebRequest webRequest){
		_objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
		try {
			String string = IOUtils.toString(servletRequest.getInputStream());
			return _objectMapper.readValue(string, Greeting.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
