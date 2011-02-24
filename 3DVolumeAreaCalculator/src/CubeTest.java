import org.junit.Test;
import junit.framework.Assert;
import junit.framework.TestCase;

public class CubeTest 
{
	int edge = 4;
	@Test public void CanCreateCube()
	{
		Cube cube = new Cube();
		Assert.assertNotNull(cube);
	}
	
	@Test public void CanInitializeCube()
	{
		Cube cube = new Cube(edge);
		Assert.assertNotNull(cube);
	}
	
	@Test public void CanGetCubeEdge()
	{
		Cube cube = new Cube(edge);
		Assert.assertEquals(edge, cube.GetEdge());
	}
	
	@Test public void CanSetCubeEdge()
	{
		Cube cube = new Cube();
		cube.SetEdge(edge);
		Assert.assertEquals(edge, cube.GetEdge());
	}
	@Test public void CanCalculateCubeVolume()
	{
		Cube cube = new Cube(edge);
		Assert.assertEquals(64, cube.CalculateVolume());
		
	}
}
