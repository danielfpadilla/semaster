import org.junit.Test;
import junit.framework.Assert;

public class CylinderTest 
{
	int radius = 3;
	int NegativeRadius = -3;
	int ZeroRadius = 0;
	int height = 5;
	int NegativeHeight = -5;
	int ZeroHeight = 0;
	double volume = Math.PI * Math.pow(radius, 2) * height;
	double delta = 0.0002;
	@Test public void CanCreateCylinder()
	{
		Cylinder cylinder = new Cylinder();
		Assert.assertNotNull(cylinder);
	}
	@Test public void CanInitializeCylinder()
	{
		Cylinder cylinder = new Cylinder(radius, height);
		Assert.assertNotNull(cylinder);
	}
	@Test public void CanGetCylinderRadius()
	{
		Cylinder cylinder = new Cylinder(radius, height);
		Assert.assertEquals(radius, cylinder.GetRadius());
	}
	@Test public void CanGetCylinderHeight()
	{
		Cylinder cylinder = new Cylinder(radius, height);
		Assert.assertEquals(height, cylinder.GetHeight());
	}
	@Test public void CanSetCylinderRadius()
	{
		Cylinder cylinder = new Cylinder();
		cylinder.SetRadius(radius);
		Assert.assertEquals(radius, cylinder.GetRadius());
	}
	@Test public void CanSetCylinderHeight()
	{
		Cylinder cylinder = new Cylinder();
		cylinder.SetHeight(height);
		Assert.assertEquals(height, cylinder.GetHeight());
	}
	@Test public void CanCalculateCylinderVolume()
	{
		Cylinder cylinder = new Cylinder(radius, height);
		Assert.assertEquals(volume, cylinder.CalculateVolume(), delta);
	}
	@Test (expected = ParameterValueException.class)
	public void CanCheckExceptionWithNegativeRadius() throws ParameterValueException
	{
		Cylinder cylinder = new Cylinder(NegativeRadius, height);
		cylinder.ValidateRadius();
	}
	@Test (expected = ParameterValueException.class)
	public void CanCheckExceptionWithNegativeHeight() throws ParameterValueException
	{
		Cylinder cylinder = new Cylinder(radius, NegativeHeight);
		cylinder.ValidateHeight();
	}
	@Test public void CanCalculateVolumeWithNegativeRadius()
	{
		Cylinder cylinder = new Cylinder(NegativeRadius, height);
		Assert.assertEquals(volume, cylinder.CalculateVolume(), delta);
	}
	@Test public void CanCalculateVolumeWithZeroRadius()
	{
		Cylinder cylinder = new Cylinder(ZeroRadius, height);
		Assert.assertEquals(volume, cylinder.CalculateVolume(), delta);
	}
	@Test public void CanCalculateVolumeWithNegativeHeight()
	{
		Cylinder cylinder = new Cylinder(radius, NegativeHeight);
		Assert.assertEquals(volume, cylinder.CalculateVolume(), delta);
	}
	@Test public void CanCalculateVolumeWithZeroHeight()
	{
		Cylinder cylinder = new Cylinder(radius, ZeroHeight);
		Assert.assertEquals(volume, cylinder.CalculateVolume(), delta);
	}
}
