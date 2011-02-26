
public class Pyramid 
{
	private int edge = 0;
	private int NumberOfEdge = 0;
	private int height = 0;
	public Pyramid(int ed, int NOE, int hei)
	{
		this.edge = ed;
		this.NumberOfEdge = NOE;
		this.height = hei;
	}
	public Pyramid(){};
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
	public void SetNumberOfEdge(int numberofedge)
	{
		this.NumberOfEdge = numberofedge;
	}
	public double CalculateVolume()
	{
		double BaseSquare = (this.NumberOfEdge/4) * Math.pow(this.edge, 2) * (1/Math.tan(Math.PI/this.NumberOfEdge));
		double volume = (1/3) * this.height * BaseSquare;
		return volume;
	}
}
