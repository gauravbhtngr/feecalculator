package com.practice.feecalculator.reportframework.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;

import com.practice.feecalculator.core.exception.ApplicationException;
import com.practice.feecalculator.reportframework.IReport;
import com.practice.feecalculator.reportframework.writer.ReportWriter;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class CSVReportGenerator implements IReportGenerator {

	@Override
	public <T> void generate(IReport<T> report) {
		Collection<T> collection = report.getObjects();
		if (collection == null || collection.isEmpty())
			return;
		try (PrintWriter pw = new PrintWriter(new File(report.getFilePath()))){
			pw.write(report.getHeader());
			pw.write("\n");
			ReportWriter<T> reportWriter = report.getWriter();
			collection.forEach(o -> {
				pw.write(reportWriter.getText(o));
				pw.write("\n");
			});
		} catch (FileNotFoundException e) {
			throw new ApplicationException(String.format("No file found with given path %s", report.getFilePath()));
		}
	}
}
