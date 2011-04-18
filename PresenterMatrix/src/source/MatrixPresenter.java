package source;
import matrixpackage.Matrix;

public class MatrixPresenter
{
	private IMatrixView m_view;
	double[][] m_data;

	public MatrixPresenter(IMatrixView view)
	{
		m_view = view;
		m_view.setAddActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				MatrixPresenter.this.addMatrices();

			}
		});
		m_view.setDeterminantActionHandler(new IActionHandler()
		{
			
			@Override
			public void processAction()
			{
				MatrixPresenter.this.calculateDeterminant();
				
			}
		});
		m_view.setSubtractActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				MatrixPresenter.this.SubtractMatrices();

			}
		});
		
		m_view.setMultiplyActionHandler(new IActionHandler()
		
		{
			@Override
			public void processAction()
			{

                         MatrixPresenter.this.MultiplyMatrices();
				
			}
	        });
		
		m_view.setInverseActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				MatrixPresenter.this.FindInverseOfMatrix();
				
			}
			
			
			
		});
		
	}
	

	public Matrix convertToMatrix(String a00, String a01, String a10, String a11)
	{
		double[][] a = new double[2][2];
		a[0][0] = Double.parseDouble(a00);
		a[0][1] = Double.parseDouble(a01);
		a[1][0] = Double.parseDouble(a10);
		a[1][1] = Double.parseDouble(a11);
		Matrix object = new Matrix(a, 2);
		return object;

	}
        public double[][] convertToDoubleTwoDimMatrix(String a00, String a01, String a10, String a11)
        {
        	double[][] a = new double[2][2];
		a[0][0] = Double.parseDouble(a00);
		a[0][1] = Double.parseDouble(a01);
		a[1][0] = Double.parseDouble(a10);
		a[1][1] = Double.parseDouble(a11);
		return a;
        	
        }
	public boolean equals(Object otherObject)
	{

		Matrix otherNumber = (Matrix) otherObject;
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				if (m_data[i][j] != otherNumber.m_data[i][j])
					return false;
			}
		}

		return true;

	}

	protected void addMatrices()
	{
		double[][] a = new double[2][2];
		Matrix objectA = new Matrix(a, 2);
		objectA = (convertToMatrix(m_view.getmatrixA00(),
				m_view.getmatrixA01(), m_view.getmatrixA10(),
				m_view.getmatrixA11()));

		double[][] res = new double[2][2];
		Matrix objectres = new Matrix(res, 2);
		objectres = objectA.add(convertToMatrix(m_view.getmatrixB00(),
				m_view.getmatrixB01(), m_view.getmatrixB10(),
				m_view.getmatrixB11()));
		m_view.setResultC00(Double.toString(objectres.getValue(0, 0)));
		m_view.setResultC01(Double.toString(objectres.getValue(0, 1)));
		m_view.setResultC10(Double.toString(objectres.getValue(1, 0)));
		m_view.setResultC11(Double.toString(objectres.getValue(1, 1)));

	}
	protected void SubtractMatrices()
	{
		double[][] b = new double[2][2];
		Matrix objectB= new Matrix(b, 2);
		objectB = (convertToMatrix(m_view.getmatrixA00(),
				m_view.getmatrixA01(), m_view.getmatrixA10(),
				m_view.getmatrixA11()));

		double[][] result = new double[2][2];
		Matrix objectres = new Matrix(result, 2);
		objectres = objectB.subtract(convertToMatrix(m_view.getmatrixB00(),
				m_view.getmatrixB01(), m_view.getmatrixB10(),
				m_view.getmatrixB11()));
		m_view.setResultC00(Double.toString(objectres.getValue(0, 0)));
		m_view.setResultC01(Double.toString(objectres.getValue(0, 1)));
		m_view.setResultC10(Double.toString(objectres.getValue(1, 0)));
		m_view.setResultC11(Double.toString(objectres.getValue(1, 1)));

	}
	protected void calculateDeterminant()
	{
		double[][] a = new double[2][2];
		Matrix objectA = new Matrix(a, 2);
		objectA = (convertToMatrix(m_view.getmatrixA00(),
				m_view.getmatrixA01(), m_view.getmatrixA10(),
				m_view.getmatrixA11()));
		double res = objectA.Determinant(objectA.m_data);
		m_view.setDeterminatResult(Double.toString(res));
	}
	
	protected void FindInverseOfMatrix()
	{
		double[][] a = new double[2][2];
		Matrix m  = new Matrix();
		a = convertToDoubleTwoDimMatrix(m_view.getmatrixA00(),
		m_view.getmatrixA01(), m_view.getmatrixA10(),
		m_view.getmatrixA11());
		double[][] result = new double[2][2];
		try
		{
			result = m.Inverse(a);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Matrix objectres = new Matrix(result, 2);
		m_view.setResultC00(Double.toString(objectres.getValue(0, 0)));
		m_view.setResultC10(Double.toString(objectres.getValue(0, 1)));
		m_view.setResultC01(Double.toString(objectres.getValue(1, 0)));
		m_view.setResultC11(Double.toString(objectres.getValue(1, 1)));
	}

	protected void MultiplyMatrices()
	{
		double[][] a = new double[2][2];
		double[][] b = new double[2][2];
		Matrix m  = new Matrix();
		a = convertToDoubleTwoDimMatrix(m_view.getmatrixA00(),
		m_view.getmatrixA01(), m_view.getmatrixA10(),
		m_view.getmatrixA11());
		b = convertToDoubleTwoDimMatrix(m_view.getmatrixB00(),
				m_view.getmatrixB01(), m_view.getmatrixB10(),
				m_view.getmatrixB11());
		
		double[][] result = new double[2][2];
		try
		{
			result = m.multiplyMatrix(a, b);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Matrix objectres = new Matrix(result, 2);
		m_view.setResultC00(Double.toString(objectres.getValue(0, 0)));
		m_view.setResultC01(Double.toString(objectres.getValue(0, 1)));
		m_view.setResultC10(Double.toString(objectres.getValue(1, 0)));
		m_view.setResultC11(Double.toString(objectres.getValue(1, 1)));
		
	}
}
