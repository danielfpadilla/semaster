package surfaceAreaCalculator;

import interfaceThreeDAreaCalculator.I3DSurfaceAreaCalculator;

public class Torus implements I3DSurfaceAreaCalculator
{
	private double m_minorRadius;// ring radius
	private double m_majorRadius;// distance from the torus center to the tube
									// center

	public Torus(double minorRadius, double majorRadius)
	{
		if (minorRadius <= 0.0 || majorRadius <= 0.0
				|| minorRadius > majorRadius)
			throw new IllegalArgumentException(
					"Either the two are negative or minor "
							+ "radius is greater major radius ");
		m_minorRadius = minorRadius;
		m_majorRadius = majorRadius;
	}

	public double getMinorRadius()
	{
		return m_minorRadius;
	}

	public double getmajorRadius()
	{
		return m_majorRadius;
	}

	public double calculateArea()
	{
		double result = 4 * Math.pow(Math.PI, 2) * m_majorRadius
				* m_minorRadius;
		return result;
	}
}
