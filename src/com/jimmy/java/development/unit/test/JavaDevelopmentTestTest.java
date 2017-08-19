package com.jimmy.java.development.unit.test;

import com.jimmy.java.development.test.JavaDevelopmentTest;

import junit.framework.TestCase;

public class JavaDevelopmentTestTest extends TestCase {
	
	public void testBaro () {
		String output = JavaDevelopmentTest.textToOutput(3);
		
		assertEquals("Passing the value 3 does not match", "Baro,", output);
	}
	
	public void testSello () {
		String output = JavaDevelopmentTest.textToOutput(5);
		
		assertEquals("Passing the value 5 does not match", "Sello,", output);
	}
	
	public void testBaroSello () {
		String output = JavaDevelopmentTest.textToOutput(15);
		
		assertEquals("Passing the value 15 does not match", "BaroSello,", output);
	}

}
