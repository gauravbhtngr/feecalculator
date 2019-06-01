package com.practice.feecalculator.reportframework.writer;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public interface ReportWriter<T> {
	String getText(T input);
}
