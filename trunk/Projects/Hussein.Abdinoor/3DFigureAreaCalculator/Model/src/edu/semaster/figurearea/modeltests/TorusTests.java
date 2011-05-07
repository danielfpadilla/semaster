package edu.semaster.figurearea.modeltests;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.semaster.figurearea.model.Torus;

public class TorusTests
{
	private final double DELTA = 0.0001;

	@Test
	public void canCreateATorus()
	{
		Torus torus = new Torus(3.0, 10.0);
		assertNotNull(torus);
	}

	@Test
	public void canSetTubeRadiusAndMajorRadius()
	{
		Torus torus = new Torus(3.0, 10.0);
		assertNotNull(torus);
	}

	@Test
	public void canSetTubeRadiusOfTorus()
	{
		Torus torus = new Torus(3.0, 10.0);
		assertEquals(3, torus.getMinorRadius(), DELTA);
	}

	@Test
	public void canSetDistanceFromTorusCenterToTubeCenterOfTorus()
	{
		Torus torus = new Torus(3.0, 10.0);
		assertEquals(10, torus.getmajorRadius(), DELTA);
	}

	@Test
	public void canCalculateAreaOfTorusGivenMinorRadiusThreeByTen()
	{
		Torus torus = new Torus(3.0, 10.0);
		double actual = torus.calculateArea();
		double expected = 1184.3525;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfTorusGivenMinorRadiusEquals23point84AndmajorRadiusEquals120point66()
	{
		Torus torus = new Torus(23.84, 120.66);
		double actual = torus.calculateArea();
		double expected = 113561.0263;
		assertEquals(expected, actual, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenMinorRadiusIsLessThanOrEqualToZero()
			throws Exception
	{
		new Torus(-10, 19);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenMajorRadiusIsLessThanOrEqualToZero()
			throws Exception
	{
		new Torus(10, -19);
	}

	@Test(expected = ArithmeticException.class)
	public void checkWhetherAnExceptionIsThrownWhenMinorRadiusIsGreaterThanMajorRadius()
			throws Exception
	{
		new Torus(30, 20);

	}
}
