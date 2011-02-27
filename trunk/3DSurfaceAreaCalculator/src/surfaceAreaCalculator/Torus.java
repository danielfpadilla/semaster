package surfaceAreaCalculator;

public class Torus {
	private double t_minorRadius;//ring radius
	private double t_majorRadius;//distance from the torus center to the tube center
	public Torus()
	{}
    public Torus(double minorRadius, double majorRadius )
	{
    	if(minorRadius <= 0.0 || majorRadius <=0.0 || minorRadius > majorRadius)
    		throw new IllegalArgumentException("Either the two are negative or minor " +
    				"radius is greater major radius ");
		t_minorRadius = minorRadius;
		t_majorRadius = majorRadius;
	}
	public boolean equals(Object firstObject)
	{
		Torus secondObject = (Torus)firstObject;
		if((t_minorRadius - secondObject.t_minorRadius)==(t_majorRadius - secondObject.t_majorRadius))
		return true;
		else
			return false;
	}
	public double getMinorRadius()
	{
		return t_minorRadius;
	}
	public double getmajorRadius()
	{
		return t_majorRadius;
	}
	public double calculateArea()
	{
		double result = 4 * Math.pow(Math.PI, 2) * t_majorRadius * t_minorRadius;
		return result;
	}
}
