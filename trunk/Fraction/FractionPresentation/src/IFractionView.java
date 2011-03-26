
public interface IFractionView
{
	public String getNumerator1();

	public String getDenominator1();

	public String getNumerator2();

	public String getDenominator2();

	public void setResult(String string);

	public void setAddActionHandler(IActionHandler handler);

	public void setSubstractActionHandler(IActionHandler handler);

	public void setMultiplyActionHandler(IActionHandler handler);

	public void setDevideActionHandler(IActionHandler handler);

}
