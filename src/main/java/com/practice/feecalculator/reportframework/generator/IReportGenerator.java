package com.practice.feecalculator.reportframework.generator;

import com.practice.feecalculator.reportframework.IReport;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public interface IReportGenerator {
	<T> void generate(IReport<T> report);
}
