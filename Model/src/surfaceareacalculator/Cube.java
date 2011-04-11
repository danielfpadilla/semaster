package src.surfaceareacalculator;

public class Cube implements I3DFigure
{
	private double m_faceLength;
	private final int NUM_OF_FACES = 6;

	public Cube(double facelength)
	{
		if (facelength <= 0.0)
			throw new ArithmeticException("Invalid cube facelength");
		m_faceLength = facelength;
	}

	public double getFaceLength()
	{
		return m_faceLength;
	}

	public double calculateArea()
	{
		double faceArea = Math.pow(m_faceLength, 2);
		double result = faceArea * NUM_OF_FACES;
		return result;
	}

}
