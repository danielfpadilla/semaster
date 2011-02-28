package surfaceAreaTestingFrameWork;

import static org.junit.Assert.*;

import org.junit.Test;
import surfaceAreaCalculator.Torus;

public class TorusTestCase {
	Torus torus= new Torus(3.0, 10.0);
	private final double  delta = 0.0001;
	@Test public void canCreateATorus()
	{
		assertNotNull(torus);
	}
	@Test public void canSetTubeRadiusAndMajorRadius()
	{
		assertNotNull(torus);
	}
	@Test public void CanSetTubeRadiusOfTorus()
	{
		assertEquals(3, torus.getMinorRadius(), delta);
	}
    @Test public void CanSetDistanceFromTorusCenterToTubeCenterOfTorus()
    {
	   assertEquals(10, torus.getmajorRadius(), delta);
    }
    @Test public void CanCalculateAreaOfTorusGivenMinorRadiusEquals3pointZeroAndmajortEquals10pointZero()
    {
    	double actual = torus.calculateArea();
    	double expected = 1184.3525;
    	assertEquals(expected, actual, delta);
    }
    @Test  public void CanCalculateAreaOfTorusGivenMinorRadiusEquals23point84AndmajortEquals120point66()
    {
    	Torus torus= new Torus(23.84, 120.66);
    	double actual = torus.calculateArea();
    	double expected = 113561.0263;
    	assertEquals(expected, actual, delta);
    }
    @Test  public void CheckWhetherAnExceptionIsThrownWhenMinorRadiusIsLessThanOrEqualToZero()
    throws Exception
    {
   	  try
   	  {
   		  new Torus(-10, 19);
   		  fail("Negative minor radius");
   	  }
   	  catch (IllegalArgumentException expected)
   	  {}
    }
    @Test  public void CheckWhetherAnExceptionIsThrownWhenMajorRadiusIsLessThanOrEqualToZero()
    throws Exception
    {
   	  try
   	  {
   		  new Torus(10, -19);
   		  fail("Negative major radius");
   	  }
   	  catch (IllegalArgumentException expected)
   	  {}
    }
    
    @Test  public void CheckWhetherAnExceptionIsThrownWhenMinorRadiusIsGreaterThanMajorRadius()
    throws Exception
    {
   	  try
   	  {
   		  new Torus(30, 20);
   		  fail("Minor radius greater than major radius");
   	  }
   	  catch (IllegalArgumentException expected)
   	  {}
    }
}
