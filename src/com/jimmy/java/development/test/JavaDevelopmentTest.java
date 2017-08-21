package com.jimmy.java.development.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

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
		OutputDetails textToWrite    = null;
		String        twitterMessage = "";
		FileOutputStream fis = new FileOutputStream(new File("Javadevelopment.log"));
		PrintStream out = new PrintStream(fis, true, "US-ASCII"); 
		System.setOut(out);
		
		for (int i = 1; i <= MAX_LOOP_COUNT; i++) {
			textToWrite = textToOutput(i);
			if (i == MAX_LOOP_COUNT) {
				textToWrite.setOutputText(textToWrite.getOutputText().substring(0, textToWrite.getOutputText().length()-1));
			}
			if (textToWrite.isWriteToConsole()) {
				System.out.print(textToWrite.getOutputText());
			}
			if (textToWrite.isWriteToTwitter()) {
				twitterMessage += textToWrite.getOutputText();
			}
		}
		if (twitterMessage != null) {
			writeMessageToTwitter(twitterMessage);
		}
	}
	
	public static OutputDetails textToOutput (int i) {
		String outputText      = "" + i;
		boolean writeToConsole = false;
		boolean writeToTwitter = false;
		if ((i % FIRST_DIVISOR == 0) && (i % SECOND_DIVISOR == 0)) {
			outputText = ANSI_BLUE + "BaroSello" + ANSI_RESET;
			writeToConsole = true;
		} else if (i % THIRD_DIVISOR == 0) {
			outputText = ANSI_CYAN + "Nardo" + ANSI_RESET;
			writeToConsole = true;
		} else if (i % FIRST_DIVISOR == 0) {
			outputText = ANSI_GREEN + "Baro" + ANSI_RESET;
			writeToTwitter = true;
		} else if (i % SECOND_DIVISOR == 0) {
			outputText = ANSI_RED + "Sello" + ANSI_RESET;
			writeToConsole = true;
			writeToTwitter = true;
		}
		outputText += ",";
		return new OutputDetails(outputText, writeToConsole, writeToTwitter);
	}
	
	public static boolean writeMessageToTwitter(String twitterMessage) {
		boolean messageSent = false;
		DirectMessage message = null;
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("QLZzwq5uc37CipB6fczdAYdty")
		  .setOAuthConsumerSecret("fiQy2ww5atJgPMCA3TNt9tiYMRL7THyfUU879iwG3z2O9Vc6YO")
		  .setOAuthAccessToken("146793688-coPS7krtEbTwShgiZguabMtUo9qYWa8Lyv24SOGv")
		  .setOAuthAccessTokenSecret("S6U9uQcnJV2sopUEeWWtr5HUsazHx4JfWl8LeT6YNFtmq");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		 try {
			 message = twitter.sendDirectMessage("hammermcc", twitterMessage);
	         System.out.println("Direct message successfully sent to " + message.getRecipientScreenName());
	         messageSent = true;
	     } catch (TwitterException te) {
	         te.printStackTrace();
	         System.out.println("Failed to send a direct message: " + te.getMessage());
	     } finally {
	    	 if (message != null) {
	    		 message = null;
	    	 }
	    	 if (twitter != null) {
	    		 twitter = null;
	    	 }
	     }
		 return messageSent;
	}
	
	public static class OutputDetails {
		private String outputText = null;
		private boolean writeToConsole = false;
		private boolean writeToTwitter = false;

		public OutputDetails (String outputText, boolean writeToConsole, boolean writeToTwitter) {
			this.outputText     = outputText;
			this.writeToConsole = writeToConsole;
			this.writeToTwitter = writeToTwitter;
		}
		
		public String getOutputText() {
			return this.outputText;
		}

		public void setOutputText(String outputText) {
			this.outputText = outputText;
		}

		public boolean isWriteToConsole() {
			return this.writeToConsole;
		}

		public void setWriteToConsole(boolean writeToConsole) {
			this.writeToConsole = writeToConsole;
		}

		public boolean isWriteToTwitter() {
			return this.writeToTwitter;
		}

		public void setWriteToTwitter(boolean writeToTwitter) {
			this.writeToTwitter = writeToTwitter;
		}
	}
}