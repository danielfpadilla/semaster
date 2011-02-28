package matrixoperations;

public class Matrix {
	final int N = 3;	
	
	 private double[][] matrix1 = new double[N][N];
	 
	 public Matrix() {}
	 
	  public Matrix(double [][]matrix)
	  {
		  for (int i = 0;i < matrix.length; i++)
		  {
		      for (int j = 0; j < matrix.length; j++) {
		        matrix1[i][j] = matrix[i][j];
		      } 
		  }
	  }

	public double [][] sum(double[][] m1, double[][] m2) {
		    double[][] result = new double[m1.length][m1.length];
	            for (int i = 0; i < m1.length; i++)
	            {
		      for (int j = 0; j < m1.length; j++)

		           result[i][j] = m1[i][j] + m2[i][j];
	            }
	            return result;
		
	}
	
	/*public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		  buffer.append("{");
		  for (int i = 0;i < matrix1.length; i++)
		  {
			  buffer.append("{");
		      for (int j = 0; j < matrix1.length; j++) {
		        buffer.append(Double.toString(matrix1[i][j]) + ",");
		      } 
			  buffer.append("},");
		  }
		  buffer.append("}");
		  return buffer.toString();
	}*/

}
