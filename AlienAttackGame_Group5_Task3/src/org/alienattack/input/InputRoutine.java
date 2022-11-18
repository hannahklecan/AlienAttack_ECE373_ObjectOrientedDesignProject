package org.alienattack.input;

import java.util.Scanner;

/*
 * Generalized Input Routine for console based applications 
 * 
 * Sanitizes user input to prevent input errors
 * 
 */

public class InputRoutine {
	
	//Putting the Scanner object here makes it global so it does not have to be passed to modules.
	  static Scanner keyboard = new Scanner(System.in);
	  
	  final static String NEW_LINE = "\n";        //set to "\n" to display on newline
	  

	  /** Gets a String from the keyboard. Rejects null entry or any number of spaces.
	    * @param msg is the text that will be displayed the user to ask them to enter a value.
	    * @return Returns a String from the keyboard. 
	    */ 
	  public static String getString(String msg) {
	     String answer = "";
	     
	     System.out.print(msg + NEW_LINE);
	     try {
	        answer = keyboard.nextLine(); 
	     }
	     catch (Exception e) {
	        System.err.println("Error reading input from user. Ending program.");
	        System.exit(-1);
	     } 
	     
	     while (answer.replace(" ", "").equals("")) {
	        System.err.println("Error: Missing input.");
	        try {
	           System.out.print(msg + NEW_LINE);;
	           answer = keyboard.nextLine(); 
	        }
	        catch (Exception e) {
	           System.err.println("Error reading input from user. Ending program.");
	           System.exit(-1);
	        } 
	     }
	     return answer;            
	  }
	  
	  //------------------------------------------------------------------------------------------------------------------
	  /** Gets an Integer from the keyboard. Rejects null, spaces and non-integers.
	    * @param msg is the text that will be displayed the user to ask them to enter a number.
	    * @return Returns an int from the keyboard. 
	    */  
	  public static int getInteger(String msg) {
	     System.out.print(msg + NEW_LINE);;
	     while (!keyboard.hasNextInt()) {
	        keyboard.nextLine();
	        System.err.println("Invalid integer. Try again.");
	     }
	     int number = keyboard.nextInt();
	     keyboard.nextLine(); //flushes the buffer
	     return number;
	  }
	  
	  //------------------------------------------------------------------------------------------------------------------
	  /** Gets a Yes or No answer from the keyboard. Calls getString to rejects null input and spaces.
	    * @param msg is the text that will be displayed the user.
	    * @return Returns a boolean value. True = yes; False = no. 
	    */ 
	  public static boolean getYorN(String msg) {
	     String answer = getString(msg);
	     
	     while (answer.compareToIgnoreCase("y")   != 0 
	         && answer.compareToIgnoreCase("yes") != 0 
	         && answer.compareToIgnoreCase("n")   != 0 
	         && answer.compareToIgnoreCase("no")  != 0) {
	        
	        if (answer.replace(" ", "").equals("")) {
	           System.err.println("Error: Missing y/n input.");
	        } else {
	           if (answer.compareToIgnoreCase("y")   != 0 
	            && answer.compareToIgnoreCase("yes") != 0 
	            && answer.compareToIgnoreCase("n")   != 0 
	            && answer.compareToIgnoreCase("no")  != 0) {
	              System.err.println("Error: Unexpected input.");
	           }
	        }
	        answer = getString(msg);
	     } 
	     
	     if  (answer.compareToIgnoreCase("y")   == 0  
	       || answer.compareToIgnoreCase("yes") == 0) {
	        return true;
	     } 
	     else {
	        return false;
	     }
	  }
	  
	  //------------------------------------------------------------------------------------------------------------------
	  /** Closes the scanner.
	    */ 
	  public static void closeScanner() {
	     try { 
	        if(keyboard != null) {
	           keyboard.close(); 
	        }
	     } 
	     catch (Exception e) { // (Exception) catches all errors java might throw here
	        System.err.println("Error closing reader.");
	     }
	  }
	  //------------------------------------------------------------------------------------------------------------------
	  /** Generates a random number between low and high, inclusive.
	    * @param low is the smallest number that will be randomly generated.
	    * @param high is the largest number that will be randomly generated.
	    * @return Returns the random number as an integer.
	    */
	  public static int getRandomNumber (int low, int high) {
	     return (int)(Math.random() * ((high + 1) - low)) + low;
	  }
	  
	  
}
