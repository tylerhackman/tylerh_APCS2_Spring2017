package textExcel;



public class Spreadsheet implements Grid {
	
	private int numberOfRows;
	private int numberOfColumns;
	
	public Spreadsheet(int rows, int columns) {
		numberOfRows = rows;
		numberOfColumns = columns;
		Cell [][] spreadsheet = new Cell [rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				spreadsheet [i][j] = new EmptyCell();
			}
		}
	}
	
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return null;
	}

	
	public int getRows() {
		return numberOfRows;
	}

	
	public int getCols() {
		return numberOfColumns;
	}

	
	public Cell getCell(Location loc)
	{
		
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
