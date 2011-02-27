import org.junit.Test;
import junit.framework.Assert;

public class TorusTest 
{
	int CircleRadius = 4;
	int TorusRadius = 6;
	int TorusRadiusLessThanCircleRadius = 3;
	int NegativeCircleRadius = -4;
	int NegativeTorusRadius = -6;
	double volume = 2 * Math.pow(Math.PI, 2) * TorusRadius * Math.pow(CircleRadius, 2);
	double VolumeWithTorusRadiusLessThanCicrleRadius = 2 * Math.pow(Math.PI, 2) * TorusRadiusLessThanCircleRadius * Math.pow(TorusRadiusLessThanCircleRadius, 2);
	double delta = 0.000001;
	@Test public void CanCreateTorus()
	{
		Torus torus = new Torus();
		Assert.assertNotNull(torus);
	}
	@Test public void CanInitializeTorus()
	{
		Torus torus = new Torus(CircleRadius, TorusRadius);
		Assert.assertNotNull(torus);
	}
	@Test public void CanGetCircleRadius()
	{
		Torus torus = new Torus(CircleRadius, TorusRadius);
		Assert.assertEquals(CircleRadius, torus.GetCircleRadius());
	}
	@Test public void CanGetTorusRadius()
	{
		Torus torus = new Torus(CircleRadius, TorusRadius);
		Assert.assertEquals(TorusRadius, torus.GetTorusRadius());
	}
	@Test public void CanSetCircleRadius()
	{
		Torus torus = new Torus();
		torus.SetCircleRadius(CircleRadius);
		Assert.assertEquals(CircleRadius, torus.GetCircleRadius());
	}
	@Test public void CanSetTorusRadius()
	{
		Torus torus = new Torus();
		torus.SetTorusRadius(TorusRadius);
		Assert.assertEquals(TorusRadius, torus.GetTorusRadius());
	}
	@Test public void CanCalculateTorusVolumeWithGoodParametersValues()
	{
		Torus torus = new Torus(CircleRadius, TorusRadius);
		Assert.assertEquals(volume, torus.CalculateVolume(), delta);
	}
	@Test(expected = ParameterValueException.class)
	public void CanCheckParameterValueExceptionWithNegativeTorusRadius() throws ParameterValueException
	{
		Torus torus = new Torus(CircleRadius, NegativeTorusRadius);
		torus.ValidateTorusRadius();
	}
	@Test(expected = ParameterValueException.class)
	public void CanCheckParameterValueExceptionWithNegativeCircleRadius() throws ParameterValueException
	{
		Torus torus = new Torus(NegativeCircleRadius, TorusRadius);
		torus.ValidateCircleRadius();
	}
	@Test(expected = ParameterValueException.class)
	public void CanCheckParameterValueExceptionWithTorusRadiusLessThanCircleRadius() throws ParameterValueException
	{
		Torus torus = new Torus(CircleRadius, TorusRadiusLessThanCircleRadius);
		torus.ValidateCircleRadiusAndTorusRadiusDifference();
	}
	@Test public void CanCalculateTorusVolumeWithNegativeTorusRadius()
	{
		
		Torus torus = new Torus(CircleRadius, NegativeTorusRadius);
		Assert.assertEquals(volume, torus.CalculateVolume(), delta);
	}
	@Test public void CanCalculateTorusVolumeWithNegativeCircleRadius()
	{
		
		Torus torus = new Torus(NegativeCircleRadius, TorusRadius);
		Assert.assertEquals(volume, torus.CalculateVolume(), delta);
	}
	@Test public void CanCalculateTorusVolumeWithTorusRadiusLessThanCircleRadius()
	{
		Torus torus = new Torus(CircleRadius, TorusRadiusLessThanCircleRadius);
		Assert.assertEquals(VolumeWithTorusRadiusLessThanCicrleRadius, torus.CalculateVolume(), delta);
	}
}

