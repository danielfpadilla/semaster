import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PresenterTest
{
	private FakeView m_view;
	private Presenter m_presenter;

	@Before
	public void setUp()
	{
		m_view = new FakeView();
		m_presenter = new Presenter(m_view);
	}

	@After
	public void tearDown()
	{
		m_view = null;
		m_presenter = null;
	}

	@Test
	public void canConvertStringToComplexNumber()
	{
		String realString = "10";
		String imaginaryString = "20";
		ComplexNumber convertedNumber = Presenter
				.convertToComplexNumber(realString,
						imaginaryString);
		Assert.assertEquals(new ComplexNumber(10, 20), convertedNumber);
	}

	@Test
	public void canConvertStringToComplexNumberWithFloatingPointNumbers()
	{
		String realString = "3.14";
		String imaginaryString = "-1e3";
		ComplexNumber convertedNumber = Presenter
				.convertToComplexNumber(realString,
						imaginaryString);
		Assert.assertEquals(new ComplexNumber(3.14, -1e3),
				convertedNumber);
	}

	@Test
	public void canPerformAddAction()
	{
		m_view.m_real1 = "1";
		m_view.m_imaginary1 = "2";
		m_view.m_real2 = "-10";
		m_view.m_imaginary2 = "-20";

		m_view.m_addActionHandler.processAction();

		Assert.assertEquals("-9.0 - 18.0i", m_view.m_result);
	}

	@Test
	public void canPerformAddActionWithRealNumbers()
	{
		m_view.m_real1 = "1.2";
		m_view.m_imaginary1 = "2.3";
		m_view.m_real2 = "-10.4";
		m_view.m_imaginary2 = "-20.5";

		m_view.m_addActionHandler.processAction();

		Assert.assertEquals("-9.2 - 18.2i", m_view.m_result);
	}

	@Test
	public void canPerformMultiplyAction()
	{
		m_view.m_real1 = "1";
		m_view.m_imaginary1 = "2";
		m_view.m_real2 = "3";
		m_view.m_imaginary2 = "4";

		m_view.m_multiplyActionHandler.processAction();

		Assert.assertEquals("-5.0 + 10.0i", m_view.m_result);
	}
}
