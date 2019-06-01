package com.practice.feecalculator.batchprocessframework.step.collectionstep;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

import com.practice.feecalculator.batchprocessframework.step.core.AbstractStep;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class CollectionStep<T, O> extends AbstractStep<Collection<T>, O> {
	
	private Function<Collection<T>, O> function;
	
	public CollectionStep(String name, Function<Collection<T>, O> function, Consumer<Collection<T>> postProcessConsumer) {
		super(name, postProcessConsumer);
		this.function = function;
	}

	@Override
	public O execute(Collection<T> input) {
		return function.apply(input);
	}
}
