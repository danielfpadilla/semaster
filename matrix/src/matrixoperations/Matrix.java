package matrixoperations;


public class Matrix {
    private int m_size=2;
	final double delta = 0.00001;

	private  double[][] matrix1 = new double[m_size][m_size];
	private double[][] matrix2 = new double[m_size][m_size];

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
	
	public Matrix(int size)
	{
		if(size>0)
		{
		m_size=size;
		}
		else
			throw new IllegalArgumentException("Invalid Size!!!");
	}

	public void setSize(int size)
	{
		m_size=size;
		
	}
	
	public int  getSize()
	{
		return m_size;
		
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	

	public static  Matrix sum(double[][] m1, double[][] m2) {
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

	public static  Matrix subtract(double[][] b, double[][] c) {
		
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

	public double CalculateDeterminant(Matrix myMatrix)
	{
		if (m_size == 1) 
			return matrix1 [0][0];
        Matrix matrix = new Matrix();
        matrix.m_size = m_size-1;
        double [][] minorData = new double [m_size-1][m_size-1];
        double result = 0;
        for (int k = 0; k < m_size; k++)
        {
            int i1 = 0;

            for (int i = 1; i < m_size; i++)
            {
                int j1 = 0;
                for (int j = 0; j < m_size; j++)
                {
                    if (j == k) continue;
                    minorData[i1][j1] = matrix1[i][j];
                    j1++;
                }
                i1++;
            }
            matrix.matrix1 = minorData;
            result += Math.pow(-1, k)* matrix1[0][k]* matrix.CalculateDeterminant(matrix);
        }
        return result;
	}

	
}

