package surfaceAreaTestingFrameWork;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import surfaceAreaCalculator.Torus;

public class TorusTestCase {
	Torus torus;
	private final double delta = 0.0001;

	@Before
	public void setUp() {
		torus = new Torus(3.0, 10.0);
	}

	@After
	public void tearDown() {
		torus = null;
	}

	@Test
	public void canCreateATorus() {
		assertNotNull(torus);
	}

	@Test
	public void canSetTubeRadiusAndMajorRadius() {
		assertNotNull(torus);
	}

	@Test
	public void CanSetTubeRadiusOfTorus() {
		assertEquals(3, torus.getMinorRadius(), delta);
	}

	@Test
	public void CanSetDistanceFromTorusCenterToTubeCenterOfTorus() {
		assertEquals(10, torus.getmajorRadius(), delta);
	}

	@Test
	public void CanCalculateAreaOfTorusGivenMinorRadiusEquals3pointZeroAndmajortEquals10pointZero() {
		double actual = torus.calculateArea();
		double expected = 1184.3525;
		assertEquals(expected, actual, delta);
	}

	@Test
	public void CanCalculateAreaOfTorusGivenMinorRadiusEquals23point84AndmajortEquals120point66() {
		Torus torus = new Torus(23.84, 120.66);
		double actual = torus.calculateArea();
		double expected = 113561.0263;
		assertEquals(expected, actual, delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CheckWhetherAnExceptionIsThrownWhenMinorRadiusIsLessThanOrEqualToZero()
			throws Exception {
		new Torus(-10, 19);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CheckWhetherAnExceptionIsThrownWhenMajorRadiusIsLessThanOrEqualToZero()
			throws Exception {
		new Torus(10, -19);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CheckWhetherAnExceptionIsThrownWhenMinorRadiusIsGreaterThanMajorRadius()
			throws Exception {
		new Torus(30, 20);

	}
}
