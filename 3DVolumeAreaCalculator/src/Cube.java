
public class Cube 
{
	private int edge = 0;
	
	public Cube(int ed)
	{
		this.edge = ed;
	}
	public Cube(){}
	
	public int GetEdge()
	{
		return this.edge;
	}
	public void SetEdge(int ed)
	{
		this.edge = ed;
	}
	public int CalculateVolume()
	{
		return (int)Math.pow(this.edge,3);
	}
}
