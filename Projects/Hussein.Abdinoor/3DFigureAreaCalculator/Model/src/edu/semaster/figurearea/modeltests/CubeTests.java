package edu.semaster.figurearea.modeltests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.Test;

import edu.semaster.figurearea.model.Cube;

public class CubeTests
{
	private final double DELTA = 0.0001;
	@Test
	public void cubeIsNotNull()
	{
		 Cube m_cube = new Cube(10);
			assertNotNull(m_cube);
	}

	@Test
	public void canSetFaceLengthOfCube()
	{
		Cube m_cube = new Cube(10);
		Assert.assertNotNull(m_cube);
		assertEquals(10, m_cube.getFaceLength(), DELTA);
	}

	@Test
	public void canCalculateAreaOfCubeWithFaceLenghtequalsTo10()
	{
		Cube m_cube = new Cube(10);
		double actual = m_cube.calculateArea();
		double expected = 600;
		assertTrue("Checking Whether face length is greater than zero",
				m_cube.getFaceLength() >= 0);
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
