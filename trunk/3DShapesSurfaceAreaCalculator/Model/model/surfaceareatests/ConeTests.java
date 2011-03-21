package model.surfaceareatests;

import static org.junit.Assert.*;
import model.surfaceareacalculator.Cone;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class ConeTests
{
	private Cone cone;
	private final double DELTA = 0.00001;

	@Before
	public void setUp()
	{
		cone = new Cone(3.0, 4.0);
	}

	@After
	public void tearDown()
	{
		cone = null;
	}

	@Test
	public void coneIsNotNull()
	{
		assertNotNull(cone);
	}

	@Test
	public void canSetRadiusAndHeightOfCone()
	{
		assertNotNull(cone);
	}

	@Test
	public void canSetRadiusOfCone()
	{
		assertEquals(3, cone.getRadius(), DELTA);
	}

	@Test
	public void canSetHeightOfCone()
	{
		assertEquals(4, cone.getHeight(), DELTA);
	}

	@Test
	public void canCalculateAreaOfConeGivenRadiusEquals3pointZeroAndHeightEquals4pointZero()
	{
		double actual = cone.calculateArea();
		double expected = 75.398223;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfConeGivenRadiusEquals10point85AndHeightEquals45point897()
	{
		Cone cone = new Cone(10.85, 45.897);
		double actual = cone.calculateArea();
		double expected = 1977.41433;
		assertEquals(expected, actual, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
			throws Exception
	{
		new Cone(-10, 19);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenHeightIsLessThanOrEqualToZero()
			throws Exception
	{
		new Cone(10, -19);
	}
}
