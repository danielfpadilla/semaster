package edu.semaster.figurearea.modeltests;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.semaster.figurearea.model.Cylinder;

public class CylinderTests
{
	private final double DELTA = 0.0001;

	@Test
	public void canCreateAcylinder()
	{
		Cylinder cylinder = new Cylinder(7, 10);
		assertNotNull(cylinder);
	}

	@Test
	public void canSetRadiusAndHeightOfcylinder()
	{
		Cylinder cylinder = new Cylinder(7, 10);
		assertNotNull(cylinder);
	}

	@Test
	public void canSetRadiusofcylinder()
	{
		Cylinder cylinder = new Cylinder(7, 10);
		assertEquals(7, cylinder.getRadius(), DELTA);

	}

	@Test
	public void canSetheightOfcylinder()
	{
		Cylinder cylinder = new Cylinder(7, 10);
		assertEquals(10, cylinder.getHeight(), DELTA);
	}

	@Test
	public void canCalculateAreaOfCylinderSevenByTen()
	{
		Cylinder cylinder = new Cylinder(7, 10);
		double actual = cylinder.calculateArea();
		double expected = 747.6990;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void calculateAreaOfcylinderWithDecimalValues()
	{

		Cylinder cylinder = new Cylinder(50.75, 70.35);
		double actual = cylinder.calculateArea();
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
