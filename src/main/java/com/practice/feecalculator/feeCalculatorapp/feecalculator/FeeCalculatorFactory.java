package com.practice.feecalculator.feeCalculatorapp.feecalculator;

import com.practice.feecalculator.core.exception.ApplicationException;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class FeeCalculatorFactory {
	
	public static IFeeCalculator getCalculator(CalculatorType type) {
		switch (type) {
			case SIMPLE:
				return new FeeCalculatorService();
			default:
				throw new ApplicationException("No calculator found");
		}
	}
}
