package edu.semaster.checkers.model;

public class Board {
	private final Piece[] pieces;

	public Board(final int rowCount, final int columnCount) {
		if (rowCount <= 0 || columnCount <= 0)
			throw new IllegalArgumentException();
		this.pieces = new Piece[rowCount * columnCount];
	}

	public final Piece[] getPieces() {
		return this.pieces;

	}

	public void initialize() {

		for (int i = 0; i < 23; i += 2) {
			this.getPieces()[i] = new Piece(Piece.Color.WHITE);
		}
		for (int j = 41; j < 64; j +=2) {
			this.getPieces()[j] = new Piece(Piece.Color.BLACK);
		}
	}

	public static boolean isValidPosition(int pos) {
		return 1 <= pos && pos <= 32;
	}

}
