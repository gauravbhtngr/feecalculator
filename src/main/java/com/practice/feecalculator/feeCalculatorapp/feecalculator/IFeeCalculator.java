package com.practice.feecalculator.feeCalculatorapp.feecalculator;

import java.util.Collection;

import com.practice.feecalculator.feeCalculatorapp.model.Transaction;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public interface IFeeCalculator {
	Collection<Transaction> feedTransactionFee(Collection<Transaction> transactions);
}
