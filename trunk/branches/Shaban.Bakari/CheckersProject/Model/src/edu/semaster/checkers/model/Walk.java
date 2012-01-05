package edu.semaster.checkers.model;

import edu.semaster.checkers.baseproject.FigureType;

public class Walk extends Move {
    Board board = new Board(8, 8);
	public Walk(int sourceX, int sourceY, int targetX, int targetY) {
		super(sourceX, sourceY, targetX, targetY);
	}
	
	public Boolean isAValidWalk(int sX, int sY, int dX, int dY)
	{
		while(board.isPositionPainted(sX, sY))
		{
		if((sX == dX+1 && sY == dY+1) || (sX == dX+1 && sY == dY-1))
			return true;
		else
			return false;
		}
		return false;
		
	}
	
	  private static boolean isEmpty(FigureType[][] board, int i, int j)
	    {
	            if (i>-1 && i<8 && j>-1 && j<8)
	                    if (board[i][j] == new FigureType(FigureType.Type.NONE));
	            return true;
	    }
	
	

}
