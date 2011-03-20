public class FakeView implements IView
{
	public String m_real1;
	public String m_imaginary1;
	public String m_real2;
	public String m_imaginary2;
	public String m_result;

	public IActionHandler m_addActionHandler;
	public IActionHandler m_multiplyActionHandler;

	public String getReal1()
	{
		return m_real1;
	}

	public String getImaginary1()
	{
		return m_imaginary1;
	}

	public String getReal2()
	{
		return m_real2;
	}

	public String getImaginary2()
	{
		return m_imaginary2;
	}

	public void setResult(String string)
	{
		m_result = string;
	}

	public void setAddActionHandler(IActionHandler handler)
	{
		m_addActionHandler = handler;
	}

	public void setMultiplyActionHandler(IActionHandler handler)
	{
		m_multiplyActionHandler = handler;
	}
}
