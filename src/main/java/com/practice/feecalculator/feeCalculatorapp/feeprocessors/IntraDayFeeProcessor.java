package com.practice.feecalculator.feeCalculatorapp.feeprocessors;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.practice.feecalculator.feeCalculatorapp.model.IntradayTransactionKey;
import com.practice.feecalculator.feeCalculatorapp.model.Transaction;
import com.practice.feecalculator.feeCalculatorapp.model.TransactionMode;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class IntraDayFeeProcessor implements IFeeProcessor {
	Map<IntradayTransactionKey, Transaction> intradayTransaction = new HashMap<>();

	@Override
	public Collection<Transaction> process(Collection<Transaction> transactions) {
		processIntraDayCharges(transactions);
		return transactions;
	}

	private void processIntraDayCharges(Collection<Transaction> transactions) {
		for (Transaction transaction : transactions) {
			IntradayTransactionKey key = transaction.intradayKey();
			Transaction tr = intradayTransaction.get(key);
			if (tr != null) {
				tr.setTransactionMode(TransactionMode.INTRA);
				transaction.setTransactionMode(TransactionMode.INTRA);
			} else {
				intradayTransaction.put(key, transaction);
			}
		}
	}
}
