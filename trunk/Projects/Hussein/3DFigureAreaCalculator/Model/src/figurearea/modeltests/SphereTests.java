package figurearea.modeltests;
import static org.junit.Assert.*;
import org.junit.Test;

import figurearea.model.Sphere;

public class SphereTests
{
	private final double DELTA = 0.0001;

	@Test
	public void canCreateASphere()
	{
		Sphere m_sphere = new Sphere(10);
		assertNotNull(m_sphere);
	}

	@Test
	public void canSetRadiusOfASphere()
	{
		Sphere m_sphere = new Sphere(10);
		assertEquals(10.0, m_sphere.getRadius(), DELTA);
	}

	@Test
	public void canCalculateAreaOfSphereGivenRadiusEquals10()
	{
		Sphere m_sphere = new Sphere(10.0);
		double actual = m_sphere.calculateArea();
		double expected = 1256.6371;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfSphereGivenRadiusEquals43pointEightFive()
	{
		Sphere m_sphere = new Sphere(43.85);
		double actual = m_sphere.calculateArea();
		double expected = 24162.9001;
		assertEquals(expected, actual, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
			throws Exception
	{
		new Sphere(-10);

	}
}
