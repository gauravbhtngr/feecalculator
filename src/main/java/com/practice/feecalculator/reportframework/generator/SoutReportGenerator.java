package com.practice.feecalculator.reportframework.generator;

import java.util.Collection;

import com.practice.feecalculator.reportframework.IReport;
import com.practice.feecalculator.reportframework.writer.ReportWriter;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class SoutReportGenerator implements IReportGenerator {
	
	@Override
	public <T> void generate(IReport<T> report) {
		Collection<T> collection = report.getObjects();
		if (collection == null || collection.isEmpty())
			return;
		
		System.out.println(report.getHeader());
		ReportWriter<T> reportWriter = report.getWriter();
		collection.forEach(o -> {
			System.out.println(reportWriter.getText(o));
		});
	}
}
