
public class Sphere 
{
	private int radius = 0;
	
	public Sphere(int radius)
	{
		this.radius = radius;
	}
	public Sphere(){}
	public int GetRadius()
	{
		return this.radius;
	}
	public void SetRadius(int radius)
	{
		this.radius = radius;
	}
	public void ValidateRadius() throws ParameterValueException
	{
		if (this.radius < 1) throw new ParameterValueException(this.radius);
	}
	public double CalculateVolume()
	{
		try
		{
			this.ValidateRadius();
		}
		catch (ParameterValueException pve)
		{
			if(this.radius < 0)
			{
				System.out.println("You entered negative value for SphereRadius parameter:" + pve);
				System.out.println("This value will be converted to positive with the same module");
				this.radius = (-1) * this.radius;
			}
			if(this.radius == 0)
			{
				System.out.println("You entered zero value for SphereRadius parameter" );
				System.out.println("This value will be converted to default value seven");
				this.radius = 7;
			}
		}
		double volume = 4/3 * Math.PI * Math.pow(this.radius, 3);
		return volume;
	}
}
