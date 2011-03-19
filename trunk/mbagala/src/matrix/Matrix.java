package matrix;

public class Matrix {
    private  int m_size=2;
    private int iDF=0;
	final double delta = 0.00001;

	private  double[][] myMatrix = new double[m_size][m_size];
	private double[][] matrix2 = new double[m_size][m_size];

	
	public Matrix() {
	}

	public Matrix(double[][] matrix) {
		 for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				myMatrix[i][j] = matrix[i][j];
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
//--------------------------------------------------------------------------	

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
//-------------------------------------------------------------------------
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		for (int i = 0; i < myMatrix.length; i++) {
			buffer.append("{");
			for (int j = 0; j < myMatrix.length; j++) {
				buffer.append(Double.toString(myMatrix[i][j]) + ",");
			}
			buffer.append("},");
		}
		buffer.append("}");
		return buffer.toString();
	}
//-----------------------------------------------------------------------
	public boolean equals(Object otherObject) {
		Matrix otherNumber = (Matrix) otherObject;
		for (int i = 0; i < myMatrix.length; i++) {
			for (int j = 0; j < myMatrix.length; j++) {
				if (Math.abs(myMatrix[i][j] - otherNumber.myMatrix[i][j]) < delta
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
//---------------------------------------------------------------------
	public static   Matrix subtract(double[][] b, double[][] c) {
		
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
//------------------------------------------------------------------------
public double Determinant(double[][] matrix) {
		
		int tms = matrix.length;

		double det = 1;

		matrix = UpperTriangle(matrix);

		for (int i = 0; i < tms; i++) {
			det = det * matrix[i][i];
		} // multiply down diagonal

		det = det * iDF; 
		
				return det;
	}

	// --------------------------------------------------------------

	public double[][] Inverse(double[][] a) throws Exception {
		
		int tms = a.length;

		double m[][] = new double[tms][tms];
		double mm[][] = Adjoint(a);

		double det = Determinant(a);
		double dd = 0;
         
		if (det == 0) {
			  throw new IllegalArgumentException("Determinant is zero! ");
			}
		 else {
				dd =  det;
			}
      
	for (int i = 0; i < tms; i++)
		{
			for (int j = 0; j < tms; j++) {
				m[i][j] =  mm[i][j]/dd;
				
			}
		}
		
		return m;
	}

	// --------------------------------------------------------------

	public double[][] Adjoint(double[][] a) {
		
		int tms = a.length;

		double m[][] = new double[tms][tms];

		int ii, jj, ia, ja;
		double det;
        
			for (int i = 0; i < tms; i++)
			for (int j = 0; j < tms; j++) {
				ia = ja = 0;

				double ap[][] = new double[tms - 1][tms - 1];

				for (ii = 0; ii < tms; ii++) {
					for (jj = 0; jj < tms; jj++) {

						if ((ii != i) && (jj != j)) {
							ap[ia][ja] = a[ii][jj];
							ja++;
						}

					}
					if ((ii != i) && (jj != j)) {
						ia++;
					}
					ja = 0;
				}
 
				det = Determinant(ap);
				m[i][j] = (float) Math.pow(-1, i + j)*det ;
				
			}
		
      		return m;
	}
	
	public double[][] UpperTriangle(double[][] m) {
		
		double f1 = 0;
		double temp = 0;
		int tms = m.length; // get This Matrix Size (could be smaller than
							// global)
		int v = 1;

		iDF = 1;

		for (int col = 0; col < tms - 1; col++) {
			for (int row = col + 1; row < tms; row++) {
				v = 1;

				while (m[col][col] == 0) // check if 0 in diagonal
				{ // if so switch until not
					if (col + v >= tms) // check if switched all rows
					{
						iDF = 0;
						break ;
					} else {
						for (int c = 0; c < tms; c++) {
							temp = m[col][c];
							m[col][c] = m[col + v][c]; // switch rows
							m[col + v][c] = temp;
						}
						v++; // count row switchs
						iDF = iDF * -1; // each switch changes determinant
										// factor
					}
				}

				if (m[col][col] != 0) {
					

					try {
						f1 = (-1) * m[row][col] / m[col][col];
						for (int i = col; i < tms; i++) {
							m[row][i] = f1 * m[col][i] + m[row][i];
						}
					} catch (Exception e) {
						System.out.println("Still Here!!!");
					}

				}

			}
		}

		return m;
	}

public double[][] multiplyMatrix(double[][] a, double[][] b) throws Exception {
		
		if(a[0].length != b.length)
			throw new Exception("Matrices incompatible for multiplication");
		double matrix[][] = new double[a.length][b[0].length];

		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b[i].length; j++)
				matrix[i][j] = 0;

		//cycle through answer matrix
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				matrix[i][j] = calculateRowColumnProduct(a,i,b,j);
			}
		}
		return matrix;
	}

	public double calculateRowColumnProduct(double[][] A, int row, double[][] B, int col){
		double product = 0;
		for(int i = 0; i < A[row].length; i++)
			product +=A[row][i]*B[i][col];
		return product;
	}
}

	
	
