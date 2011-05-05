package edu.Semaster.FractionCalculator.View;

import edu.Semaster.FractionCalculator.Presenter.FractionPresenter;
import edu.Semaster.FractionCalculator.Presenter.IActionHandler;
import edu.Semaster.FractionCalculator.Presenter.IFractionView;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class FractionCalculator implements IFractionView
{

	protected Shell shlFractionCalculator;
	private Text m_result;
	private Text m_numerator1Text;
	private Text m_denominator1Text;
	private Text m_numerator2Text;
	private Text m_denominator2Text;
	private IActionHandler m_addActionHandler;
	private IActionHandler m_substractActionHandler;
	private IActionHandler m_multiplyActionHandler;
	private IActionHandler m_divideActionHandler;
	private IActionHandler m_clearActionHandler;
	private IActionHandler m_inputActionHandler;
	Button m_addButton;
	Button m_substractButton;
	Button m_multiplyButton;
	Button m_divideButton;
	private Label m_myImage;
	private Label m_errorLabel;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			FractionCalculator window = new FractionCalculator();
			new FractionPresenter(window);
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
		shlFractionCalculator.open();
		shlFractionCalculator.layout();
		while (!shlFractionCalculator.isDisposed())
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
		shlFractionCalculator = new Shell();
		shlFractionCalculator.setImage(null);
		shlFractionCalculator.setSize(450, 300);
		shlFractionCalculator.setText("Fraction Calculator");

		ModifyListener listener = new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				m_inputActionHandler.processAction();
			}

		};

		Label m_numerator1 = new Label(shlFractionCalculator, SWT.NONE);
		m_numerator1.setBounds(25, 42, 64, 20);
		m_numerator1.setText("numerator1");

		Label m_denominator1 = new Label(shlFractionCalculator, SWT.NONE);
		m_denominator1.setBounds(25, 68, 64, 14);
		m_denominator1.setText("denominator1");

		m_numerator1Text = new Text(shlFractionCalculator, SWT.BORDER);
		m_numerator1Text.setBounds(109, 42, 76, 20);
		m_numerator1Text.addModifyListener(listener);

		m_denominator1Text = new Text(shlFractionCalculator, SWT.BORDER);
		m_denominator1Text.setBounds(109, 65, 76, 20);
		m_denominator1Text.addModifyListener(listener);

		Label m_numerator2 = new Label(shlFractionCalculator, SWT.NONE);
		m_numerator2.setBounds(253, 42, 76, 20);
		m_numerator2.setText("numerator2");

		Label m_denominator2 = new Label(shlFractionCalculator, SWT.NONE);
		m_denominator2.setBounds(253, 68, 76, 14);
		m_denominator2.setText("denominator2");

		m_numerator2Text = new Text(shlFractionCalculator, SWT.BORDER);
		m_numerator2Text.setBounds(335, 39, 76, 20);
		m_numerator2Text.addModifyListener(listener);

		m_denominator2Text = new Text(shlFractionCalculator, SWT.BORDER);
		m_denominator2Text.setBounds(335, 65, 76, 20);
		m_denominator2Text.addModifyListener(listener);

		m_addButton = new Button(shlFractionCalculator, SWT.NONE);
		m_addButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_addActionHandler.processAction();
			}

		});
		m_addButton.setBounds(25, 109, 69, 24);
		m_addButton.setText("Add");

		m_substractButton = new Button(shlFractionCalculator, SWT.NONE);
		m_substractButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_substractActionHandler.processAction();
			}
		});
		m_substractButton.setBounds(25, 152, 69, 24);
		m_substractButton.setText("Substract");

		m_multiplyButton = new Button(shlFractionCalculator, SWT.NONE);
		m_multiplyButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_multiplyActionHandler.processAction();
			}
		});
		m_multiplyButton.setBounds(288, 109, 69, 24);
		m_multiplyButton.setText("Multiply");

		m_divideButton = new Button(shlFractionCalculator, SWT.NONE);
		m_divideButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_divideActionHandler.processAction();
			}
		});
		m_divideButton.setBounds(288, 152, 69, 24);
		m_divideButton.setText("Divide");

		Button clearButton = new Button(shlFractionCalculator, SWT.NONE);
		clearButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_clearActionHandler.processAction();
				m_numerator1Text.setText("0");
				m_numerator2Text.setText("0");
				m_denominator1Text.setText("0");
				m_denominator2Text.setText("0");
			}
		});
		clearButton.setBounds(153, 129, 69, 24);
		clearButton.setText("Clear");

		m_result = new Text(shlFractionCalculator, SWT.BORDER);
		m_result.setBounds(135, 10, 183, 20);
		m_result.setEditable(false);

		m_myImage = new Label(shlFractionCalculator, SWT.NONE);
		m_myImage.setImage(SWTResourceManager.getImage(
				FractionCalculator.class,
				"/com/sun/java/swing/plaf/windows/icons/Error.gif"));
		m_myImage.setBounds(60, 206, 34, 32);
		m_myImage.setVisible(false);

		m_errorLabel = new Label(shlFractionCalculator, SWT.NONE);
		m_errorLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		m_errorLabel.setBounds(109, 216, 206, 20);
	}

	@Override
	public String getNumerator1()
	{
		return m_numerator1Text.getText();
	}

	@Override
	public String getDenominator1()
	{
		return m_denominator1Text.getText();
	}

	@Override
	public String getNumerator2()
	{
		return m_numerator2Text.getText();
	}

	@Override
	public String getDenominator2()
	{
		return m_denominator2Text.getText();
	}

	@Override
	public void setResult(String string)
	{
		m_result.setText(string);

	}

	@Override
	public void setAddActionHandler(IActionHandler handler)
	{
		m_addActionHandler = handler;

	}

	@Override
	public void setSubstractActionHandler(IActionHandler handler)
	{
		m_substractActionHandler = handler;

	}

	@Override
	public void setMultiplyActionHandler(IActionHandler handler)
	{
		m_multiplyActionHandler = handler;

	}

	@Override
	public void setDevideActionHandler(IActionHandler handler)
	{
		m_divideActionHandler = handler;

	}

	@Override
	public void setNumerator1(String string)
	{
		m_numerator1Text.setText(string);

	}

	@Override
	public void setDenominator1(String string)
	{
		m_denominator1Text.setText(string);

	}

	@Override
	public void setNumerator2(String string)
	{
		m_numerator2Text.setText(string);

	}

	@Override
	public void setDenominator2(String string)
	{
		m_denominator2Text.setText(string);

	}

	@Override
	public void setClearActionHandler(IActionHandler handler)
	{

		m_clearActionHandler = handler;

	}

	@Override
	public void setInputActionHandler(IActionHandler handler)
	{
		m_inputActionHandler = handler;
	}

	@Override
	public void setErrorCondition(boolean error, String message)
	{
		if (error)
		{
			m_errorLabel.setVisible(error);
			m_errorLabel.setText(message);
			m_myImage.setVisible(error);
			m_addButton.setEnabled(!error);
			m_substractButton.setEnabled(!error);
			m_divideButton.setEnabled(!error);
			m_multiplyButton.setEnabled(!error);
		}
		else
		{
			m_myImage.setVisible(error);
			m_addButton.setEnabled(!error);
			m_substractButton.setEnabled(!error);
			m_divideButton.setEnabled(!error);
			m_multiplyButton.setEnabled(!error);
			m_errorLabel.setVisible(error);

		}

	}
}
