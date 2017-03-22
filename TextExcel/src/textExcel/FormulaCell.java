package textExcel;

public class FormulaCell extends RealCell {
	
	public FormulaCell(String userInput) {
		super(userInput);
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(userInput);
	}
}
