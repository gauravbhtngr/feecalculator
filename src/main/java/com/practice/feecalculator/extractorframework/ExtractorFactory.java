package com.practice.feecalculator.extractorframework;

import com.practice.feecalculator.core.exception.ApplicationException;
import com.practice.feecalculator.extractorframework.txtfile.TXTFileDataExtractor;
import com.practice.feecalculator.extractorframework.xlsxfile.ExcelFileDataExtractor;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class ExtractorFactory {
	
	public static DataExtractor getDataExtractor(Type type, Configuration configuration) {
		switch (type) {
			case TXT:
				return new TXTFileDataExtractor(configuration);
			case XLSX:
				return new ExcelFileDataExtractor(configuration);
			default:
				throw new ApplicationException("Data extractor not supported");
		}
	}
}
