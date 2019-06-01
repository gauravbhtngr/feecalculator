package com.practice.feecalculator.feeCalculatorapp.feeprocessors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class FeeProcessorFactory {
	public static List<IFeeProcessor> getAllFeeProcessor() {
		List<IFeeProcessor> processors = new ArrayList<>();
		processors.add(new IntraDayFeeProcessor());
		processors.add(new NormalFeeProcessor());
		return processors;
	}
}
