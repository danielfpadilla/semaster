package figures.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CylinderTests
{
	private final double DELTA = 0.0001;

	@Test
	public void canCreateAm_cylinder()
	{
		Cylinder m_cylinder = new Cylinder(7, 10);
		assertNotNull(m_cylinder);
	}

	@Test
	public void canSetRadiusAndHeightOfm_cylinder()
	{
		Cylinder m_cylinder = new Cylinder(7, 10);
		assertNotNull(m_cylinder);
	}

	@Test
	public void canSetRadiusofm_cylinder()
	{
		Cylinder m_cylinder = new Cylinder(7, 10);
		assertEquals(7, m_cylinder.getRadius(), DELTA);

	}

	@Test
	public void canSetheightOfm_cylinder()
	{
		Cylinder m_cylinder = new Cylinder(7, 10);
		assertEquals(10, m_cylinder.getHeight(), DELTA);
	}

	@Test
	public void canCalculateAreaOfCylinderSevenByTen()
	{
		Cylinder m_cylinder = new Cylinder(7, 10);
		double actual = m_cylinder.calculateArea();
		double expected = 747.6990;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void calculateAreaOfm_cylinderWithDecimalValues()
	{

		Cylinder m_cylinder = new Cylinder(50.75, 70.35);
		double actual = m_cylinder.calculateArea();
		double expected = 38615.357343;
		assertEquals(expected, actual, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
			throws Exception
	{
		new Cylinder(-10, 10);

	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenHeightIsLessThanOrEqualToZero()
			throws Exception
	{
		new Cylinder(10, -10);
	}

}
