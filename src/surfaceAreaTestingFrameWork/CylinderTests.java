package surfaceAreaTestingFrameWork;

import surfaceAreaCalculator.Cylinder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CylinderTests
{
	Cylinder cylinder;
	private final double DELTA = 0.0001;
	

	@Before
	public void setUp()
	{
		cylinder = new Cylinder(7, 10);
	}

	@After
	public void tearDown()
	{
		cylinder = null;
	}

	@Test
	public void canCreateACylinder()
	{
		assertNotNull(cylinder);
	}

	@Test
	public void canSetRadiusAndHeightOfCylinder()
	{
		assertNotNull(cylinder);
	}

	@Test
	public void canSetRadiusofCylinder()
	{
		assertEquals(7, cylinder.getRadius(), DELTA);

	}

	@Test
	public void canSetheightOfCylinder()
	{
		assertEquals(10, cylinder.getHeight(), DELTA);
	}

	@Test
	public void canCalculateAreaOfCylinderWithRadiusEqualsToSevenAndHeightEqualsToTen()
	{
		double actual = cylinder.calculateArea();
		double expected = 747.6990;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void calculateAreaOfCylinderWithRadiusEqualsTo50Point75AndHeightEqualsTo70Point35()
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
