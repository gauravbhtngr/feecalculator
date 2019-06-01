package com.practice.feecalculator.feeCalculatorapp.feecalculator;

import java.util.Collection;

import com.practice.feecalculator.feeCalculatorapp.feeprocessors.FeeProcessorFactory;
import com.practice.feecalculator.feeCalculatorapp.feeprocessors.IFeeProcessor;
import com.practice.feecalculator.feeCalculatorapp.model.Transaction;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class FeeCalculatorService implements IFeeCalculator {
	
	public Collection<Transaction> feedTransactionFee(Collection<Transaction> transactions) {
		Collection<Transaction> retVal = null;
		for (IFeeProcessor processor : FeeProcessorFactory.getAllFeeProcessor()) {
			retVal = processor.process(transactions);
		}
		return retVal;
	}
	
}
