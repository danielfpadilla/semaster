package edu.semaster.checkers.model;

public class Board {
	private final Piece[][] pieces;

	public Board(final int rowCount, final int columnCount) {
		if (rowCount <= 0 || columnCount <= 0)
			throw new IllegalArgumentException();
		this.pieces = new Piece[rowCount][columnCount];
	}

	public void InitializeBoard() {
		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {
               if(isPositionPainted(i, j) == true)
               {
            	   if(i < 3)
            		   pieces[i][j]= new Piece(Piece.Color.BLACK);
            	   else
            		   if( i > 2 && i <5)
            			   pieces[i][j]= new Piece(Piece.Color.EMPTY);
            		   else
            			   pieces[i][j]= new Piece(Piece.Color.WHITE);
            			   
               }
			}
		}
	}

	public boolean isPositionPainted(int i, int j) {
		if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
			return true;

		} else {
			return false;
		}

	}


}
