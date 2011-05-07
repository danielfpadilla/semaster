package edu.semaster.figurearea.modeltests;
import static org.junit.Assert.*;
import org.junit.Test;

import edu.semaster.figurearea.model.Sphere;

public class SphereTests
{
	private final double DELTA = 0.0001;

	@Test
	public void canCreateASphere()
	{
		Sphere sphere = new Sphere(10);
		assertNotNull(sphere);
	}

	@Test
	public void canSetRadiusOfASphere()
	{
		Sphere sphere = new Sphere(10);
		assertEquals(10.0, sphere.getRadius(), DELTA);
	}

	@Test
	public void canCalculateAreaOfSphereGivenRadiusEquals10()
	{
		Sphere sphere = new Sphere(10.0);
		double actual = sphere.calculateArea();
		double expected = 1256.6371;
		assertEquals(expected, actual, DELTA);
	}

	@Test
	public void canCalculateAreaOfSphereGivenRadiusEquals43pointEightFive()
	{
		Sphere sphere = new Sphere(43.85);
		double actual = sphere.calculateArea();
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
