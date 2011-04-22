package edu.semaster.demo.presentation;

public interface IView
{
	public String getReal1();

	public String getImaginary1();

	public String getReal2();

	public String getImaginary2();

	public void setResult(String string);

	public void setAddActionHandler(IActionHandler handler);

	public void setMultiplyActionHandler(IActionHandler handler);
}
