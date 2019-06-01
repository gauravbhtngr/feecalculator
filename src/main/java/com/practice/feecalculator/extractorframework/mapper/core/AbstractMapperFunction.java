package com.practice.feecalculator.extractorframework.mapper.core;

import java.util.Map;

import com.practice.feecalculator.core.exception.ApplicationException;
import com.practice.feecalculator.core.utils.BeanUtils;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public abstract class AbstractMapperFunction<I, T> implements MapperFunction<I, T> {
	private final Map<String, String> headerMapping;
	private final Class<T> objectClass;

	public AbstractMapperFunction(Map<String, String> mapping, Class<T> objectClass) {
		this.headerMapping = mapping;
		this.objectClass = objectClass;
	}

	protected boolean isHeaderMappingAvailable() {
		return headerMapping != null && !headerMapping.isEmpty();
	}

	protected boolean isEmpty(String input) {
		return input == null || input.trim().isEmpty();
	}

	protected String getKey(String currentKey) {
		if (isHeaderMappingAvailable()) {
			String key = headerMapping.get(currentKey);
			return isEmpty(key) ? currentKey : key;
		}
		return currentKey;
	}

	protected T convertToObject(Map<String, ? extends Object> objectMap) {
		try {
			T obj = objectClass.newInstance();
			BeanUtils.populate(obj, objectMap);
			return obj;
		} catch (Exception e) {
			throw new ApplicationException("Something went worng with the object conversion", e);
		}
	}
}
