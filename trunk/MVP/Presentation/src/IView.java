
public interface IView
{
	public String getRealPartOfNumber1();
	public void setRealPartOfNumber1(String string);

	public String getImaginaryPartOfNumber1();
	public void setImaginaryPartOfNumber1(String string);

	public String getRealPartOfNumber2();
	public void setRealPartOfNumber2(String string);

	public String getImaginaryPartOfNumber2();
	public void setImaginaryPartOfNumber2(String string);

	public String getResultComplexNumber();
	public void setResultComplexNumber(String string);

	//public void setParseNumbersActionHandler(IActionHandler handler);
	public void setAddActionHandler(IActionHandler handler);
	//public void setMultiplyActionHandler(IActionHandler handler);
}
