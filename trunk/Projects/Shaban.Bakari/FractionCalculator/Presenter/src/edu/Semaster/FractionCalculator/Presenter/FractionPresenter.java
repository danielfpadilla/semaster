package edu.Semaster.FractionCalculator.Presenter;

import edu.Semaster.FractionCalculator.Model.Fraction;
import edu.Semaster.FractionCalculator.Model.IFraction;

public class FractionPresenter
{
	private static IFractionView m_view;

	public FractionPresenter(IFractionView view)
	{
		m_view = view;
		m_view.setAddActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				FractionPresenter.this.processAddAction();

			}
		});

		m_view.setInputActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				FractionPresenter.this.processUserInput();

			}
		});

		m_view.setSubstractActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				FractionPresenter.this.processSubtractAction();

			}
		});
		m_view.setMultiplyActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				FractionPresenter.this.processMultiplyAction();

			}
		});
		m_view.setDevideActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{

				FractionPresenter.this.processDivideAction();

			}
		});
		m_view.setClearActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				FractionPresenter.this.processClearAction();

			}
		});
	}

	protected void validate(String input)
	{

		if (input.length() == 0)
		{
			throw new NumberFormatException();
		}

		if ((m_view.getDenominator1() == "0" || m_view.getDenominator2() == "0"))
		{
			throw new NumberFormatException();
		}

		try
		{
			Double.parseDouble(input);
		}
		catch (NumberFormatException e)
		{
			throw new IllegalArgumentException("Invalid input Character");
		}
	}

	protected void processUserInput()
	{
		try
		{
			validate(m_view.getNumerator1());
			validate(m_view.getNumerator2());
			validate(m_view.getDenominator1());
			validate(m_view.getDenominator2());
		}
		catch (NumberFormatException e)
		{
			m_view.errorCondition(true, "there is a zero in the denominator");

			return;
		}

		catch (IllegalArgumentException e)
		{
			m_view.errorCondition(true, "Invalid input Character");

			return;
		}
		m_view.errorCondition(true, "");

	}

	public static IFraction convertToFraction(String numeratorString,
			String denominatorString) throws IllegalArgumentException
	{
		try
		{
			return new Fraction(Integer.parseInt(numeratorString),
					Integer.parseInt(denominatorString));
		}

		catch (IllegalArgumentException e)
		{
			m_view.errorCondition(true, "Invalid Input Data!");
			return null;
		}

	}

	protected void processAddAction()
	{
		IFraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		IFraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());

		IFraction result = fraction1.add(fraction2);
		m_view.setResult(result.toString());
	}

	protected void processSubtractAction()
	{
		IFraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		IFraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());

		IFraction result = fraction1.subtract(fraction2);
		m_view.setResult(result.toString());

	}

	protected void processMultiplyAction()
	{
		IFraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		IFraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());

		IFraction result = fraction1.multiply(fraction2);
		m_view.setResult(result.toString());

	}

	protected void processDivideAction()
	{
		try
		{
			IFraction fraction1 = convertToFraction(m_view.getNumerator1(),
					m_view.getDenominator1());
			IFraction fraction2 = convertToFraction(m_view.getNumerator2(),
					m_view.getDenominator2());

			IFraction result = fraction2.divide(fraction1);
			m_view.setResult(result.toString());
		}
		catch (ArithmeticException e)
		{
			m_view.errorCondition(true, "there is a zero in the denominator!");

		}
	}

	protected void processClearAction()
	{
		m_view.setNumerator1("");
		m_view.setDenominator1("");
		m_view.setDenominator2("");
		m_view.setNumerator2("");
		m_view.setResult("");

	}
}
