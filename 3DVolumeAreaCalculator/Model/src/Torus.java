public class Torus 
{
	private int CircleRadius = 0;
	private int TorusRadius = 0;
	public Torus(){}
	public Torus(int CircleRadius, int TorusRadius)
	{
		this.CircleRadius = CircleRadius;
		this.TorusRadius = TorusRadius;
	}
	public int GetCircleRadius()
	{
		return this.CircleRadius;
	}
	public int GetTorusRadius()
	{
		return this.TorusRadius;
	}
	public void SetCircleRadius(int CircleRadius)
	{
		this.CircleRadius = CircleRadius;
	}
	public void SetTorusRadius(int TorusRadius)
	{
		this.TorusRadius = TorusRadius;
	}
	public void ValidateTorusRadius() throws ParameterValueException
	{
		if(this.TorusRadius < 1)
			throw new ParameterValueException(this.TorusRadius);
		System.out.println("TorusRadius validation passed");
	}
	public void ValidateCircleRadius() throws ParameterValueException
	{
		if(this.CircleRadius < 1)
			throw new ParameterValueException(this.CircleRadius);
		System.out.println("CircleRadius validation passed");
	}
	public void ValidateCircleRadiusAndTorusRadiusDifference() throws ParameterValueException
	{
		if((this.CircleRadius - this.TorusRadius) > 0)
			throw new ParameterValueException(this.CircleRadius);
	}	
	public double CalculateVolume()
	{
		try
		{
			this.ValidateTorusRadius();
		}
		catch (ParameterValueException pve)
		{
			if(this.TorusRadius < 0)
			{
				System.out.println("You entered negative value for TorusRadius parameter:" + pve);
				System.out.println("This value will be converted to positive with the same module");
				this.TorusRadius = (-1) * this.TorusRadius;
			}
			if(this.TorusRadius == 0)
			{
				System.out.println("You entered zero value for TorusRadius parameter.");
				System.out.println("This value will be changed to default value six.");
				this.TorusRadius = 6;
			}
		}
		try
		{
			this.ValidateCircleRadius();
		}
		catch (ParameterValueException pve)
		{
			if(this.CircleRadius < 0)
			{
				System.out.println("You entered negative value for CircleRadius parameter.");
				System.out.println("This value will be converted to positive with the same module");
				this.CircleRadius = (-1) * this.CircleRadius;
			}
			if(this.CircleRadius == 0)
			{
				System.out.println("You entered zero value for CircleRadius parameter.");
				System.out.println("This value will be changed to TorusRadius value");
				this.CircleRadius = this.TorusRadius;
			}
		}
		try
		{
			this.ValidateCircleRadiusAndTorusRadiusDifference();
		}
		catch (ParameterValueException pve)
		{
			System.out.println("You entered value for CircleRadius parameter which more than TorusRadiusValue, it is wrong:" + pve);
			System.out.println("This value will be converted to the same TorusRadiusValue : " + this.TorusRadius);
			this.CircleRadius = this.TorusRadius;

		}
		double volume = 2 * Math.pow(Math.PI, 2) * this.TorusRadius * Math.pow(this.CircleRadius, 2);
		return volume;
	}
	
}
