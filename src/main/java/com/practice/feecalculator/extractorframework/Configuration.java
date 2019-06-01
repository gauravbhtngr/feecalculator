package com.practice.feecalculator.extractorframework;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class Configuration {
	private String path;
	private boolean headerEnabled = true;
	public Configuration(ConfigurationBuilder builder) {
		this.path = builder.path;
		this.headerEnabled = builder.headerEnabled;
	}
	
	public static ConfigurationBuilder builder() {
		return new ConfigurationBuilder();
	}

	public String getPath() {
		return path;
	}

	public boolean isHeaderEnabled() {
		return headerEnabled;
	}

	public static class ConfigurationBuilder {
		private String path;
		private boolean headerEnabled = true;
		
		public ConfigurationBuilder path(String path) {
			this.path = path;
			return this;
		}

		public ConfigurationBuilder headerEnabled(boolean headerEnabled) {
			this.headerEnabled = headerEnabled;
			return this;
		}
		
		public Configuration build() {
			return new Configuration(this);
		}
	} 
}
