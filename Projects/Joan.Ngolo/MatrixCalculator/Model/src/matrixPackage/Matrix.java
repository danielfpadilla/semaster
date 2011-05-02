package matrixPackage;

public class Matrix
{

	private double[][] m_data;
	private int m_size;
	private int iDF = 1;

	public Matrix()
	{
		// Do nothing
	}

	public Matrix(double[][] matrixData, int size)
	{
		m_data = new double[size][size];
		m_size = size;
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				m_data[i][j] = matrixData[i][j];

			}
		}
	}

	public Matrix(int size)
	{
		m_data = new double[size][size];
		m_size = size;

	}

	public int getSize()
	{
		return m_size;

	}

	public void setValue(int i, int j, double value)
	{
		m_data[i][j] = value;

	}

	public double getValue(int i, int j)
	{
		return m_data[i][j];

	}

	public Matrix add(Matrix other)
	{
		Matrix result = new Matrix(m_size);

		for (int i = 0; i < m_size; i++)
		{
			for (int j = 0; j < m_size; j++)
			{
				result.setValue(i, j, m_data[i][j]
						+ other.m_data[i][j]);
			}
		}

		return result;
	}

	public boolean equals(Object otherObject)
	{
		Matrix otherNumber = (Matrix) otherObject;
		for (int i = 0; i < m_size; i++)
		{
			for (int j = 0; j < m_size; j++)
			{
				if (m_data[i][j] != otherNumber.m_data[i][j])
					return false;
			}
		}

		return true;

	}

	public Matrix subtract(Matrix other)
	{
		Matrix result = new Matrix(m_size);

		for (int i = 0; i < m_size; i++)
		{
			for (int j = 0; j < m_size; j++)
			{
				result.setValue(i, j, m_data[i][j]
						- other.m_data[i][j]);
			}
		}

		return result;
	}

	public double Determinant()
	{

		int tms = m_data.length;

		double det = 1;

		m_data = upperTriangle(m_data);

		for (int i = 0; i < tms; i++)
		{
			det = det * m_data[i][i];
		} // multiply down diagonal

		det = det * iDF;

		return det;
	}

	// --------------------------------------------------------------

	public double[][] Inverse(double[][] a) throws Exception
	{

		int tms = a.length;

		double m[][] = new double[tms][tms];
		double mm[][] = Adjoint(a);
Matrix myMatrix=new Matrix(a,tms);
		double det = myMatrix.Determinant();
		double dd = 0;

		if (det == 0)
		{
			throw new IllegalArgumentException(
					"Determinant is zero! ");
		}
		else
		{
			dd = det;
		}

		for (int i = 0; i < tms; i++)
		{
			for (int j = 0; j < tms; j++)
			{
				m[i][j] = mm[i][j] / dd;

			}
		}

		return m;
	}

	// --------------------------------------------------------------

	public double[][] Adjoint(double[][] a)
	{

		int tms = a.length;

		double m[][] = new double[tms][tms];

		int ii, jj, ia, ja;
		double det;
		
		for (int i = 0; i < tms; i++)
			for (int j = 0; j < tms; j++)
			{
				ia = ja = 0;

				double ap[][] = new double[tms - 1][tms - 1];

				for (ii = 0; ii < tms; ii++)
				{
					for (jj = 0; jj < tms; jj++)
					{

						if ((ii != i) && (jj != j))
						{
							ap[ia][ja] = a[ii][jj];
							ja++;
						}

					}
					if ((ii != i) && (jj != j))
					{
						ia++;
					}
					ja = 0;
				}
            Matrix myMatrix=new Matrix(ap,tms-1);
				det = myMatrix.Determinant();

				m[i][j] = (float) Math.pow(-1, i + j) * det;
		
			}

		return m;
	}

	public double[][] upperTriangle(double[][] m)
	{

		double f1 = 0;
		double temp = 0;
		int tms = m.length; // get This Matrix Size (could be smaller
					// than
					// global)
		int v = 1;

		iDF = 1;

		for (int col = 0; col < tms - 1; col++)
		{
			for (int row = col + 1; row < tms; row++)
			{
				v = 1;

				while (m[col][col] == 0) // check if 0 in
								// diagonal
				{ // if so switch until not
					if (col + v >= tms) // check if switched
								// all rows
					{
						iDF = 0;
						break;
					}
					else
					{
						for (int c = 0; c < tms; c++)
						{
							temp = m[col][c];
							m[col][c] = m[col + v][c]; // switch
											// rows
							m[col + v][c] = temp;
						}
						v++; // count row switch's
						iDF = iDF * -1; // each switch
								// changes
								// determinant
								// factor
					}
				}

				if (m[col][col] != 0)
				{

					try
					{
						f1 = (-1) * m[row][col]
								/ m[col][col];
						for (int i = col; i < tms; i++)
						{
							m[row][i] = f1
									* m[col][i]
									+ m[row][i];
						}
					}
					catch (Exception e)
					{
						System.out.println("Still Here!!!");
					}

				}

			}
		}

		return m;
	}

	public double[][] multiplyMatrix(double[][] a, double[][] b)
			throws Exception
	{

		if (a[0].length != b.length)
			throw new Exception(
					"Matrices incompatible for multiplication");
		double matrix[][] = new double[a.length][b[0].length];

		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b[i].length; j++)
				matrix[i][j] = 0;

		// cycle through answer matrix
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] = calculateRowColumnProduct(a, i,
						b, j);
				
			}
		}
		return matrix;
	}

	public double calculateRowColumnProduct(double[][] A, int row,
			double[][] B, int col)
	{
		double product = 0;
		for (int i = 0; i < A[row].length; i++)
			product += A[row][i] * B[i][col];
		return product;
	}
}
