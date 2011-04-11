package src.surfaceareacalculator;


public class Cylinder implements I3DFigure
{
	private double m_radius;
	private double m_height;
	private final int NUM_OF_SURFACES = 2;

	public Cylinder(double radius, double height)
	{
		if (radius <= 0.0 || height <= 0.0)
			throw new ArithmeticException("Invalid cylinder radius or height");
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
		double baseAndTopArea = NUM_OF_SURFACES * Math.PI
				* Math.pow(m_radius, 2);
		double lateralArea = NUM_OF_SURFACES * Math.PI * m_radius * m_height;
		double result = baseAndTopArea + lateralArea;
		return result;
	}

}
