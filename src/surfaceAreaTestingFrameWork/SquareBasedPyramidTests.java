package surfaceAreaTestingFrameWork;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import surfaceAreaCalculator.SquareBasedPyramid;

public class SquareBasedPyramidTests {
	SquareBasedPyramid sqPyramid;
	private final double delta = 0.0001;

	@Before
	public void setUp() {
		sqPyramid = new SquareBasedPyramid(6.0, 4.0);
	}

	@After
	public void tearDown() {
		sqPyramid = null;
	}

	@Test
	public void SquareBasedPyramidIsNotNull() {
		assertNotNull(sqPyramid);
	}

	@Test
	public void canCreateASquareBasedPyramid() {
		assertNotNull(sqPyramid);
	}

	@Test
	public void canSetBaseLengthAndHeightOfASquareBasedPyramid() {
		assertNotNull(sqPyramid);
	}

	@Test
	public void canSetBaseLengthOfSquareBasedPyramid() {
		double actual = sqPyramid.getBaselength();
		assertEquals(6, actual, delta);
	}

	@Test
	public void canSetHeightOfSquareBasedPyramid() {
		double actual = sqPyramid.getHeight();
		assertEquals(4, actual, delta);
	}

	@Test
	public void CanCalculateAreaOfSquarePyramidGivenRadiusEquals10pointZeroAndHeightEquals4pointZero() {
		double actual = sqPyramid.calculateArea();
		double expected = 96.0;
		assertEquals(expected, actual, delta);
	}

	@Test
	public void CanCalculateAreaOfSquarePyramidGivenRadiusEquals23point44AndHeightEquals54point88() {
		SquareBasedPyramid sqPyramid = new SquareBasedPyramid(23.44, 54.88);
		double actual = sqPyramid.calculateArea();
		double expected = 3180.2215;
		assertEquals(expected, actual, delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
			throws Exception {
		new SquareBasedPyramid(-23, 54);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CheckWhetherAnExceptionIsThrownWhenHeightIsLessThanOrEqualToZero()
			throws Exception {
		new SquareBasedPyramid(23, -54);
	}

}