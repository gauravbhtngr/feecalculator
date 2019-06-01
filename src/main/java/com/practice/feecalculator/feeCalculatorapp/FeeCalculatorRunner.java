package com.practice.feecalculator.feeCalculatorapp;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import com.practice.feecalculator.batchprocessframework.runner.BatchRunner;
import com.practice.feecalculator.batchprocessframework.runner.SimpleBatchRunner;
import com.practice.feecalculator.batchprocessframework.step.collectionstep.CollectionStep;
import com.practice.feecalculator.batchprocessframework.step.supplierstep.SupplierStep;
import com.practice.feecalculator.extractorframework.Type;
import com.practice.feecalculator.extractorframework.mapper.core.MapperType;
import com.practice.feecalculator.feeCalculatorapp.feecalculator.CalculatorType;
import com.practice.feecalculator.feeCalculatorapp.model.Transaction;
import com.practice.feecalculator.feeCalculatorapp.utils.AppUtils;
import com.practice.feecalculator.reportframework.ReportType;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class FeeCalculatorRunner {

	public static void main(String... arg) {

		SupplierStep<List<Transaction>, Collection<Transaction>> extractorStep
				= AppUtils.getStartStep("Extract date from excel", Type.XLSX, MapperType.XLSX, "Sample Data.xlsx");

		Consumer<Collection<Transaction>> reportGeneratorConsumer = AppUtils.getReportGenerator(ReportType.SOUT, "|");

		CollectionStep<Transaction, Collection<Transaction>> feeCalculatorStep
				= AppUtils.getFeeProcessorStep("Transaction fee process with simple calculator",
				CalculatorType.SIMPLE,
				reportGeneratorConsumer);

		BatchRunner runner = SimpleBatchRunner
				.builder()
				.name("Fee calculator")
				.startWith(extractorStep)
				.then(feeCalculatorStep)
				.chunk(10)
				.build();
		runner.execute();
	}
}
