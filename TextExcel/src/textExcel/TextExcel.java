// TextExcel.java Tyler Hackman 3-6-17
package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextExcel {

	public static void main(String[] args) {
	    Spreadsheet spreadsheet = new Spreadsheet();
	    Scanner userInput  = new Scanner (System.in);
	    String input = "";
	    while(!input.equals ("quit")) {
	    	input = spreadsheet.processCommand(userInput.next());
	    		System.out.println(input);
	     	
	    }
	   
	}
}
