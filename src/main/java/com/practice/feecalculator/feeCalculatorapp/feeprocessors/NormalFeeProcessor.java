package com.practice.feecalculator.feeCalculatorapp.feeprocessors;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.TreeMap;

import com.practice.feecalculator.feeCalculatorapp.model.GroupByKey;
import com.practice.feecalculator.feeCalculatorapp.model.Transaction;
import com.practice.feecalculator.feeCalculatorapp.model.TransactionMode;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class NormalFeeProcessor implements IFeeProcessor {
	@Override
	public Collection<Transaction> process(Collection<Transaction> transactions) {
		return processNormalCharges(transactions);
	}

	private Collection<Transaction> processNormalCharges(Collection<Transaction> transactions) {
		TreeMap<GroupByKey, Transaction> transactionMap = new TreeMap<>();
		transactions.forEach((o) -> {
			GroupByKey key = o.groupByKey();
			Transaction tr = transactionMap.get(key);
			if (tr != null) {
				this.addCharge(tr);
			} else {
				Transaction newTr = o;
				this.addCharge(o);
				transactionMap.put(key, newTr);
			}
		});
		return transactionMap.values();
	}

	private void addCharge(Transaction transaction) {
		if (transaction.getTransactionMode() == TransactionMode.INTRA) {
			transaction.setProcessingFee(BigDecimal.TEN);
		} else if (transaction.isHighPriority()) {
			transaction.setProcessingFee(getFee(transaction.getProcessingFee(), new BigDecimal(500)));
		} else if (transaction.isSell() || transaction.isWithdraw()) {
			transaction.setProcessingFee(getFee(transaction.getProcessingFee(), new BigDecimal(100)));
		} else if (transaction.isBuy() || transaction.isDeposit()) {
			transaction.setProcessingFee(getFee(transaction.getProcessingFee(), new BigDecimal(50)));
		}
	}

	private BigDecimal getFee(BigDecimal existingFee, BigDecimal fee) {
		if (existingFee != null) {
			return existingFee.add(fee);
		}
		return fee;
	}
}
