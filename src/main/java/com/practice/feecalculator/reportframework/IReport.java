package com.practice.feecalculator.reportframework;

import java.util.Collection;

import com.practice.feecalculator.reportframework.writer.ReportWriter;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public interface IReport<T> {
	String getHeader();
	String getFilePath();
	Collection<T> getObjects();
	ReportWriter<T> getWriter();
}
