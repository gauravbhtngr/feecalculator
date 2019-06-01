package com.practice.feecalculator.extractorframework;

import java.io.InputStream;

import com.practice.feecalculator.core.exception.ApplicationException;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public abstract class AbstractDataExtractor<S> implements DataExtractor<S> {
	private final Configuration configuration;

	protected AbstractDataExtractor(Configuration configuration) {
		this.configuration = configuration;
	}

	protected InputStream getStreamFromFile() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream(this.configuration.getPath());
		if (is == null) {
			throw new ApplicationException("File not found with given path");
		}
		return is;
	}

	protected boolean isHeaderEnabled() {
		return configuration.isHeaderEnabled();
	}
}
