package com.practice.feecalculator.feeCalculatorapp.report;

import com.practice.feecalculator.reportframework.writer.ReportWriter;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public abstract class AbstractReportWriter<T> implements ReportWriter<T> {
	protected final static String COMMA = ",";
	protected final String delimiter;

	public AbstractReportWriter(String delimiter) {
		if (delimiter == null || delimiter.trim().isEmpty()) {
			this.delimiter = COMMA;
		} else {
			this.delimiter = delimiter;
		}
	}
}
