package com.practice.feecalculator.extractorframework.txtfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.practice.feecalculator.extractorframework.AbstractDataExtractor;
import com.practice.feecalculator.extractorframework.Configuration;
import com.practice.feecalculator.extractorframework.mapper.core.MapperFunction;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class TXTFileDataExtractor extends AbstractDataExtractor<String> {

	public TXTFileDataExtractor(Configuration configuration) {
		super(configuration);
	}

	@Override
	public <T> Collection<T> extract(MapperFunction<String, T> mapperFunction) {
		String line = "";
		String header = "";
		int count = 0;
		List<T> objects = new ArrayList<T>();
		try (InputStream is = getStreamFromFile(); BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			while ((line = reader.readLine()) != null) {
				if (count == 0 && isHeaderEnabled()) {
					header = line;
				} else {
					objects.add(mapperFunction.apply(line, header));
				}
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objects;
	}
}
