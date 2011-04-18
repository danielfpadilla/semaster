
public class Cube 
{
	private int edge = 0;
	
	public Cube(int edge)
	{
		this.edge = edge;
	}
	public Cube(){}
	
	public int GetEdge()
	{
		return this.edge;
	}
	public void SetEdge(int edge)
	{
		this.edge = edge;
	}
	public void ValidateEdge() throws ParameterValueException
	{
		if (this.edge < 1) throw new ParameterValueException(this.edge);
	}
	public double CalculateVolume()
	{
		try
		{
			this.ValidateEdge();
		}
		catch(ParameterValueException pve)
		{
			if (this.edge < 0)
			{
				System.out.println("You entered negative value for CubeEdge parameter:" + pve);
				System.out.println("This value will be converted to positive with the same module");
				this.edge = (-1) * this.edge;
			}
			if (this.edge == 0)
			{
				System.out.println("You entered zero value for CubeEdge parameter:" + pve);
				System.out.println("This value will be changed to default value four");
				this.edge = 4;
			}
		}
		return Math.pow(this.edge,3);
	}
}
