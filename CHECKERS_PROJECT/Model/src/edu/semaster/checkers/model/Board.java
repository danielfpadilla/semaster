package edu.semaster.checkers.model;
import edu.semaster.checkers.baseProject.FigureType;


public class Board {
	private final FigureType[][] pieces;

	public Board(final int rowCount, final int columnCount) {
		if (rowCount <= 0 || columnCount <= 0)
			throw new IllegalArgumentException();
		this.pieces = new FigureType[rowCount][columnCount];
	}

	public void InitializeBoard() {
		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {
               if(isPositionPainted(i, j) == true)
               {
            	   if(i < 3)
            		   pieces[i][j]= new FigureType(FigureType.Type.BLACK);
            	   else
            		   if( i > 2 && i <5)
            			   pieces[i][j]= new FigureType(FigureType.Type.NONE);
            		   else
            			   pieces[i][j]= new FigureType(FigureType.Type.WHITE);
            			   
               }
			}
		}
	}

	public boolean isPositionPainted(int i, int j)
	{
		if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0))
		{
			
			return true;

		}
		else 
		{
			return false;
		}

	}
	
	public  FigureType getDefaultFigure(int x, int y) {

		if (x < 3) {
			if (!((x % 2 == 0 && y % 2 != 0)
					|| (x % 2 != 0 && y % 2 == 0))) {
				return new FigureType(FigureType.Type.BLACK);
			}
		}

		if (x > 4) {

			if (!((x % 2 == 0 && y % 2 != 0)
					|| (x % 2 != 0 && y % 2 == 0))) {
				return new FigureType(FigureType.Type.WHITE);
			}
		}

		return new FigureType(FigureType.Type.NONE);
	}


}
