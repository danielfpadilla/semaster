package figurearea.modeltests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import figurearea.model.Cube;

public class CubeTests
{
	private Cube cube;
	private final double DELTA = 0.0001;

	@Before
	public void setUp()
	{
		cube = new Cube(10);
	}

	@After
	public void tearDown()
	{
		cube = null;
	}

	@Test
	public void canCreateCube()
	{
		assertNotNull(cube);
	}

	@Test
	public void cubeIsNotNull()
	{
		assertNotNull(cube);
	}

	@Test
	public void canSetFaceLengthOfCube()
	{
		Assert.assertNotNull(cube);
		assertEquals(10, cube.getFaceLength(), DELTA);
	}

	@Test
	public void canCalculateAreaOfCubeWithFaceLenghtequalsTo10()
	{
		double actual = cube.calculateArea();
		double expected = 600;
		assertTrue("Checking Whether face length is greater than zero",
				cube.getFaceLength() >= 0);
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfCubeWithDecimalValueFaceLength()
	{
		Cube cube = new Cube(78.89);
		double actual = cube.calculateArea();
		double expected = 37341.7926;
		assertTrue("Checking Whether face length is greater than zero",
				cube.getFaceLength() >= 0);
		assertEquals(expected, actual, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenFaceLengthIsLessThanOrEqualToZero()
			throws Exception
	{
		new Cube(-10);

	}

}
