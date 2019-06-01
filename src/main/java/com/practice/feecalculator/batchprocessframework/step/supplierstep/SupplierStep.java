package com.practice.feecalculator.batchprocessframework.step.supplierstep;

import java.util.function.Supplier;

import com.practice.feecalculator.batchprocessframework.step.core.AbstractStep;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class SupplierStep<I, O> extends AbstractStep<I, O> {

	private Supplier<O> supplier;
	
	public SupplierStep(String name, Supplier<O> supplier) {
		super(name);
		this.supplier = supplier;
	}

	@Override
	public O execute(I input) {
		return supplier.get();
	}
}
