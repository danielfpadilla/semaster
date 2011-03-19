
public class Presenter
{
	private ComplexNumber m_complexNumber;
	private IView m_view;
	
	public Presenter(IView view)
	{
		m_view = view;
		m_view.setAddActionHandler(new IActionHandler()
		{
			public void processAction()
			{
				Presenter.this.processAddAction();
			}
		});
	}
	
	private void processAddAction()
	{
		ComplexNumber number1 = convertToComplexNumber(
				m_view.getRealPartOfNumber1(),
				m_view.getImaginaryPartOfNumber1());
		ComplexNumber number2 = convertToComplexNumber(
				m_view.getRealPartOfNumber2(),
				m_view.getImaginaryPartOfNumber2());
		ComplexNumber result = number1.add(number2);
		m_view.setResultComplexNumber(result.toString());
	}

	public static ComplexNumber convertToComplexNumber(String realString,
			String imaginaryString)
	{
		return new ComplexNumber(Double.parseDouble(realString), Double.parseDouble(imaginaryString));
	}
}
