package com.practice.feecalculator.feeCalculatorapp.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.practice.feecalculator.reportframework.ReportType;
import com.practice.feecalculator.batchprocessframework.step.collectionstep.CollectionStep;
import com.practice.feecalculator.batchprocessframework.step.supplierstep.SupplierStep;
import com.practice.feecalculator.extractorframework.Configuration;
import com.practice.feecalculator.extractorframework.ExtractorFactory;
import com.practice.feecalculator.extractorframework.Type;
import com.practice.feecalculator.extractorframework.mapper.core.MapperFactory;
import com.practice.feecalculator.extractorframework.mapper.core.MapperType;
import com.practice.feecalculator.feeCalculatorapp.feecalculator.CalculatorType;
import com.practice.feecalculator.feeCalculatorapp.feecalculator.FeeCalculatorFactory;
import com.practice.feecalculator.feeCalculatorapp.model.Transaction;
import com.practice.feecalculator.feeCalculatorapp.report.TransactionReport;
import com.practice.feecalculator.reportframework.generator.ReportGeneratorFactory;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class AppUtils {
	public static boolean isPriority(String priority) {
		return priority.equalsIgnoreCase("Y");
	}
	
	public static Map<String, String> getHeaderMapping() {
		Map<String, String> headerMapping = new HashMap<>();
		headerMapping.put("External Transaction Id", "externalTransactionId");
		headerMapping.put("Client Id", "clientId");
		headerMapping.put("Security Id", "securityId");
		headerMapping.put("Transaction Type", "transactionType");
		headerMapping.put("Transaction Date", "transactionDate");
		headerMapping.put("Market Value", "marketValue");
		headerMapping.put("Priority Flag", "priorityFlag");
		return headerMapping;
	}
	
	public static SupplierStep<List<Transaction>, Collection<Transaction>> getStartStep(String name, 
	                                                                                    Type extractorType,
	                                                                                    MapperType mapperType, 
	                                                                                    String filePath) {
		return new SupplierStep<>(name,
				() -> ExtractorFactory.getDataExtractor(extractorType, Configuration
						.builder()
						.path(filePath)
						.build())
						.extract(MapperFactory.getMapper(mapperType, Transaction.class)));
	}
	
	public static Consumer<Collection<Transaction>> getReportGenerator(ReportType type, String delimiter) {
		return (o) -> ReportGeneratorFactory.getGenerator(type)
				.generate(new TransactionReport(o, delimiter));
	}
	
	public static CollectionStep<Transaction, Collection<Transaction>> getFeeProcessorStep(String name, CalculatorType type, Consumer<Collection<Transaction>>  reportGeneratorConsumer) {
		return new CollectionStep<>(name,
				FeeCalculatorFactory.getCalculator(type)::feedTransactionFee, reportGeneratorConsumer);
	}
}
