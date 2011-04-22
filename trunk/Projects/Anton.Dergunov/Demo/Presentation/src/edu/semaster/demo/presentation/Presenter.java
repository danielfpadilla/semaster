package edu.semaster.demo.presentation;

import edu.semaster.demo.model.ComplexNumber;

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
		m_view.setMultiplyActionHandler(new IActionHandler()
		{
			public void processAction()
			{
				Presenter.this.processMultiplyAction();
			}
		});
	}

	private void processAddAction()
	{
		ComplexNumber number1 = convertToComplexNumber(
				m_view.getReal1(), m_view.getImaginary1());
		ComplexNumber number2 = convertToComplexNumber(
				m_view.getReal2(), m_view.getImaginary2());
		ComplexNumber result = number1.add(number2);
		m_view.setResult(result.toString());
	}

	private void processMultiplyAction()
	{
		ComplexNumber number1 = convertToComplexNumber(
				m_view.getReal1(), m_view.getImaginary1());
		ComplexNumber number2 = convertToComplexNumber(
				m_view.getReal2(), m_view.getImaginary2());
		ComplexNumber result = number1.multiply(number2);
		m_view.setResult(result.toString());
	}
	
	public static ComplexNumber convertToComplexNumber(String realString,
			String imaginaryString)
	{
		return new ComplexNumber(Double.parseDouble(realString),
				Double.parseDouble(imaginaryString));
	}
}
