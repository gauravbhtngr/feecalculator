package com.practice.feecalculator.batchprocessframework.step.core;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public interface BatchStep<I,O> {
	String name();
	void preProcess();
	O execute(I input);
	void postProcess(I input);
	StepStatus getState();
}
