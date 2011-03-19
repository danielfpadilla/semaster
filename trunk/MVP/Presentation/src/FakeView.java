
public class FakeView implements IView
{
	private String m_realPart1;
	private String m_imaginaryPart1;
	private String m_realPart2;
	private String m_imaginaryPart2;
	private String m_result;
	
	//private IActionHandler m_parseNumbersActionHandler;
	private IActionHandler m_addActionHandler;
	//private IActionHandler m_multiplyActionHandler;
	
	public String getRealPartOfNumber1()
	{
		return m_realPart1;
	}

	public void setRealPartOfNumber1(String string)
	{
		m_realPart1 = string;
	}

	public String getImaginaryPartOfNumber1()
	{
		return m_imaginaryPart1;
	}

	public void setImaginaryPartOfNumber1(String string)
	{
		m_imaginaryPart1 = string;
	}

	public String getRealPartOfNumber2()
	{
		return m_realPart2;
	}

	public void setRealPartOfNumber2(String string)
	{
		m_realPart2 = string;
	}

	public String getImaginaryPartOfNumber2()
	{
		return m_imaginaryPart2;
	}

	public void setImaginaryPartOfNumber2(String string)
	{
		m_imaginaryPart2 = string;
	}

	public String getResultComplexNumber()
	{
		return m_result;
	}

	public void setResultComplexNumber(String string)
	{
		m_result = string;
	}

	/*public void setParseNumbersActionHandler(IActionHandler handler)
	{
		m_parseNumbersActionHandler = handler;
	}*/

	public void setAddActionHandler(IActionHandler handler)
	{
		m_addActionHandler = handler;
	}

	/*public void setMultiplyActionHandler(IActionHandler handler)
	{
		m_multiplyActionHandler = handler;
	}*/

	
	public void doAddAction()
	{
		m_addActionHandler.processAction();
	}
	

}
