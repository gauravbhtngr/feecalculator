package com.practice.feecalculator.feeCalculatorapp.report;

import java.nio.file.Paths;
import java.util.Collection;

import com.practice.feecalculator.reportframework.IReport;
import com.practice.feecalculator.feeCalculatorapp.model.Transaction;
import com.practice.feecalculator.reportframework.writer.ReportWriter;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class TransactionReport implements IReport<Transaction> {

	private Collection<Transaction> iterator;
	private final String delimiter;
	private final String[] headers = new String[]{"Client Id", "Transaction Type", "Transaction Date", "Priority", "Processing Fee"};
	
	public TransactionReport(Collection<Transaction> iterator, String delimiter) {
		this.iterator = iterator;
		this.delimiter = delimiter;
	}

	@Override
	public String getHeader() {
		return String.join(delimiter, headers);
	}

	@Override
	public String getFilePath() {
		return Paths.get("src","main","resources", "output.csv").toString();
	}

	@Override
	public Collection<Transaction> getObjects() {
		return iterator;
	}

	@Override
	public ReportWriter<Transaction> getWriter() {
		return new TransactionReportWriter(delimiter);
	}
}
