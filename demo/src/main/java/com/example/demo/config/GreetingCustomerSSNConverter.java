package com.example.demo.config;

import java.io.IOException;

import org.springframework.core.convert.converter.Converter;

import com.example.demo.bo.CustomerSSN;
import com.example.demo.bo.GreetingCustomerSSN;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GreetingCustomerSSNConverter  implements Converter<String, GreetingCustomerSSN> {

	@Override
	public GreetingCustomerSSN convert(String json) {
		GreetingCustomerSSN ssn =null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ssn = objectMapper.readValue(json,GreetingCustomerSSN.class);
			JsonNode jsonNode = objectMapper.readTree(json);
			String asText = jsonNode.get("ssn").asText();
			int area = Integer.parseInt(asText.substring(0, 3));
			int group = Integer.parseInt(asText.substring(4, 7));
			int serial = Integer.parseInt(asText.substring(8, 11));
			CustomerSSN customerssn = new CustomerSSN(area,group,serial);
			ssn.setSsn(customerssn);
			System.out.println("GreetingCustomerSSNConverter.convert()===="+ssn);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ssn;
	}

}
