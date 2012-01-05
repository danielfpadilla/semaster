package edu.semaster.checkers.modelTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.semaster.checkers.model.Move;
import edu.semaster.checkers.model.Walk;

public class MoveTests {

	@Test
	public void moveIsNotNull() {
		Move move = new Move(1, 2, 4, 5);
		assertNotNull(move);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenSourceAndTargetIsLessThanZero()
			throws Exception {
		new Move(-2, -1, -4, -5);
	}

	@Test
	public void getSourceOfMove() {
		Move move = new Move(0, 2, 6, 7);
		assertEquals(0, move.getSourceX());
		assertEquals(2, move.getSourceY());

	}

	@Test
	public void getTargetOfMove() {
		Move move = new Move(2, 4, 3, 5);
		assertEquals(3, move.getTargetX());
		assertEquals(5, move.getTargetY());
	}

	@Test
	public void testToStringMethod() {
		Move move = new Move(2, 4, 3, 5);
		String movePath = "edu.semaster.checkers.model.Move(2,4)->(3,5)";
		assertEquals(movePath, move.toString());
	}

	@Test
	public void testLengthOfPathSequence() {
		Move[] listMoves = { new Move(3, 4, 0, 2), new Move(5, 7, 1, 3),
				new Move(2, 5, 0, 1), new Move(0, 1, 4, 6) };
		assertEquals(4, Move.pathLength(listMoves));
	}

	@Test
	public void isItaValidWalk() {
		Walk walk = new Walk(5,2,4,3);
		assertTrue(walk.isAValidWalk(walk.getSourceX(), walk.getSourceY(),
				walk.getTargetX(), walk.getTargetY()));
	}
	
	@Test
	public void isItAnInvalidWalk() {
		Walk walk = new Walk(5,2,4,3);
		assertTrue(walk.isAValidWalk(walk.getSourceX(), walk.getSourceY(),
				walk.getTargetX(), walk.getTargetY()));
	}
	
	

}