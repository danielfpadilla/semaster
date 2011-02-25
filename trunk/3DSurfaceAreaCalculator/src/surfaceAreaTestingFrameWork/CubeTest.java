package surfaceAreaTestingFrameWork;

import junit.framework.Assert;

import org.junit.Test;

import surfaceAreaCalculator.Cube;


public class CubeTest {
	private final double delta = 0.0001;
	@Test
	public void CubeIsNotNull()
	{
		Cube cube = new Cube();
		Assert.assertNotNull(cube);
	}
	@Test
	public void CanSetFaceLengthOfCube()
	{
		Cube cube = new Cube(10);
		Assert.assertNotNull(cube);
		Assert.assertEquals(10, cube.c_faceLength, delta);
	}
	@Test 
	public void AreTwoCubesEquals()
	{
		Cube cube1 = new Cube(10);
		Cube cube2 = new Cube(10);
		Assert.assertEquals(cube1,cube2);
	
		
	}
	@Test
	public void AreTwoCubesNotEqual()
	{
		Cube cube1 = new Cube(10);
		Cube cube2 = new Cube(20);
        Assert.assertTrue(!cube1.equals(cube2));
	}
	@Test
	public void CanCalculateAreaOfCubeWithFaceLenghtequalsTo10()
	{
		Cube cube = new Cube(10);
		double actual = cube.calculateArea();
		double expected  = 600;
		Assert.assertEquals(expected, actual, delta);
	}
	@Test
	public void CanCalculateAreaOfCubeWithFaceLenghtequalsTo78point89()
	{
		Cube cube = new Cube(78.89);
		double actual = cube.calculateArea();
		double expected  = 37341.7926;
		Assert.assertEquals(expected, actual, delta);
	}
	  @Test
	  public void CheckWhetherAnExceptionIsThrownWhenFaceLengthThanOrEqualToZero()throws Exception
	  {
		  //TODO
	  }

}
