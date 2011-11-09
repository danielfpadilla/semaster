package edu.semaster.checkers.modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.semaster.checkers.model.Move;

public class MoveTests {

	@Test
	public void moveIsNotNull() {
		Move move = new Move(1,7);
		assertNotNull(move);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenSourceAndTargetIsLessThanZero()
			throws Exception {
		new Move(-2, -1);
	}
	@Test
	public void getSourceOfMove()
	{
		Move move = new Move(5 , 11);
		assertEquals(5, move.getSource());
		
	}
	@Test
	public void getTargetOfMove()
	{
		Move move = new Move(5 , 11);
		assertEquals(11, move.getTarget());
	}
	@Test
	
	public void testToStringMethod()
	{
		Move move = new Move(6, 9);
		String movePath = "edu.semaster.checkers.model.Move(6->9)";
		assertEquals(movePath, move.toString());
	}
	@Test
	public void testLengthOfPathSequence()
	{
		Move [] listMoves = {new Move(3, 4), new Move(5, 7), new Move(4, 8), new Move(10, 48)};
		assertEquals(4, Move.pathLength(listMoves) );
	}
	
	
}