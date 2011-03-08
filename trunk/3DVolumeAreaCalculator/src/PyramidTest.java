import org.junit.Test;
import junit.framework.Assert;

public class PyramidTest 
{
	int edge = 3; //length of edge in pyramid's base
	int NumberOfEdge = 7; //number of edge in pyramid's base
	int height = 5;
	int NegativeEdge = -3;
	int NegativeNumberOfEdge = 2;// It cannot be less than 3
	int DefaultNumberOfEdge = 3;
	int NegativeHeight = -5;
	int ZeroHeight = 0;
	int ZeroEdge = 0;
	double BaseSquare = (NumberOfEdge/4) * Math.pow(edge, 2) * (1/Math.tan(Math.PI/NumberOfEdge));
	double DefaultBaseSquare = (DefaultNumberOfEdge/4) * Math.pow(edge, 2) * (1/Math.tan(Math.PI/DefaultNumberOfEdge));
	double volume = height * BaseSquare / 3;
	double DefaultVolume = height * DefaultBaseSquare / 3;
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
	@Test public void CanCalculatePyramidVolume()
	{
		Pyramid pyramid = new Pyramid(edge, NumberOfEdge, height);
		Assert.assertEquals(volume, pyramid.CalculateVolume(), delta);
	}
	@Test (expected = ParameterValueException.class)
	public void CanCheckExceptionWithNegativeHeight() throws ParameterValueException
	{
		Pyramid pyramid = new Pyramid(edge, NumberOfEdge, NegativeHeight);
		pyramid.ValidateHeight();
	}
	@Test (expected = ParameterValueException.class)
	public void CanCheckExceptionWithNegativeEdge() throws ParameterValueException
	{
		Pyramid pyramid = new Pyramid(NegativeEdge, NumberOfEdge, height);
		pyramid.ValidateEdge();
	}
	@Test (expected = ParameterValueException.class)
	public void CanCheckExceptionWithNegativeNumberOfEdge() throws ParameterValueException
	{
		Pyramid pyramid = new Pyramid(edge, NegativeNumberOfEdge, height);
		pyramid.ValidateNumberOfEdge();
	}
	@Test public void CanCaclulateVolumeWithNegativeHeight()
	{
		Pyramid pyramid = new Pyramid(edge, NumberOfEdge, NegativeHeight);
		Assert.assertEquals(volume, pyramid.CalculateVolume(), delta);
	}
	@Test public void CanCaclulateVolumeWithZeroHeight()
	{
		Pyramid pyramid = new Pyramid(edge, NumberOfEdge, ZeroHeight);
		Assert.assertEquals(volume, pyramid.CalculateVolume(), delta);
	}
	@Test public void CanCaclulateVolumeWithNegativeEdge()
	{
		Pyramid pyramid = new Pyramid(NegativeEdge, NumberOfEdge, height);
		Assert.assertEquals(volume, pyramid.CalculateVolume(), delta);
	}
	@Test public void CanCaclulateVolumeWithZeroEdge()
	{
		Pyramid pyramid = new Pyramid(ZeroEdge, NumberOfEdge, height);
		Assert.assertEquals(volume, pyramid.CalculateVolume(), delta);
	}
	@Test public void CanCaclulateVolumeWithNegativeNumberOfEdge()
	{
		Pyramid pyramid = new Pyramid(edge, NegativeNumberOfEdge, height);
		Assert.assertEquals(DefaultVolume, pyramid.CalculateVolume(), delta);
	}
}
