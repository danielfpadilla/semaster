import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class FractionPresenterTest
{
	private FakeView m_view;
	private FractionPresenter m_presenter;

	// private final double DELTA=0.00001;

	@Before
	public void setUp()
	{
		m_view = new FakeView();
		m_presenter = new FractionPresenter(m_view);
	}

	@After
	public void tearDown()
	{
		m_view = null;
		m_presenter = null;

	}

	@Test
	public void canConvertStringToFraction()
	{
		String numeratorString = "1";
		String denominatorString = "2";

		Fraction convertedFraction = FractionPresenter.convertToFraction(
				numeratorString, denominatorString);

		Assert.assertEquals(new Fraction(1, 2), convertedFraction);
	}

	@Test
	public void canCreateFractionOBjectFromNumeratorAndDenomenator()
	{
		String numerator = "1";
		String denominator = "2";
		Fraction convertedFraction = FractionPresenter.convertToFraction(
				numerator, denominator);

		Assert.assertEquals(new Fraction(1, 2), convertedFraction);

	}

	@Test
	public void canCreateAddAction()
	{
		m_view.m_numerator1 = "1";
		m_view.m_denominator1 = "4";
		m_view.m_numerator2 = "1";
		m_view.m_denominator2 = "2";

		m_view.m_addActionHandler.processAction();
		Assert.assertEquals("3/4", m_view.m_result);
	}

	@Test
	public void canCreateSubstractAction()
	{
		m_view.m_numerator1 = "1";
		m_view.m_denominator1 = "4";
		m_view.m_numerator2 = "1";
		m_view.m_denominator2 = "2";

		m_view.m_substractActionHandler.processAction();
		Assert.assertEquals("1/4", m_view.m_result);

	}

	@Test
	public void canCreateMultiplyAction()
	{
		m_view.m_numerator1 = "1";
		m_view.m_denominator1 = "4";
		m_view.m_numerator2 = "1";
		m_view.m_denominator2 = "2";

		m_view.m_multiplyActionHandler.processAction();
		Assert.assertEquals("1/8", m_view.m_result);
	}

	@Test
	public void canThrowAnArithmeticExceptionWhenDividingByZero()
	{
		m_view.m_numerator1 = "1";
		m_view.m_denominator1 = "0";
		m_view.m_numerator2 = "0";
		m_view.m_denominator2 = "1";

		m_view.m_inputActionHandler.processAction();
		Assert.assertEquals("there is a zero in the denominator",
				m_view.m_alertErrorMessage);

	}

	@Test
	public void canCreateDivideAction()
	{
		m_view.m_numerator1 = "1";
		m_view.m_denominator1 = "4";
		m_view.m_numerator2 = "1";
		m_view.m_denominator2 = "2";

		m_view.m_divideActionHandler.processAction();
		Assert.assertEquals("1/2", m_view.m_result);
	}

	@Test
	public void canCreateClearAction()
	{
		m_view.m_numerator1 = "";
		m_view.m_denominator1 = "";
		m_view.m_numerator2 = "";
		m_view.m_denominator2 = "";

		m_view.m_clearActionHandler.processAction();
		Assert.assertEquals("",m_view.m_result);
	}

	@Test
	public void canThrowExceptionForInputMismatch()
	{
		m_view.m_numerator1 = "q";
		m_view.m_denominator1 = "a";
		m_presenter.convertToFraction(m_view.m_numerator1,
				m_view.m_denominator1);

		Assert.assertEquals("Invalid Input Data!", m_view.m_alertErrorMessage);
	}

	@Test
	public void canCheckForErrorsInInputwhenDenominatorsHaveZero()
	{
		m_view.m_numerator1 = "1";
		m_view.m_denominator1 = "0";
		m_view.m_inputActionHandler.processAction();
		Assert.assertEquals("there is a zero in the denominator",
				m_view.m_alertErrorMessage);
	}

	@Test
	public void canCheckForErrorsInInputwhenInputHaveInvalidCharacters()
	{
		m_view.m_numerator1 = "a";
		m_view.m_denominator1 = "1";
		m_view.m_inputActionHandler.processAction();
		Assert.assertEquals("Invalid input Character",
				m_view.m_alertErrorMessage);
	}
}
