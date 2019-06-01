package com.practice.feecalculator.feeCalculatorapp.feeprocessors;

import java.util.Collection;

import com.practice.feecalculator.feeCalculatorapp.model.Transaction;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public interface IFeeProcessor {
	Collection<Transaction> process(Collection<Transaction> transactions);
}
