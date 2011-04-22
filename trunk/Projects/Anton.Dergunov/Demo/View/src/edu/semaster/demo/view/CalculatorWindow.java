package edu.semaster.demo.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

import edu.semaster.demo.presentation.IActionHandler;
import edu.semaster.demo.presentation.IView;
import edu.semaster.demo.presentation.Presenter;

public class CalculatorWindow implements IView
{

	protected Shell shlComplexNumberCalculator;
	private Text m_real1Text;
	private Text m_imaginary1Text;
	private Text m_real2Text;
	private Text m_imaginary2Text;
	private Text m_resultText;

	private IActionHandler m_addHandler;
	private IActionHandler m_multiplyHandler;
	private Label lblndNumber;
	private Label label_1;
	private Label label_2;
	private Label lblResult;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			CalculatorWindow window = new CalculatorWindow();
			new Presenter(window);
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		shlComplexNumberCalculator.open();
		shlComplexNumberCalculator.layout();
		while (!shlComplexNumberCalculator.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents()
	{
		shlComplexNumberCalculator = new Shell();
		shlComplexNumberCalculator.setSize(336, 256);
		shlComplexNumberCalculator.setText("Complex Number Calculator");

		m_real1Text = new Text(shlComplexNumberCalculator, SWT.BORDER);
		m_real1Text.setBounds(109, 10, 76, 19);

		m_imaginary1Text = new Text(shlComplexNumberCalculator, SWT.BORDER);
		m_imaginary1Text.setBounds(206, 10, 76, 19);

		m_real2Text = new Text(shlComplexNumberCalculator, SWT.BORDER);
		m_real2Text.setBounds(109, 65, 76, 19);

		m_imaginary2Text = new Text(shlComplexNumberCalculator, SWT.BORDER);
		m_imaginary2Text.setBounds(206, 65, 76, 19);

		m_resultText = new Text(shlComplexNumberCalculator, SWT.BORDER);
		m_resultText.setBounds(109, 178, 173, 19);

		Button m_addButton = new Button(shlComplexNumberCalculator, SWT.NONE);
		m_addButton.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent e)
			{
				m_addHandler.processAction();
			}
		});
		m_addButton.setBounds(109, 120, 68, 23);
		m_addButton.setText("Add");
		
		Button m_multiplyButton = new Button(shlComplexNumberCalculator, SWT.NONE);
		m_multiplyButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_multiplyHandler.processAction();
			}
		});
		m_multiplyButton.setBounds(198, 119, 75, 25);
		m_multiplyButton.setText("Multiply");
		
		Label lblstNumber = new Label(shlComplexNumberCalculator, SWT.NONE);
		lblstNumber.setBounds(10, 12, 63, 15);
		lblstNumber.setText("1st number:");
		
		Label label = new Label(shlComplexNumberCalculator, SWT.NONE);
		label.setBounds(192, 12, 8, 15);
		label.setText("+");
		
		Label lblI = new Label(shlComplexNumberCalculator, SWT.NONE);
		lblI.setBounds(288, 12, 3, 15);
		lblI.setText("i");
		
		lblndNumber = new Label(shlComplexNumberCalculator, SWT.NONE);
		lblndNumber.setBounds(10, 67, 68, 15);
		lblndNumber.setText("2nd number:");
		
		label_1 = new Label(shlComplexNumberCalculator, SWT.NONE);
		label_1.setText("+");
		label_1.setBounds(191, 67, 8, 15);
		
		label_2 = new Label(shlComplexNumberCalculator, SWT.NONE);
		label_2.setText("i");
		label_2.setBounds(288, 67, 3, 15);
		
		lblResult = new Label(shlComplexNumberCalculator, SWT.NONE);
		lblResult.setBounds(10, 180, 55, 15);
		lblResult.setText("Result:");

	}

	public String getReal1()
	{
		return m_real1Text.getText();
	}

	public String getImaginary1()
	{
		return m_imaginary1Text.getText();
	}

	public String getReal2()
	{
		return m_real2Text.getText();
	}

	public String getImaginary2()
	{
		return m_imaginary2Text.getText();
	}

	public void setResult(String string)
	{
		m_resultText.setText(string);
	}

	public void setAddActionHandler(IActionHandler handler)
	{
		m_addHandler = handler;
	}

	public void setMultiplyActionHandler(IActionHandler handler)
	{
		m_multiplyHandler = handler;
	}
}
