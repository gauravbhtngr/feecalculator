package com.practice.feecalculator.extractorframework.xlsxfile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.practice.feecalculator.core.exception.ApplicationException;
import com.practice.feecalculator.extractorframework.AbstractDataExtractor;
import com.practice.feecalculator.extractorframework.Configuration;
import com.practice.feecalculator.extractorframework.mapper.core.MapperFunction;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class ExcelFileDataExtractor extends AbstractDataExtractor<Row> {

	public ExcelFileDataExtractor(Configuration configuration) {
		super(configuration);
	}

	@Override
	public <T> Collection<T> extract(MapperFunction<Row, T> mapperFunction) {
		List<T> objects = new ArrayList<T>();
		try (InputStream in = getStreamFromFile(); Workbook workbook = new XSSFWorkbook(in)) {
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();
			int count = 0;
			Row headerRow = null;
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if (count == 0 && isHeaderEnabled()) {
					headerRow = nextRow;
				} else {
					objects.add(mapperFunction.apply(nextRow, headerRow));
				}
				count++;
			}
		} catch (IOException e) {
			throw new ApplicationException("Something wrong with the file", e);
		}
		return objects;
	}
}
