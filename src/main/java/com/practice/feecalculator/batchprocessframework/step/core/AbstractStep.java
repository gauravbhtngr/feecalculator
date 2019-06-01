package com.practice.feecalculator.batchprocessframework.step.core;

import java.util.function.Consumer;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public abstract class AbstractStep<I, O> implements BatchStep<I, O> {

	private String name;
	private StepStatus status;
	Consumer<I> postProcessConsumer;
	
	public AbstractStep(String name) {
		this.name = name;
	}

	public AbstractStep(String name, Consumer<I> postProcessConsumer) {
		this.name = name;
		this.postProcessConsumer = postProcessConsumer;
	}
	
	@Override
	public String name() {
		return name;
	}

	@Override
	public StepStatus getState() {
		return status;
	}

	@Override
	public void preProcess() {
		// pre process
		this.status = StepStatus.STARTED;
	}

	@Override
	public void postProcess(I input) {
		// post process additional
		if (postProcessConsumer != null) {
			postProcessConsumer.accept(input);
		}
		this.status = StepStatus.FINISHED;
	}
}
