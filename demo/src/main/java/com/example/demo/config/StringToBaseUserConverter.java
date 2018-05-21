package com.example.demo.config;

import org.springframework.core.convert.converter.Converter;

import com.example.demo.bo.Admin;
import com.example.demo.bo.BaseUser;
import com.example.demo.bo.Employee;

public class StringToBaseUserConverter<T extends BaseUser> implements Converter<String, T> {


	private Class<T> targetType;

	public StringToBaseUserConverter (Class<T> targetType) {
		this.targetType = targetType;
	}


	@Override
	public T convert(String source) {

		if(targetType.isAssignableFrom(Admin.class)){
			return (T)new Admin(source, "001");
		}
		if(targetType.isAssignableFrom(Employee.class)){
			return (T)new Employee(source, "001");
		}
		return null;
	}
}





/*public class StringToBaseUserConverter implements Converter<String, Admin> {

	@Override
	public Admin convert(String from) {

		if("ADMIN".equalsIgnoreCase(from)) {
			return new Admin(from,"01");
		}
		//return new Employee(from,"01");
		return null;
	}
}
 */