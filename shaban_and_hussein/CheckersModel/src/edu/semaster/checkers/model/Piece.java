package edu.semaster.checkers.model;

public class Piece {
	public static enum Color {
		WHITE, WHITE_KING, BLACK, BLACK_KING, EMPTY;
	}

	private Color mColor;

	public Piece(Color color) {
		mColor = color;
	}

	public Color getColor() {
		return mColor;

	}

}
