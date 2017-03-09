package textExcel;



public class Spreadsheet implements Grid {
	
	private int numberOfRows = 20;
	private int numberOfColumns = 12;
	
	public Spreadsheet() {
		Cell [][] spreadsheet = new Cell [20][12];
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 12; j++) {
				spreadsheet [i][j] = new EmptyCell();
			}
		}
	}
	
	public String processCommand(String command) {
		int row, column;
		if(command.length() <= 3) {
			column = Character.getNumericValue(command.charAt(0)) - 10;
	    	row = Integer.valueOf((command.substring(1))) - 1;
	    	
			
		}
		return command;
	}

	
	public int getRows() {
		return numberOfRows;
	}

	
	public int getCols() {
		return numberOfColumns;
	}

	
	public Cell getCell(Location loc) {
		
		return null;
	}

	public String getGridText() {
		String grid = "";
		String firstCell = "   |"
		return null;
	}

}
