package com.jimmy.java.development.test;

public class JavaDevelopmentTest {

	private static final int MAX_LOOP_COUNT = 100;
	private static final int FIRST_DIVISOR  = 3;
	private static final int SECOND_DIVISOR = 5;
	
	public static void main (String[] args) throws java.lang.Exception {
		String textToWrite = null;
		for (int i = 1; i <= MAX_LOOP_COUNT; i++) {
			textToWrite = textToOutput(i);
			if (i == MAX_LOOP_COUNT) {
				textToWrite = textToWrite.substring(0, textToWrite.length()-1);
			}
			System.out.print(textToWrite);
		}
	}
	
	public static String textToOutput (int i) {
		String outputText = "" + i;
		if ((i % FIRST_DIVISOR == 0) && (i % SECOND_DIVISOR == 0)) {
			outputText = "BaroSello";
		} else if (i % FIRST_DIVISOR == 0) {
			outputText = "Baro";
		} else if (i % SECOND_DIVISOR == 0) {
			outputText = "Sello";
		}
		return outputText + ",";
	}
}