package surfaceAreaCalculator;

import interfaceThreeDAreaCalculator.I3DSurfaceAreaCalculator;

public class Cube implements I3DSurfaceAreaCalculator {
	private double c_faceLength;
	private final int numOfFaces = 6;

	public Cube(double facelength) {
		if (facelength <= 0.0)
			throw new IllegalArgumentException("Negative faceLength");
		c_faceLength = facelength;
	}

	public double getFaceLength() {
		return c_faceLength;
	}

	public double calculateArea() {
		double faceArea = Math.pow(c_faceLength, 2);
		double result = faceArea * numOfFaces;
		return result;
	}

}
