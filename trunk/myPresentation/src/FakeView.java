
public class FakeView implements IFractionView
{

	public String m_numerator1;
	public String m_denominator1;
	public String m_numerator2;
	public String m_denominator2;
	public String m_result;

	public IActionHandler m_addActionHandler;
	public IActionHandler m_substractActionHandler;
	public IActionHandler m_multiplyActionHandler;
	public IActionHandler m_divideActionHandler;
	public IActionHandler m_clearActionHandler;
	private String m_alertErrorMessage;

	@Override
	public String getNumerator1()
	{

		return m_numerator1;
	}

	@Override
	public String getDenominator1()
	{
		return m_denominator1;
	}

	@Override
	public String getNumerator2()
	{
		return m_numerator2;
	}

	@Override
	public String getDenominator2()
	{
		return m_denominator2;
	}

	@Override
	public void setResult(String string)
	{
		m_result = string;

	}

	@Override
	public void setAddActionHandler(IActionHandler handler)
	{
		m_addActionHandler = handler;

	}

	@Override
	public void setSubstractActionHandler(IActionHandler handler)
	{
		m_substractActionHandler = handler;

	}

	@Override
	public void setMultiplyActionHandler(IActionHandler handler)
	{
		m_multiplyActionHandler = handler;

	}

	@Override
	public void setDevideActionHandler(IActionHandler handler)
	{
		m_divideActionHandler = handler;

	}

	@Override
	public void setClearActionHandler(IActionHandler handler)
	{
		m_clearActionHandler=handler;
		
	}

	@Override
	public void setNumerator1(String string)
	{
		m_numerator1=string;
	}

	@Override
	public void setDenominator1(String string)
	{
		m_denominator1=string;
	}

	@Override
	public void setNumerator2(String string)
	{
		m_numerator2=string;
	}

	@Override
	public void setDenominator2(String string)
	{
		m_denominator2=string;
	}

	@Override
	public void setOutputError(String message)
	{
		m_alertErrorMessage = message;
		
	}

}
