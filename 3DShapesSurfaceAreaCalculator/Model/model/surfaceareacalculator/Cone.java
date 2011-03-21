package model.surfaceareacalculator;


public class Cone implements I3DFigure
{
	private double m_radius;
	private double m_height;

	public Cone(double radius, double height)
	{
		if (radius <= 0.0 || height <= 0.0)
			throw new IllegalArgumentException("Invalid radius and height");
		m_radius = radius;
		m_height = height;
	}

	public double getRadius()
	{
		return m_radius;
	}

	public double getHeight()
	{
		return m_height;
	}

	public double calculateArea()
	{
		double hypotenuse = Math.hypot(m_radius, m_height);
		double lateralSurfaceArea = Math.PI * m_radius * hypotenuse;
		double baseArea = Math.PI * Math.pow(m_radius, 2);
		double resultArea = baseArea + lateralSurfaceArea;
		return resultArea;
	}

}
