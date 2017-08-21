package com.jimmy.java.development.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JavaDevelopmentTest {

	private static final int    MAX_LOOP_COUNT = 100;
	private static final int    FIRST_DIVISOR  = 3;
	private static final int    SECOND_DIVISOR = 5;
	private static final int    THIRD_DIVISOR  = 7;
	
	public  static final String ANSI_RESET     = "\033[0m";
	public  static final String ANSI_GREEN     = "\033[32m";
	public  static final String ANSI_RED       = "\033[31m";
	public  static final String ANSI_CYAN      = "\033[36m";
	public  static final String ANSI_BLUE      = "\033[34m";
	
	public static void main (String[] args) throws java.lang.Exception {
		String textToWrite = null;
		FileOutputStream fis = new FileOutputStream(new File("Javadevelopment.log"));
		PrintStream out = new PrintStream(fis, true, "US-ASCII"); 
		System.setOut(out);
		
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
			outputText = ANSI_BLUE + "BaroSello" + ANSI_RESET;
		} else if (i % THIRD_DIVISOR == 0) {
			//outputText = ANSI_CYAN + "Nardo" + ANSI_RESET;
		} else if (i % FIRST_DIVISOR == 0) {
			//outputText = ANSI_GREEN + "Baro" + ANSI_RESET;
		} else if (i % SECOND_DIVISOR == 0) {
			//outputText = ANSI_RED + "Sello" + ANSI_RESET;
		}
		return outputText + ",";
	}
}