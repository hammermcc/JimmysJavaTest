package com.jimmy.java.development.unit.test;

import com.jimmy.java.development.test.JavaDevelopmentTest;
import com.jimmy.java.development.test.JavaDevelopmentTest.OutputDetails;

import junit.framework.TestCase;

public class JavaDevelopmentTestTest extends TestCase {
	
	public void testBaro () {
		OutputDetails output = JavaDevelopmentTest.textToOutput(3);
		
		assertEquals("Passing the value 3 text to output does not match", JavaDevelopmentTest.ANSI_GREEN + "Baro" + JavaDevelopmentTest.ANSI_RESET + ",", output.getOutputText());
		assertEquals("Passing the value 3 writing to Console does not match", false, output.isWriteToConsole());
		assertEquals("Passing the value 3 writing to Twitter does not match", true, output.isWriteToTwitter());
	}
	
	public void testSello () {
		OutputDetails output = JavaDevelopmentTest.textToOutput(5);
		
		assertEquals("Passing the value 5 text to output does not match", JavaDevelopmentTest.ANSI_RED + "Sello" + JavaDevelopmentTest.ANSI_RESET + ",", output.getOutputText());
		assertEquals("Passing the value 5 writing to Console does not match", true, output.isWriteToConsole());
		assertEquals("Passing the value 5 writing to Twitter does not match", true, output.isWriteToTwitter());
	}
	
	public void testNardo () {
		OutputDetails output = JavaDevelopmentTest.textToOutput(7);
		
		assertEquals("Passing the value 7 text to output does not match", JavaDevelopmentTest.ANSI_CYAN + "Nardo" + JavaDevelopmentTest.ANSI_RESET + ",", output.getOutputText());
		assertEquals("Passing the value 7 writing to Console does not match", true, output.isWriteToConsole());
		assertEquals("Passing the value 7 writing to Twitter does not match", false, output.isWriteToTwitter());
	}
	
	public void testBaroSello () {
		OutputDetails output = JavaDevelopmentTest.textToOutput(15);
		
		assertEquals("Passing the value 15 text to output does not match", JavaDevelopmentTest.ANSI_BLUE + "BaroSello" + JavaDevelopmentTest.ANSI_RESET + ",", output.getOutputText());
		assertEquals("Passing the value 15 writing to Console does not match", true, output.isWriteToConsole());
		assertEquals("Passing the value 15 writing to Twitter does not match", false, output.isWriteToTwitter());
	}

	public void testSendMessageToTwitter () {
		boolean messageSent = JavaDevelopmentTest.writeMessageToTwitter("Why am I writing code in a pub on a Sunday ?");
		
		assertEquals("Message was not sent to Twitter", true, messageSent);
	}
}
