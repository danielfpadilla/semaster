package edu.semaster.checkers.modelTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.semaster.checkers.baseproject.*;
import edu.semaster.checkers.baseproject.FigureType.Type;
import edu.semaster.checkers.model.Board;





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
	public void PieceIsNotNull()
	{
		FigureType mFigure = new FigureType (Type.BLACK);
		assertNotNull(mFigure);
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
