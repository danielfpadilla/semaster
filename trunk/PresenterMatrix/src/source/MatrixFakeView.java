package source;
public class MatrixFakeView implements IMatrixView
{
  public String m_A00;
  public String m_A01;
  public String m_A10;
  public String m_A11;
  public String m_B00;
  public String m_B01;
  public String m_B10;
  public String m_B11;
  public String m_c00;
  public String m_c01;
  public String m_c10;
  public String m_c11;
  public String m_determinantResult;
  IActionHandler m_addMatrixActionHandler ;
  IActionHandler m_determinantActionHandler;
	@Override
	public String getmatrixA00()
	{
		return m_A00;
	}

	@Override
	public String getmatrixA01()
	{
		return m_A01;
	}

	@Override
	public String getmatrixA10()
	{
		return m_A10;
	}

	@Override
	public String getmatrixA11()
	{
		return m_A11;
	}

	@Override
	public String getmatrixB00()
	{
		return m_B00;
	}

	@Override
	public String getmatrixB01()
	{
		return m_B01;
	}

	@Override
	public String getmatrixB10()
	{
		return m_B10;
	}

	@Override
	public String getmatrixB11()
	{
		return m_B11;
	}

	@Override
	public void setResultC00(String c00)
	{
		m_c00  = c00;
	}

	@Override
	public void setResultC01(String c01)
	{
		m_c01 = c01;
		
	}

	@Override
	public void setResultC10(String c10)
	{
	m_c10 = c10;
		
	}

	@Override
	public void setResultC11(String c11)
	{
	m_c11 = c11;
	}

	@Override
	public void setAddActionHandler(IActionHandler handler)
	{
	    m_addMatrixActionHandler = handler;
	}

	@Override
	public void setDeterminatResult(String determinantResult)
	{
		m_determinantResult = determinantResult;
		
	}

	@Override
	public void setDeterminantActionHandler(IActionHandler handler)
	{
		m_determinantActionHandler =  handler;
		
	}
	
}
