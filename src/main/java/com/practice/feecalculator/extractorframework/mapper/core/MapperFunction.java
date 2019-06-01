package com.practice.feecalculator.extractorframework.mapper.core;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public interface MapperFunction<I, T> {
	T apply(I input, I header);
}
