package edu.semaster.checkers.presenter;

public class Point {
	protected int x, y;

	public Point(int xCoordinate, int yCoordinate) {
		setPoint(xCoordinate, yCoordinate);
	}

	public void setPoint(int xCoordinate, int yCoordinate) {
		x = xCoordinate;
		y = yCoordinate;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	public String getName() {
		return "Point";
	}

} 
