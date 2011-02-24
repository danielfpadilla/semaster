
public class Cylinder 
{
	private int radius = 0;
	private int height = 0;
	
	public Cylinder(int rad, int hei)
	{
		this.radius = rad;
		this.height = hei;
	}
	public Cylinder(){};
	
	public int GetRadius()
	{
		return this.radius;
	}
	public int GetHeight()
	{
		return this.height;
	}
	public void SetRadius(int rad)
	{
		this.radius = rad;
	}
	public void SetHeight(int hei)
	{
		this.height = hei;
	}
	public double CalculateVolume()
	{
		double volume = Math.PI * Math.pow(this.radius, 2) * this.height;
		return volume;
	}
	
}
