
public class Cone 
{
	private int radius = 0;
	private int height = 0;
	public Cone(int radius, int height)
	{
		this.height = height;
		this.radius = radius;
	}
	public Cone(){}
	public int GetRadius()
	{
		return this.radius;
	}
	public int GetHeight()
	{
		return this.height;
	}
	public void SetRadius(int radius)
	{
		this.radius = radius;
	}
	public void SetHeight(int height)
	{
		this.height = height;
	}
	public void ValidateRadius() throws ParameterValueException
	{
		if (this.radius < 1) throw new ParameterValueException(this.radius);
	}
	public void ValidateHeight() throws ParameterValueException
	{
		if (this.height < 1) throw new ParameterValueException(this.height);
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
				System.out.println("You entered negative value for ConeRadius parameter:" + pve);
				System.out.println("This value will be converted to positive with the same module");
				this.radius = (-1) * this.radius;
			}
			if(this.radius == 0)
			{
				System.out.println("You entered zero value for ConeRadius parameter:" + pve);
				System.out.println("This value will be changed to default value two");
				this.radius = 2;
			}
		}
		try
		{
			this.ValidateHeight();
		}
		catch (ParameterValueException pve)
		{
			if(this.height < 0)
			{
				System.out.println("You entered negative value for ConeHeight parameter:" + pve);
				System.out.println("This value will be converted to positive with the same module");
				this.height = (-1) * this.height;
			}
			if(this.height == 0)
			{
				System.out.println("You entered zero value for ConeHeight parameter:" + pve);
				System.out.println("This value will be changed to default value four");
				this.height = 4;
			}
		}
		double volume = Math.PI/3 * (double)Math.pow(this.radius, 2) * this.height;
		return volume;
	}
}
