package edu.semaster.checkers.baseProject;

public class Piece {
	public static enum Color {
		WHITE, WHITE_KING, BLACK, BLACK_KING, EMPTY;
	}

	private Color mColor= Color.EMPTY;

	public Piece(Color color) {
		mColor = color;
	}
	
	public Piece()
	{
		
	}
	

	public Color getColor() {
		return mColor;

	}
	
	public void setColor(Color color)
	{
		mColor = color;
	}

}
