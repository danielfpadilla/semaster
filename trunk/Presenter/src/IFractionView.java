
public interface IFractionView
{
	public String getNumerator1();

	public String getDenominator1();

	public String getNumerator2();

	public String getDenominator2();

	public void setNumerator1(String string);

	public void setDenominator1(String string);

	public void setNumerator2(String string);

	public void setDenominator2(String string);

	public void setResult(String string);

	public void setAddActionHandler(IActionHandler handler);

	public void setSubstractActionHandler(IActionHandler handler);

	public void setMultiplyActionHandler(IActionHandler handler);

	public void setDevideActionHandler(IActionHandler handler);

	public void setInputActionHandler(IActionHandler handler);

	public void setClearActionHandler(IActionHandler handler);

	public void setOutputError(String message);

	public void imageLabel(boolean flag);
	
	public void setActionEnabled(boolean flag);

}
