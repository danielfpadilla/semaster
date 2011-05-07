package edu.semaster.figurearea.modeltests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.semaster.figurearea.model.Cone;

public class ConeTests
{
	private final double DELTA = 0.00001;

	@Test
	public void coneIsNotNull()
	{
		Cone cone = new Cone(3.0, 4.0);
		assertNotNull(cone);
	}

	@Test
	public void canSetRadiusAndHeightOfCone()
	{
		Cone cone = new Cone(3.0, 4.0);
		assertNotNull(cone);
	}

	@Test
	public void canSetRadiusOfCone()
	{
		Cone cone = new Cone(3.0, 4.0);
		assertEquals(3, cone.getRadius(), DELTA);
	}

	@Test
	public void canSetHeightOfCone()
	{
		Cone cone = new Cone(3.0, 4.0);
		assertEquals(4, cone.getHeight(), DELTA);
	}

	@Test
	public void canCalculateAreaOfConeGivenRadiusEqualsThreeByFour()
	{
		Cone cone = new Cone(3.0, 4.0);
		double actual = cone.calculateArea();
		double expected = 75.398223;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfConeGivenRadiusWithDecimals()
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
