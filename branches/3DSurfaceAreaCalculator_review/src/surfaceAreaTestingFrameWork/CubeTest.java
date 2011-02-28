package surfaceAreaTestingFrameWork;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import surfaceAreaCalculator.Cube;


public class CubeTest {
	Cube cube = new Cube(10);
	private final double delta = 0.0001;
	@Test public void CubeIsNotNull()
	{
		assertNotNull(cube);
	}
	@Test public void CanSetFaceLengthOfCube()
	{
		Assert.assertNotNull(cube);
		assertEquals(10, cube.getFaceLength(), delta);
	}
	@Test public void CanCalculateAreaOfCubeWithFaceLenghtequalsTo10()
	{
		double actual = cube.calculateArea();
		double expected  = 600;
		assertTrue("Checking Whether face length is greater than zero",
				cube.getFaceLength() >= 0);
		assertEquals(expected, actual, delta);
	}
	@Test public void CanCalculateAreaOfCubeWithFaceLenghtequalsTo78point89()
	{
		Cube cube = new Cube(78.89);
		double actual = cube.calculateArea();
		double expected  = 37341.7926;
		assertTrue("Checking Whether face length is greater than zero",
				cube.getFaceLength() >= 0);
		assertEquals(expected, actual, delta);
	}
	  @Test public void CheckWhetherAnExceptionIsThrownWhenFaceLengthIsLessThanOrEqualToZero()
	  throws Exception
	  {
		  try
		  {
			  new Cube(-10);
			  fail("Negative faceLength");
			  
		  }
		  catch (IllegalArgumentException expected)
		  {}
	  }
	}


