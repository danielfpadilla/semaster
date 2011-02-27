package surfaceAreaTestingFrameWork;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import surfaceAreaCalculator.SquareBasedPyramid;

public class SquareBasedPyramidTests {
	SquareBasedPyramid sqPyramid = new SquareBasedPyramid(6.0, 4.0);
	private final double delta = 0.0001;
@Test public void canCreateASquareBasedPyramid()
   {
	  assertNotNull(sqPyramid);
    }
@Test public void canSetBaseLengthAndHeightOfASquareBasedPyramid()
{
	 assertNotNull(sqPyramid);
}
@Test public void canSetBaseLengthOfSquareBasedPyramid()
{
	double actual = sqPyramid.getBaselength();
	assertEquals(6, actual, delta);
}
@Test public void canSetHeightOfSquareBasedPyramid()
{
	double actual = sqPyramid.getHeight();
	assertEquals(4, actual, delta);
}
@Test public void AreTwoSquareBasedPyramidsEqual()
{
	SquareBasedPyramid sqPyramid1 = new SquareBasedPyramid(10, 17);
	SquareBasedPyramid sqPyramid2  = new SquareBasedPyramid(10, 17);
	Assert.assertEquals(sqPyramid1, sqPyramid2);
}
@Test
public void AreTwoSquareBasedPyramidsNotEqual()
{
	SquareBasedPyramid sqPyramid1 = new SquareBasedPyramid(10, 17);
	SquareBasedPyramid sqPyramid2  = new SquareBasedPyramid(20, 17);
	assertTrue(!sqPyramid1.equals(sqPyramid2));
}
@Test public void CanCalculateAreaOfSquarePyramidGivenRadiusEquals10pointZeroAndHeightEquals4pointZero()
{
	double actual = sqPyramid.calculateArea();
	double expected = 96.0;
    assertEquals(expected, actual, delta);
}

@Test public void CanCalculateAreaOfSquarePyramidGivenRadiusEquals23point44AndHeightEquals54point88()
{
	SquareBasedPyramid sqPyramid = new SquareBasedPyramid(23.44, 54.88);
	double actual = sqPyramid.calculateArea();
	double expected = 3180.2215;
    assertEquals(expected, actual, delta);
}
@Test  public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
throws Exception
{
	  try
	  {
		  SquareBasedPyramid sqPyramid = new SquareBasedPyramid(-23, 54);
		  fail("Negative radius");
	  }
	  catch (IllegalArgumentException expected)
	  {}
}

@Test  public void CheckWhetherAnExceptionIsThrownWhenHeightIsLessThanOrEqualToZero()
throws Exception
{
	  try
	  {
		  SquareBasedPyramid sqPyramid = new SquareBasedPyramid(23, -54);
		  fail("Negative height");
	  }
	  catch (IllegalArgumentException expected)
	  {}
}

}