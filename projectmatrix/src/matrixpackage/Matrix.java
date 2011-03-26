package matrixpackage;


public class Matrix
{

	private  double[][] m_data;
	private int m_size;


	public Matrix()
	{
		// Do nothing
	}

	public Matrix(double[][] matrixData, int size)
	{
		m_data=new double [size] [size];
		m_size=size;
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
		m_data=new double [size] [size];
		m_size=size;
		
	}

	public void setSize(int size)
	{
		m_size=size;

	}

	public int  getSize()
	{
		return m_size;

	}                   

	public void setValue(int i, int j, double value)
	{
		m_data[i][j] = value;

	}
	public double getValue(int i,int j)
	{
		return m_data[i][j];

	}


	public  Matrix add(Matrix other)
	{
		Matrix result = new Matrix(m_size);
		
		for (int i=0; i<m_size; i++)
		{
			for (int j=0; j<m_size; j++)
			{
				result.setValue(i, j, m_data[i][j] + other.m_data[i][j]);
			} 
		}

		return result;
	}
	
	public boolean equals(Object otherObject) {
		Matrix otherNumber = (Matrix) otherObject;
		for (int i=0; i<m_size; i++)
		{
			for (int j=0; j<m_size; j++)
			{
				if(m_data[i][j]!=otherNumber.m_data[i][j])
					return false;
			} 
		}

		return true;

		
	}
	public  Matrix subtract(Matrix other)
	{
		Matrix result = new Matrix(m_size);
		
		for (int i=0; i<m_size; i++)
		{
			for (int j=0; j<m_size; j++)
			{
				result.setValue(i, j, m_data[i][j] - other.m_data[i][j]);
			} 
		}

		return result;
	}
}
