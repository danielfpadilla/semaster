package edu.semaster.figurearea.modeltests;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.semaster.figurearea.model.SquareBasedPyramid;

public class SquareBasedPyramidTests
{
	private final double DELTA = 0.0001;

	@Test
	public void squareBasedPyramidIsNotNull()
	{
		SquareBasedPyramid sqPyramid = new SquareBasedPyramid(6.0, 4.0);
		assertNotNull(sqPyramid);
	}

	@Test
	public void canCreateASquareBasedPyramid()
	{
		SquareBasedPyramid sqPyramid = new SquareBasedPyramid(6.0, 4.0);
		assertNotNull(sqPyramid);
	}

	@Test
	public void canSetBaseLengthAndHeightOfASquareBasedPyramid()
	{
		SquareBasedPyramid sqPyramid = new SquareBasedPyramid(6.0, 4.0);
		assertNotNull(sqPyramid);
	}

	@Test
	public void canSetBaseLengthOfSquareBasedPyramid()
	{
		SquareBasedPyramid sqPyramid = new SquareBasedPyramid(6.0, 4.0);
		double actual = sqPyramid.getBaselength();
		assertEquals(6, actual, DELTA);
	}

	@Test
	public void canSetHeightOfSquareBasedPyramid()
	{
		SquareBasedPyramid sqPyramid = new SquareBasedPyramid(6.0, 4.0);
		double actual = sqPyramid.getHeight();
		assertEquals(4, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfSquarePyramidSixByFour()
	{
		SquareBasedPyramid sqPyramid = new SquareBasedPyramid(6.0, 4.0);
		double actual = sqPyramid.calculateArea();
		double expected = 96.0;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfSquarePyramidWithDecimals()
	{
		SquareBasedPyramid sqPyramid = new SquareBasedPyramid(23.44, 54.88);
		double actual = sqPyramid.calculateArea();
		double expected = 3180.2215;
		assertEquals(expected, actual, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
			throws Exception
	{
		new SquareBasedPyramid(-23, 54);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenHeightIsLessThanOrEqualToZero()
			throws Exception
	{
		new SquareBasedPyramid(23, -54);
	}

}