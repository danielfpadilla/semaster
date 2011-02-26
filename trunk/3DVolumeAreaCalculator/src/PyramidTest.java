import org.junit.Test;
import junit.framework.Assert;

public class PyramidTest 
{
	int edge = 3; //length of edge in pyramid's base
	int NumberOfEdge = 7; //number of edge in pyramid's base
	int height = 5;
	double BaseSquare = (NumberOfEdge/4) * Math.pow(edge, 2) * (1/Math.tan(Math.PI/NumberOfEdge));
	double volume = (1/3) * height * BaseSquare;
	double delta = 0.00002;
	@Test public void CanCreatePyramid()
	 {
		 Pyramid pyramid = new Pyramid();
		 Assert.assertNotNull(pyramid);
	 }
	@Test public void CanInitializePyramid()
	 {
		 Pyramid pyramid = new Pyramid(edge, NumberOfEdge, height);
		 Assert.assertNotNull(pyramid);
	 }
	@Test public void CanGetPyramidBaseEdge()
	{
		Pyramid pyramid = new Pyramid(edge, NumberOfEdge, height);
		Assert.assertEquals(edge, pyramid.GetEdge());
	}
	@Test public void CanGetPyramidHeight()
	{
		Pyramid pyramid = new Pyramid(edge, NumberOfEdge, height);
		Assert.assertEquals(height, pyramid.GetHeight());
	}
	@Test public void CanGetPyramidBaseNumberOfEdge()
	{
		Pyramid pyramid = new Pyramid(edge, NumberOfEdge, height);
		Assert.assertEquals(NumberOfEdge, pyramid.GetNumberOfEdge());
	}
	@Test public void CanSetPyramidBaseEdge()
	{
		Pyramid pyramid = new Pyramid();
		pyramid.SetEdge(edge);
		Assert.assertEquals(edge, pyramid.GetEdge());
	}
	@Test public void CanSetPyramidHeight()
	{
		Pyramid pyramid = new Pyramid();
		pyramid.SetHeight(height);
		Assert.assertEquals(height, pyramid.GetHeight());
	}
	@Test public void CanSetPyramidBaseNumberOfEdge()
	{
		Pyramid pyramid = new Pyramid();
		pyramid.SetNumberOfEdge(NumberOfEdge);
		Assert.assertEquals(NumberOfEdge, pyramid.GetNumberOfEdge());
	}
	@Test public void CanCalculatePyramidValue()
	{
		Pyramid pyramid = new Pyramid(edge, NumberOfEdge, height);
		Assert.assertEquals(volume, pyramid.CalculateVolume(), delta);
	}
}
