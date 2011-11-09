package edu.semaster.checkers.modeltest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.semaster.checkers.model.Board;
import edu.semaster.checkers.model.Piece;
import edu.semaster.checkers.model.Piece.Color;

public class BoardTests {

	@Test
	public void boardIsNotNull() {
		Board board = new Board(8, 8);
		assertNotNull(board);
	}

	@Test
	public void checkForPositionsOfWhitePawns() {
		Board board = new Board(8, 8);
		board.InitializeBoard(); // assertTrue(Piece.Color.BLACK);

	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenRowcountAndColumnCount()
			throws Exception {
		new Board(0, 0);
	}

	@Test
	public void PieceIsNotNull() {
		Piece mPiece = new Piece(Color.BLACK);
		assertNotNull(mPiece);
	}

	@Test
	public void boardPaintedBlackAtPos01() {
		Board b = new Board(8, 8);
		assertTrue(b.isPositionPainted(2, 1));
	}

	@Test
	public void boardPaintedBlackAtPos00() {
		Board b = new Board(8, 8);
		assertFalse(b.isPositionPainted(0, 0));
	}

}
