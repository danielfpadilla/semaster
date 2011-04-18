
public class Pyramid 
{
	private int edge = 0;
	private int NumberOfEdge = 0;
	private int height = 0;
	public Pyramid(int edge, int NumberOfEdge, int height)
	{
		this.edge = edge;
		this.NumberOfEdge = NumberOfEdge;
		this.height = height;
	}
	public Pyramid(){}
	public int GetEdge()
	{
		return this.edge;
	}
	public int GetHeight()
	{
		return this.height;
	}
	public int GetNumberOfEdge()
	{
		return this.NumberOfEdge;
	}
	public void SetEdge(int edge)
	{
		this.edge = edge;
	}
	public void SetHeight(int height)
	{
		this.height = height;
	}
	public void SetNumberOfEdge(int NumberOfEdge)
	{
		this.NumberOfEdge = NumberOfEdge;
	}
	public void ValidateHeight() throws ParameterValueException
	{
		if (this.height < 1) throw new ParameterValueException(this.height);
	}
	public void ValidateEdge() throws ParameterValueException
	{
		if (this.edge < 1) throw new ParameterValueException(this.edge);
	}
	public void ValidateNumberOfEdge() throws ParameterValueException
	{
		if (this.NumberOfEdge < 3) throw new ParameterValueException(this.NumberOfEdge);
	}
	public double CalculateVolume()
	{
		try
		{
			this.ValidateHeight();
		}
		catch (ParameterValueException pve)
		{
			if(this.height < 0)
			{
				System.out.println("You entered negative value for PyramidHeight parameter:" + pve);
				System.out.println("This value will be converted to positive with the same module");
				this.height = (-1) * this.height;
			}
			if (this.height == 0)
			{
				System.out.println("You entered zero value for PyramidHeight parameter" );
				System.out.println("This value will be converted to default value five");
				this.height = 5;
			}
		}
		try
		{
			this.ValidateEdge();
		}
		catch (ParameterValueException pve)
		{
			if(this.edge < 0)
			{
				System.out.println("You entered negative value for PyramidEdge parameter:" + pve);
				System.out.println("This value will be converted to positive with the same module");
				this.edge = (-1) * this.edge;
			}
			if (this.edge == 0)
			{
				System.out.println("You entered zero value for PyramidEdge parameter" );
				System.out.println("This value will be converted to default value three");
				this.edge = 3;
			}
		}
		try
		{
			this.ValidateNumberOfEdge();
		}
		catch (ParameterValueException pve)
		{
			System.out.println("The Number of Edge value cannot be less that three. It will be changed to three");
			this.NumberOfEdge = 3;
		}
		double BaseSquare = (this.NumberOfEdge/4) * Math.pow(this.edge, 2) * (1/Math.tan(Math.PI/this.NumberOfEdge));
		double volume = this.height * BaseSquare / 3;
		return volume;
	}
}
