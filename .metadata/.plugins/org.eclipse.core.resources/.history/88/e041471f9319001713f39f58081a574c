package textExcel;

import java.util.Arrays;

public class FormulaCell extends RealCell {
	
	
	public FormulaCell(String userInput) {
		super(userInput);
	}
	
	public String abbreviatedCellText() {
		String cellContents = "" + this.getDoubleValue();
		String returnString = cellContents;
		if(cellContents.length() > 10) {
			return(cellContents.substring(0, 10));
		}
		else {
			for(int i = 0; i < 10 - cellContents.length(); i++) {
				returnString += " ";
			}
			return returnString;
		}
	}
	
	public double getDoubleValue() {
		String [] arr = getUserInput().substring(2, getUserInput().length()-2).split(" ");
		double value = Double.valueOf(arr[0]);	
		for(int i = 0; i < arr.length - 1; i += 2) {
			if(arr[i+1].equals("+")) {
				value += Double.valueOf(arr[i+2]);
			}
			else {
				if(arr[i+1].equals("-")) {
					value -= Double.valueOf(arr[i+2]);
				}
				else {
					if(arr[i+1].equals("*")) {
						value *= Double.valueOf(arr[i+2]);
					}
					else {
						if(arr[i+1].equals("/")) {
							value /= Double.valueOf(arr[i+2]);
						}
					}
				}
			}
		}
		return value;
	}
	/*
	public boolean isNumeric(String input) {
		String testString;
		boolean returnValue = true;
		if(input.charAt(0) == '-') {			
			testString = input.substring(1);			
		}
		else {
			testString = input;	
		}
	
		for(int i = 0; i < testString.length(); i ++) {
			if(testString.charAt(i) != '.') {
				if(!Character.isDigit(testString.charAt(i))) {
					return !returnValue;
				}
			}
		}
			return returnValue;
	}
	*/
}
