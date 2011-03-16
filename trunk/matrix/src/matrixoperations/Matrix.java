package matrixoperations;

public class Matrix {
	final int N = 2;
	final double delta = 0.00001;

	private double[][] matrix1 = new double[N][N];
	private double[][] matrix2 = new double[N][N];

	//private double [][]result=new double[N][N];

	public Matrix() {
	}

	public Matrix(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix1[i][j] = matrix[i][j];
				matrix2[i][j] = matrix[i][j];
			}
		}
	}

	public static Matrix sum(double[][] m1, double[][] m2) {
		Matrix res = new Matrix();
		double[][] result = new double[2][2];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1.length; j++) {
				result[i][j] = m1[i][j] + m2[i][j];
			}
			res = new Matrix(result);

		}

		return res;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		for (int i = 0; i < matrix1.length; i++) {
			buffer.append("{");
			for (int j = 0; j < matrix1.length; j++) {
				buffer.append(Double.toString(matrix1[i][j]) + ",");
			}
			buffer.append("},");
		}
		buffer.append("}");
		return buffer.toString();
	}

	public boolean equals(Object otherObject) {
		Matrix otherNumber = (Matrix) otherObject;
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1.length; j++) {
				if (Math.abs(matrix1[i][j] - otherNumber.matrix1[i][j]) < delta
						&& Math.abs(matrix2[i][j] - otherNumber.matrix2[i][j]) < delta)
					return true;

				else
					return false;

			}

		}
		if (true)
			return true;
		else
			return false;

	}

	public static Matrix subtract(double[][] b, double[][] c) {
		
		Matrix difference = new Matrix();
		double[][] result = new double[2][2];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < c.length; j++) {
				result[i][j] = b[i][j] - c[i][j];
			}
			difference = new Matrix(result);
		}
		return difference;
	}
}

