package edu.Semaster.FractionCalculator.Presenter;

import edu.Semaster.FractionCalculator.Model.Fraction;

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

		char[] string = new char[input.length()];
		input.getChars(0, string.length, string, 0);

		for (int i = 0; i < string.length; i++)
		{
			// if(string[i]<'0' && string[i]>'9')
			if (!(string[0] != '0' && '0' <= string[i] && string[i] <= '9' || string[i] == '.'))
			{
				throw new IllegalArgumentException();
			}
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
			m_view.setOutputError("there is a zero in the denominator");
			m_view.imageLabel(true);
			m_view.setActionEnabled(false);
			return;
		}

		catch (IllegalArgumentException e)
		{
			m_view.setOutputError("Invalid input Character");
			m_view.imageLabel(true);
			m_view.setActionEnabled(false);
			return;
		}
		m_view.setOutputError("");
		m_view.imageLabel(false);
		m_view.setActionEnabled(true);

	}

	public static Fraction convertToFraction(String numeratorString,
			String denominatorString) throws IllegalArgumentException
	{
		try
		{
			return new Fraction(Integer.parseInt(numeratorString),
					Integer.parseInt(denominatorString));
		}

		catch (IllegalArgumentException e)
		{
			m_view.setOutputError("Invalid Input Data!");
			return null;
		}

	}

	void processAddAction()
	{
		Fraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		Fraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());

		Fraction result = fraction1.add(fraction2);
		m_view.setResult(result.toString());
	}

	protected void processSubtractAction()
	{
		Fraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		Fraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());

		Fraction result = fraction1.subtract(fraction2);
		m_view.setResult(result.toString());

	}

	protected void processMultiplyAction()
	{
		Fraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		Fraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());

		Fraction result = fraction1.multiply(fraction2);
		m_view.setResult(result.toString());

	}

	protected void processDivideAction()
	{
		try
		{
			Fraction fraction1 = convertToFraction(m_view.getNumerator1(),
					m_view.getDenominator1());
			Fraction fraction2 = convertToFraction(m_view.getNumerator2(),
					m_view.getDenominator2());

			Fraction result = fraction2.divide(fraction1);
			m_view.setResult(result.toString());
		}
		catch (ArithmeticException e)
		{
			m_view.setOutputError("there is a zero in the denominator!");
			// e.getMessage();

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

