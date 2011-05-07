package edu.semaster.figurearea.modeltests;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.semaster.figurearea.model.Cube;

public class CubeTests
{
	private final double DELTA = 0.0001;

	@Test
	public void cubeIsNotNull()
	{
		Cube cube = new Cube(10);
		assertNotNull(cube);
	}

	@Test
	public void canSetFaceLengthOfCube()
	{
		Cube cube = new Cube(10);
		assertEquals(10, cube.getFaceLength(), DELTA);
	}

	@Test
	public void canCalculateAreaOfCubeWithFaceLenghtequalsTo10()
	{
		Cube cube = new Cube(10);
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
