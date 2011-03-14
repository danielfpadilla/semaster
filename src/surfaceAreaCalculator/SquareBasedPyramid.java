package surfaceAreaCalculator;

import interfaceThreeDAreaCalculator.I3DSurfaceAreaCalculator;

public class SquareBasedPyramid implements I3DSurfaceAreaCalculator
{
	private double m_baseLength;
	private double m_height;
	private final int NUM_OF_SIDES = 2;

	public SquareBasedPyramid(double baseLength, double height)
	{
		if (baseLength <= 0.0 || height <= 0.0)
			throw new IllegalArgumentException("Negative baseLength or Height");
		m_baseLength = baseLength;
		m_height = height;
	}

	public double getBaselength()
	{
		return m_baseLength;
	}

	public double getHeight()
	{
		return m_height;
	}

	public double calculateArea()
	{
		double slantHeight = Math.hypot(0.5 * m_baseLength, m_height);
		double baseArea = Math.pow(m_baseLength, 2);
		double lateralArea = NUM_OF_SIDES * m_baseLength * slantHeight;
		double result = lateralArea + baseArea;
		return result;
	}
}
