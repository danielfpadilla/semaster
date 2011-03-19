import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class CalculationWindow implements IView
{

	protected Shell shell;
	private Text m_real1;
	private Text m_imaginary1;
	private Text m_real2;
	private Text m_imaginary2;
	private Text m_result;
	
	private IActionHandler m_addHandler;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			CalculationWindow window = new CalculationWindow();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed())
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
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		m_real1 = new Text(shell, SWT.BORDER);
		m_real1.setBounds(73, 10, 76, 19);
		
		m_imaginary1 = new Text(shell, SWT.BORDER);
		m_imaginary1.setBounds(223, 10, 76, 19);
		
		m_real2 = new Text(shell, SWT.BORDER);
		m_real2.setBounds(73, 55, 76, 19);
		
		m_imaginary2 = new Text(shell, SWT.BORDER);
		m_imaginary2.setBounds(223, 55, 76, 19);
		
		m_result = new Text(shell, SWT.BORDER);
		m_result.setBounds(73, 166, 235, 19);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				m_addHandler.processAction();
			}
		});
		btnNewButton.setBounds(73, 112, 68, 23);
		btnNewButton.setText("Add");

	}

	public String getRealPartOfNumber1()
	{
		return m_real1.getText();
	}

	public void setRealPartOfNumber1(String string)
	{
		m_real1.setText(string);
	}

	public String getImaginaryPartOfNumber1()
	{
		return m_imaginary1.getText();
	}

	public void setImaginaryPartOfNumber1(String string)
	{
		m_imaginary1.setText(string);
	}

	public String getRealPartOfNumber2()
	{
		return m_real2.getText();
	}

	public void setRealPartOfNumber2(String string)
	{
		m_real2.setText(string);
	}

	public String getImaginaryPartOfNumber2()
	{
		return m_imaginary2.getText();
	}

	public void setImaginaryPartOfNumber2(String string)
	{
		m_imaginary2.setText(string);
	}

	public String getResultComplexNumber()
	{
		return m_result.getText();
	}

	public void setResultComplexNumber(String string)
	{
		m_result.setText(string);
	}

	public void setAddActionHandler(IActionHandler handler)
	{
		m_addHandler = handler;
	}
}
