package com.practice.feecalculator.extractorframework.mapper.delimitermapper;

import java.util.HashMap;
import java.util.Map;

import com.practice.feecalculator.core.exception.ApplicationException;
import com.practice.feecalculator.extractorframework.mapper.core.AbstractMapperFunction;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class DelimiterMapperFunction<T> extends AbstractMapperFunction<String, T> {
	private final String delimiter;
	
	private DelimiterMapperFunction(Class<T> objectClass, String delimiter, Map<String, String> mapping) {
		super(mapping, objectClass);
		this.delimiter = delimiter;
	}

	public static <T> DelimiterMapperFunction<T> of(Class<T> objectClassToMapTo, String separator, Map<String, String> mapping) {
		return new DelimiterMapperFunction<>(objectClassToMapTo, separator, mapping);
	}
	
	public T apply(String input, String header) {
		if (isEmpty(header)) {
			throw new ApplicationException("No header provided");
		}
		return convertToObject(getObject(input, header));
	}
	
	private Map<String, Object> getObject(String line, String header) {
		Map<String, Object> retObj = new HashMap<>();
		String[] headers = header.split(delimiter);
		String[] value = line.split(delimiter);
		if (headers.length < value.length) {
			throw new ApplicationException("Header and value count missmatch");
		}
		if (value.length == 0) {
			return null;
		}
		for (int i=0; i< value.length; i++) {
			retObj.put(getKey(headers[i]), value[i]);
		}
		return retObj;
	}
}
