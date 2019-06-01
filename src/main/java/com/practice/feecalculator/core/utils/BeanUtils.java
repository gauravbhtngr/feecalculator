package com.practice.feecalculator.core.utils;

import java.time.LocalDate;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;

import com.practice.feecalculator.feeCalculatorapp.utils.DateUtils;
import com.practice.feecalculator.core.exception.ApplicationException;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class BeanUtils {
	
	public static void populate(Object bean, Map<String, ? extends Object> properties) {
		try {
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean(new ConvertUtilsBean() {
				@Override
				public Object convert(String value, Class clazz) {
					if (clazz.isEnum()) {
						return Enum.valueOf(clazz, value);
					} else if (LocalDate.class.isAssignableFrom(clazz)) {
						return DateUtils.parse(value);
					} else {
						return super.convert(value, clazz);
					}
				}
			});
			beanUtilsBean.populate(bean, properties);
		} catch (Exception e) {
			throw new ApplicationException("Something went worng with the object conversion", e);
		}
	}
}
