package source;
public interface IMatrixView
{
	public String getmatrixA00();
	public String getmatrixA01();
	public String getmatrixA10();
	public String getmatrixA11();
	public String getmatrixB00();	
	public String getmatrixB01();
	public String getmatrixB10();
	public String getmatrixB11();
	public void setResultC00(String c00);
	public void setResultC01(String c01);
	public void setResultC10(String c10);
	public void setResultC11(String c11);
	public void setDeterminatResult(String determinantResult);
	public void setAddActionHandler(IActionHandler handler);
	public void setDeterminantActionHandler(IActionHandler handler);
	public void setSubtractActionHandler(IActionHandler handler);
	public void setMultiplyActionHandler(IActionHandler handler);
	public void setInverseActionHandler(IActionHandler handler);
	

	

	
}
