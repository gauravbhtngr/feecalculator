package com.practice.feecalculator.extractorframework;

import java.util.Collection;

import com.practice.feecalculator.extractorframework.mapper.core.MapperFunction;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public interface DataExtractor<S> {
	<T> Collection<T> extract(MapperFunction<S, T> mapperFunction);
}
