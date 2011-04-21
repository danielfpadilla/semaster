package figurearea.modeltests;

import static org.junit.Assert.*;

import org.junit.Test;

import figurearea.model.Cone;

public class ConeTests
{
	private final double DELTA = 0.00001;

	@Test
	public void coneIsNotNull()
	{
		Cone m_cone = new Cone(3.0, 4.0);
		assertNotNull(m_cone);
	}

	@Test
	public void canSetRadiusAndHeightOfCone()
	{
		Cone m_cone = new Cone(3.0, 4.0);
		assertNotNull(m_cone);
	}

	@Test
	public void canSetRadiusOfCone()
	{
		Cone m_cone = new Cone(3.0, 4.0);
		assertEquals(3, m_cone.getRadius(), DELTA);
	}

	@Test
	public void canSetHeightOfCone()
	{
		Cone m_cone = new Cone(3.0, 4.0);
		assertEquals(4, m_cone.getHeight(), DELTA);
	}

	@Test
	public void canCalculateAreaOfConeGivenRadiusEqualsThreeByFour()
	{
		Cone m_cone = new Cone(3.0, 4.0);
		double actual = m_cone.calculateArea();
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
