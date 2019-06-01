package com.practice.feecalculator.feeCalculatorapp.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by gaurav.bhatnagar on 12/2/18.
 */
public class DateUtils {
	
	public static boolean isEqual(LocalDate start, LocalDate end) {
		return Period.between(start, end).getDays() == 0;
	}
	
	public static LocalDate parse(String date) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/d/yy");
		return LocalDate.parse(date, df);
	}
}
