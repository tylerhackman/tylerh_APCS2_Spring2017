package textExcel;

public class RealCell implements Cell {

	String userInput;
	
	public RealCell (String contents) {
		userInput = contents;
	}
	
	public String abbreviatedCellText() {
		String newCellContents = userInput;
		if(userInput.length() > 10) {
			return(userInput.substring(0, 10));
		}
		else {
			for(int i = 0; i < 10 - userInput.length(); i++) {
				newCellContents += " ";
			}
			return newCellContents;
		}
	
	}

	
	public String fullCellText() {
		String newCellContents = userInput;
		return newCellContents;
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(userInput);
	}

}
