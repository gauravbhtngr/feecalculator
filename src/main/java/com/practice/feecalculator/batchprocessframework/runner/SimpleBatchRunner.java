package com.practice.feecalculator.batchprocessframework.runner;

import java.util.ArrayList;
import java.util.List;

import com.practice.feecalculator.batchprocessframework.step.core.BatchStep;
import com.practice.feecalculator.batchprocessframework.step.supplierstep.SupplierStep;
import com.practice.feecalculator.core.exception.ApplicationException;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class SimpleBatchRunner implements BatchRunner {

	private List<BatchStep> steps = new ArrayList<BatchStep>();
	private String name;
	private int chunk;

	private SimpleBatchRunner(SimpleBatchRunnerBuilder builder) {
		this.steps = builder.steps;
		this.name = builder.name;
		this.chunk = builder.chunk;
	}

	public String getName() {
		return name;
	}

	public void execute() {
		Object object = null;
		for (BatchStep step : this.steps) {
			step.preProcess();
			object = step.execute(object);
			step.postProcess(object);
		}
	}

	public static SimpleBatchRunnerBuilder builder() {
		return new SimpleBatchRunnerBuilder();
	}

	public static class SimpleBatchRunnerBuilder {
		private List<BatchStep> steps = new ArrayList<BatchStep>();
		private String name;
		private int chunk;

		public SimpleBatchRunnerBuilder name(String name) {
			this.name = name;
			return this;
		}

		public SimpleBatchRunnerBuilder startWith(BatchStep step) {
			start(step);
			return this;
		}

		public SimpleBatchRunnerBuilder then(BatchStep step) {
			if (this.steps.isEmpty()) {
				throw new ApplicationException("Please provide start step by calling startWith");
			}
			this.steps.add(step);
			return this;
		}

		public SimpleBatchRunnerBuilder chunk(int chunk) {
			this.chunk = chunk;
			return this;
		}

		public SimpleBatchRunner build() {
			return new SimpleBatchRunner(this);
		}

		private void start(BatchStep step) {
			if(!(step instanceof SupplierStep)) {
				throw new ApplicationException("batch runner will always be start from supplier");
			}
			if (this.steps.isEmpty()) {
				this.steps.add(step);
			} else {
				this.steps.add(0, step);
			}
		}
	}
}
