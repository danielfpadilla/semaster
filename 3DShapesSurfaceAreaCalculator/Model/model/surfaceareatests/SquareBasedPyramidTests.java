package model.surfaceareatests;

import static org.junit.Assert.*;

import model.surfaceareacalculator.SquareBasedPyramid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SquareBasedPyramidTests
{
	private SquareBasedPyramid sqPyramid;
	private final double DELTA = 0.0001;

	@Before
	public void setUp()
	{
		sqPyramid = new SquareBasedPyramid(6.0, 4.0);
	}

	@After
	public void tearDown()
	{
		sqPyramid = null;
	}

	@Test
	public void squareBasedPyramidIsNotNull()
	{
		assertNotNull(sqPyramid);
	}

	@Test
	public void canCreateASquareBasedPyramid()
	{
		assertNotNull(sqPyramid);
	}

	@Test
	public void canSetBaseLengthAndHeightOfASquareBasedPyramid()
	{
		assertNotNull(sqPyramid);
	}

	@Test
	public void canSetBaseLengthOfSquareBasedPyramid()
	{
		double actual = sqPyramid.getBaselength();
		assertEquals(6, actual, DELTA);
	}

	@Test
	public void canSetHeightOfSquareBasedPyramid()
	{
		double actual = sqPyramid.getHeight();
		assertEquals(4, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfSquarePyramidGivenRadiusEquals10pointZeroAndHeightEquals4pointZero()
	{
		double actual = sqPyramid.calculateArea();
		double expected = 96.0;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfSquarePyramidGivenRadiusEquals23point44AndHeightEquals54point88()
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