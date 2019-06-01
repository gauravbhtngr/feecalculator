package com.practice.feecalculator.reportframework.generator;

import com.practice.feecalculator.core.exception.ApplicationException;
import com.practice.feecalculator.reportframework.ReportType;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class ReportGeneratorFactory {
	
	public static IReportGenerator getGenerator(ReportType reportType) {
		switch (reportType) {
			case SOUT:
				return new SoutReportGenerator();
			case CSV:
				return new CSVReportGenerator();
			default:
				throw new ApplicationException("Can not find report generator");
		}
	}
}
