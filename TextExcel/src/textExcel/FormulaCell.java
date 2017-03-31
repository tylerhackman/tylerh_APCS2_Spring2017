package textExcel;

public class FormulaCell extends RealCell {
	
	
	public FormulaCell(String userInput) {
		super(userInput);
	}
	
	public String abbreviatedCellText() {
		String returnString = "";
		String input = getUserInput().substring(1, getUserInput().length()-1);
		String [] arr = input.split(" ");
		int returnValue = Integer.valueOf(arr[0]);
		for(int i = 0; i < arr.length; i++) {
			if(i != arr.length-1) {
				if(arr[i+1].equals("+")) {
					
						returnValue += (Integer.valueOf(arr[i+2])); 
					
				}
				else {
					if(arr[i+1].equals("-")) {
						
							returnValue -= (Integer.valueOf(arr[i+2])); 
						
					}
					else {
						if(arr[i+1].equals("*")) {
							
							returnValue *= (Integer.valueOf(arr[i+2])); 
							
						}
						else {
							if(arr[i+1].equals("/")) {
								
								returnValue /= (Integer.valueOf(arr[i+2])); 
								
							}
						}
					}
				}
			}
		
		}
		returnString = "" + returnValue;
		if(returnString.length() > 10) {
			returnString = returnString.substring(0, 10);
		}
		else {
			for(int i = 0; i < 10 - returnString.length(); i++) {
				returnString += " ";
			}
		}
		return returnString;
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getUserInput());
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
