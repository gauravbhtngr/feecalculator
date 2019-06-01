package com.practice.feecalculator.extractorframework.mapper.xlsxmapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import com.practice.feecalculator.core.exception.ApplicationException;
import com.practice.feecalculator.extractorframework.mapper.core.AbstractMapperFunction;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class XlsxMapper<T> extends AbstractMapperFunction<Row, T> {
	private final DataFormatter objDefaultFormat = new DataFormatter();
	public XlsxMapper(Class<T> objectClass, Map<String, String> mapping) {
		super(mapping, objectClass);
	}

	public static <T> XlsxMapper<T> of(Class<T> objectClassToMapTo, Map<String, String> mapping) {
		return new XlsxMapper<>(objectClassToMapTo, mapping);
	}
	
	@Override
	public T apply(Row input, Row header) {
		if (noHeader(header)) {
			throw new ApplicationException("No header available in the excel file");
		}
		return convertToObject(buildObjectFromRow(input, header));
	}
	
	private boolean noHeader(Row header) {
		return header == null;
	}
	
	private Map<String, String> buildObjectFromRow(Row input, Row header) {
		Map<String, String> retVal = new HashMap<>();
		Iterator<Cell> cellIterator = input.cellIterator();
		int count = 0;
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			retVal.put(getKey(objDefaultFormat.formatCellValue(header.getCell(count))), objDefaultFormat.formatCellValue(cell));
			count++;
		}
		return retVal;
	}
}
