package surfaceAreaTestingFrameWork;

import static org.junit.Assert.*;
import surfaceAreaCalculator.Cone;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class ConeTest {
	private double delta = 0.00001;
	private Cone cone;

	@Before
	public void setUp() {
		cone = new Cone(3.0, 4.0);
	}

	@After
	public void tearDown() {
		cone = null;

	}

	@Test
	public void ConeIsNotNull() {
		assertNotNull(cone);
	}

	@Test
	public void CanSetRadiusAndHeightOfCone() {
		assertNotNull(cone);
	}

	@Test
	public void CanSetRadiusOfCone() {
		assertEquals(3, cone.getRadius(), delta);
	}

	@Test
	public void CanSetHeightOfCone() {
		assertEquals(4, cone.getHeight(), delta);
	}

	@Test
	public void CanCalculateAreaOfConeGivenRadiusEquals3pointZeroAndHeightEquals4pointZero() {
		double actual = cone.calculateArea();
		double expected = 75.398223;
		assertEquals(expected, actual, delta);
	}

	@Test
	public void CanCalculateAreaOfConeGivenRadiusEquals10point85AndHeightEquals45point897() {
		Cone cone = new Cone(10.85, 45.897);
		double actual = cone.calculateArea();
		double expected = 1977.41433;
		assertEquals(expected, actual, delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
			throws Exception {
		new Cone(-10, 19);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CheckWhetherAnExceptionIsThrownWhenHeightIsLessThanOrEqualToZero()
			throws Exception {
		new Cone(10, -19);
	}
}
