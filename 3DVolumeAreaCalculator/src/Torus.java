
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
	public double CalculateVolume()
	{
		double volume = 2 * Math.pow(Math.PI, 2) * TorusRadius * Math.pow(CircleRadius, 2);
		return volume;
	}
	
}
