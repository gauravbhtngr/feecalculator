package com.practice.feecalculator.extractorframework.mapper.core;

import com.practice.feecalculator.core.exception.ApplicationException;
import com.practice.feecalculator.extractorframework.mapper.delimitermapper.DelimiterMapperFunction;
import com.practice.feecalculator.extractorframework.mapper.xlsxmapper.XlsxMapper;
import com.practice.feecalculator.feeCalculatorapp.utils.AppUtils;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class MapperFactory {

	public static MapperFunction getMapper(MapperType type, Class objectClass) {
		return getMapper(type, objectClass, null);
	}
	
	public static MapperFunction getMapper(MapperType type, Class objectClass, String separator) {
		switch (type) {
			case CSV:
				return DelimiterMapperFunction.of(objectClass, separator, AppUtils.getHeaderMapping());
			case XLSX:
				return XlsxMapper.of(objectClass, AppUtils.getHeaderMapping());
			default:
				throw new ApplicationException("No mapper function found");
		}
	}
}
