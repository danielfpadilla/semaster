package surfaceAreaCalculator;

import interfaceThreeDAreaCalculator.I3DSurfaceAreaCalculator;

public class Cylinder implements I3DSurfaceAreaCalculator {
	private double c_radius;
	private double c_height;
	private final int numOfSurfaces = 2;

	public Cylinder(double radius, double height) {
		if (radius <= 0.0 || height <= 0.0)
			throw new IllegalArgumentException("Negative radius or height");
		c_radius = radius;
		c_height = height;
	}

	public double getRadius() {
		return c_radius;
	}

	public double getHeight() {
		return c_height;
	}

	public double calculateArea() {
		double baseAndTopArea = numOfSurfaces * Math.PI * Math.pow(c_radius, 2);
		double lateralArea = numOfSurfaces * Math.PI * c_radius * c_height;
		double result = baseAndTopArea + lateralArea;
		return result;
	}

}
