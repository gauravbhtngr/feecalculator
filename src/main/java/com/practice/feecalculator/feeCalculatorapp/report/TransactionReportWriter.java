package com.practice.feecalculator.feeCalculatorapp.report;

import com.practice.feecalculator.feeCalculatorapp.model.Transaction;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class TransactionReportWriter  extends AbstractReportWriter<Transaction> {

	public TransactionReportWriter(String delimiter) {
		super(delimiter);
	}

	@Override
	public String getText(Transaction input) {
		StringBuilder builder = new StringBuilder();
		return builder
				.append(input.getClientId().toString())
				.append(delimiter)
				.append(input.getTransactionType().toString())
				.append(delimiter)
				.append(input.getTransactionDate().toString())
				.append(delimiter)
				.append(input.getPriorityFlag())
				.append(delimiter)
				.append(input.getProcessingFee().toString())
				.toString();
	}
	
}
