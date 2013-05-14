package androidGame.tacticalrpg;

public class TactGame {

	private Cell grid[][];

	private final int ROWS = 8;
	private final int COLUMNS = 13;
	
	public TactGame()
	{
		grid = new Cell[ROWS][COLUMNS];
		
		clearGame();
	}

	private void clearGame() 
	{	
		for(int i=0; i<ROWS; i++)
			for(int j=0; j<COLUMNS; j++)
				grid[i][j] = new EmptyCell();
	}
}
