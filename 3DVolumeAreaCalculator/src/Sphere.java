
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
	public double CalculateVolume()
	{
		double volume = 4/3 * Math.PI * Math.pow(this.radius, 3);
		return volume;
	}
}
