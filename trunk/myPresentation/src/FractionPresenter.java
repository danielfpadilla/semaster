import fractionCalculator.Fraction;

public class FractionPresenter
{
	private Fraction m_fraction;
	private IFractionView m_view;

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

	public static Fraction convertToFraction(String numeratorString,
			String denominatorString) throws IllegalArgumentException
	{
		try
		{
		return new Fraction(Integer.parseInt(numeratorString),
				Integer.parseInt(denominatorString));
		}
		
		catch(IllegalArgumentException e)
		{
			System.err.printf("\nException %s\n", e);
			return null;
		}
		
	}

	void processAddAction()
	{
		Fraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		Fraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());

		Fraction result = fraction1.addFractions(fraction2);
		m_view.setResult(result.toString());
	}

	protected void processSubtractAction()
	{
		Fraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		Fraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());

		Fraction result = fraction1.subtractFractions(fraction2);
		m_view.setResult(result.toString());

	}

	protected void processMultiplyAction()
	{
		Fraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		Fraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());

		Fraction result = fraction1.multiplyFractions(fraction2);
		m_view.setResult(result.toString());

	}

	protected void processDivideAction() 
	{
		
		Fraction fraction1 = convertToFraction(m_view.getNumerator1(),
				m_view.getDenominator1());
		Fraction fraction2 = convertToFraction(m_view.getNumerator2(),
				m_view.getDenominator2());
      
		      Fraction result = fraction2.divideFractions(fraction1);
		      m_view.setResult(result.toString());
                 
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
