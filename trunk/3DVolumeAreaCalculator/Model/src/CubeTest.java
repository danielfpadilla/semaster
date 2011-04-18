import org.junit.Test;
import junit.framework.Assert;
//import junit.framework.TestCase;

public class CubeTest 
{
	int edge = 4;
	int NegativeEdge = -4;
	int ZeroEdge = 0;
	double volume = Math.pow(edge, 3);
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
		Assert.assertEquals(volume, cube.CalculateVolume());
		
	}
	@Test(expected = ParameterValueException.class)
	public void CanCheckExceptionWithNegativeEdge() throws ParameterValueException
	{
		Cube cube = new Cube(NegativeEdge);
		cube.ValidateEdge();
	}
	@Test public void CanCalculateVolumeWithNegativeEdge()
	{
		Cube cube = new Cube(NegativeEdge);
		Assert.assertEquals(volume, cube.CalculateVolume());
	}
	@Test public void CanCalculateVolumeWithZeroEdge()
	{
		Cube cube = new Cube(ZeroEdge);
		Assert.assertEquals(volume, cube.CalculateVolume());
	}
}
