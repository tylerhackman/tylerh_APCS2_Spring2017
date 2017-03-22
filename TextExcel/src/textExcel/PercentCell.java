package textExcel;

public class PercentCell extends RealCell {
	
	public PercentCell(String userInput) {
		super(userInput);
	}
	
	public String abbreviatedCellText() {
		String percent = userInput.substring(0, userInput.indexOf("."));
		percent += "%";
		String returnString = percent;
		for(int i = 0; i < 10 - percent.length(); i++) {
			returnString += " ";
		}
		return returnString;
	}
	
	public String fullCellText() {
		String returnString = "" + this.getDoubleValue();
		return returnString;
	}
	
	public double getDoubleValue() {
		return (Double.parseDouble(userInput.substring(0, userInput.indexOf("%")))/100);
	}
}
