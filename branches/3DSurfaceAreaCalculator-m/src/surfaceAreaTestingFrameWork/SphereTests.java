package surfaceAreaTestingFrameWork;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import surfaceAreaCalculator.Sphere;

public class SphereTests {
	Sphere sphere;
	private final double delta = 0.0001;

	@Before
	public void setUp() {
		sphere = new Sphere(10);
	}

	@After
	public void tearDown() {
		sphere = null;
	}

	@Test
	public void canCreateASphere() {
		assertNotNull(sphere);
	}

	@Test
	public void canSetRadiusOfASphere() {
		assertEquals(10.0, sphere.getRadius(), delta);
	}

	@Test
	public void CanCalculateAreaOfSphereGivenRadiusEquals10() {
		Sphere sphere = new Sphere(10.0);
		double actual = sphere.calculateArea();
		double expected = 1256.6371;
		assertEquals(expected, actual, delta);
	}

	@Test
	public void CanCalculateAreaOfSphereGivenRadiusEquals43pointEightFive() {
		Sphere sphere = new Sphere(43.85);
		double actual = sphere.calculateArea();
		double expected = 24162.9001;
		assertEquals(expected, actual, delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
			throws Exception {
		new Sphere(-10);

	}
}
