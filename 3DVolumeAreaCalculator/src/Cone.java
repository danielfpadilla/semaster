
public class Cone 
{
	private int radius = 0;
	private int height = 0;
	public Cone(int rad, int hei)
	{
		this.height = hei;
		this.radius = rad;
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
		double volume = 1/3 * Math.PI * (double)Math.pow(this.radius, 2) * this.height;
		return volume;
	}
}
