package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int columnNumber;
	private int rowNumber;
    
    public int getRow() {
       return rowNumber;
    }

    
    public int getCol() {
        return columnNumber;
    }
    
    public SpreadsheetLocation(String cellName){
        columnNumber = (int) cellName.charAt(0);
        rowNumber = ParseInt(cellName.substring(1));
        
    }

	private int ParseInt(String substring) {
		return Integer.valueOf(substring);
	}

}
