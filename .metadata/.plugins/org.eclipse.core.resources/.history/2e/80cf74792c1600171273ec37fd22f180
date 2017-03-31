package textExcel;

public class FormulaCell extends RealCell {
	
	
	public FormulaCell(String userInput) {
		super(userInput);
	}
	
	public String abbreviatedCellText() {
		int first, second;
		String returnString = "";
		String input = getUserInput().substring(1, getUserInput().length()-1);
		String [] arr = input.split(" ");
		for (int i = 0; i <  )
		if(isNumeric(arr[0])) {
			if(arr[1].equals("+")) {
				if(isNumeric(arr[2])) {
					returnString += (Integer.valueOf(arr[0]) + Integer.valueOf(arr[2])); 
				}
			}
			else {
				if(arr[1].equals("-")) {
					if(isNumeric(arr[2])) {
						returnString += (Integer.valueOf(arr[0]) - Integer.valueOf(arr[2])); 
					}
				}
				else {
					if(arr[1].equals("*")) {
						if(isNumeric(arr[2])) {
							returnString += (Integer.valueOf(arr[0]) * Integer.valueOf(arr[2])); 
						}
					}
					else {
						if(arr[1].equals("/")) {
							if(isNumeric(arr[2])) {
								returnString += (Integer.valueOf(arr[0]) / Integer.valueOf(arr[2])); 
							}
						}
					}
				}
			}
		}
		return returnString;
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getUserInput());
	}
	
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
}
