package src.surfaceareatests;

import static org.junit.Assert.*;

import src.surfaceareacalculator.Torus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TorusTests
{
	private Torus torus;
	private final double DELTA = 0.0001;

	@Before
	public void setUp()
	{
		torus = new Torus(3.0, 10.0);
	}

	@After
	public void tearDown()
	{
		torus = null;
	}

	@Test
	public void canCreateATorus()
	{
		assertNotNull(torus);
	}

	@Test
	public void canSetTubeRadiusAndMajorRadius()
	{
		assertNotNull(torus);
	}

	@Test
	public void canSetTubeRadiusOfTorus()
	{
		assertEquals(3, torus.getMinorRadius(), DELTA);
	}

	@Test
	public void canSetDistanceFromTorusCenterToTubeCenterOfTorus()
	{
		assertEquals(10, torus.getmajorRadius(), DELTA);
	}

	@Test
	public void canCalculateAreaOfTorusGivenMinorRadiusEquals3pointZeroAndmajortEquals10pointZero()
	{
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

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenMinorRadiusIsGreaterThanMajorRadius()
			throws Exception
	{
		new Torus(30, 20);

	}
}
