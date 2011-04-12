import junit.framework.Assert;

import matrixpackage.Matrix;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MatrixPresenterTest
{
	private MatrixFakeView m_view;
	private MatrixPresenter m_presenter;

	@Before
	public void setUp()
	{
		m_view = new MatrixFakeView();
		m_presenter = new MatrixPresenter(m_view);
	}

	@After
	public void tearDown()
	{
		m_view = null;
		m_presenter = null;
	}

	@Test
	public void canParseStringElementsToADoubleMAtrix()
	{
		double[][] a =
		{
		{ 1.0, 1.0 },
		{ 1.0, 1.0 } };
		double[][] b = new double[2][2];
		Matrix object1 = new Matrix(a, 2);
		Matrix object2 = new Matrix(b, 2);
		m_view.m_A00 = "1.0";
		m_view.m_A01 = "1.0";
		m_view.m_A10 = "1.0";
		m_view.m_A11 = "1.0";
		object2 = m_presenter.convertToMatrix(m_view.m_A00, m_view.m_A01,
				m_view.m_A10, m_view.m_A11);
		Assert.assertEquals(object1, object2);

	}

	@Test
public void canAddTwoMatrices()
{

	m_view.m_A00 = "1.0";
	m_view.m_A01 = "1.0";
	m_view.m_A10 = "1.0";
	m_view.m_A11 = "1.0";
	m_view.m_B00 = "1.0";
	m_view.m_B01 = "1.0";
    m_view.m_B10 = "1.0";
	m_view.m_B11 = "1.0";
	m_view.m_addMatrixActionHandler.processAction();
	Assert.assertEquals("2.0",m_view.m_c00);
	Assert.assertEquals("2.0",m_view.m_c01);
	Assert.assertEquals("2.0",m_view.m_c10);
	Assert.assertEquals("2.0",m_view.m_c11);
}
@ Test
public void canCalculateDeterminantOfAMatrix()
{
	m_view.m_A00 = "2.0";
	m_view.m_A01 = "1.0";
	m_view.m_A10 = "5.0";
	m_view.m_A11 = "1.0";
	m_view.m_determinantActionHandler.processAction();
	Assert.assertEquals("-3.0",m_view.m_determinantResult);
}
}
