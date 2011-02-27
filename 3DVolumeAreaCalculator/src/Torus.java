public class Torus 
{
	private int CircleRadius = 0;
	private int TorusRadius = 0;
	public Torus(){}
	public Torus(int circle_rad, int torus_rad)
	{
		this.CircleRadius = circle_rad;
		this.TorusRadius = torus_rad;
	}
	public int GetCircleRadius()
	{
		return this.CircleRadius;
	}
	public int GetTorusRadius()
	{
		return this.TorusRadius;
	}
	public void SetCircleRadius(int circle_rad)
	{
		this.CircleRadius = circle_rad;
	}
	public void SetTorusRadius(int torus_rad)
	{
		this.TorusRadius = torus_rad;
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
			System.out.println("You entered negative value for TorusRadius parameter:" + pve);
			System.out.println("This value will be converted to positive with the same module");
			this.TorusRadius = (-1) * this.TorusRadius;
		}
		try
		{
			this.ValidateCircleRadius();
		}
		catch (ParameterValueException pve)
		{
			System.out.println("You entered negative value for CircleRadius parameter:" + pve);
			System.out.println("This value will be converted to positive with the same module");
			this.CircleRadius = (-1) * this.CircleRadius;
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
