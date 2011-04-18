package matrixwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import source.*;



public class ApplicationWindow implements IMatrixView
{

	protected Shell shlMatrixbycalculator;
	private Text m_a00Text;
	private Text m_a01Text;
	private Text m_a10Text;
	private Text m_a11Text;
	private Text m_b00Text;
	private Text m_b01Text;
	private Text m_b10Text;
	private Text m_b11Text;
	private Text m_c00Text;
	private Text m_c01Text;
	private Text m_c10Text;
	private Text m_c11Text;
	private Text m_determinantResult;
	private IActionHandler m_determinantHandler;
	private IActionHandler m_AddMatrixHandler;
	private IActionHandler m_SubtractHandler;
	private IActionHandler m_InverseHandler;
	private IActionHandler m_MultiplicationHandler;
	private Button button;
	
	public static void main(String[] args)
	{
		try
		{
			ApplicationWindow window = new ApplicationWindow();
			new MatrixPresenter(window);
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
		shlMatrixbycalculator.open();
		shlMatrixbycalculator.layout();
		while (!shlMatrixbycalculator.isDisposed())
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
		shlMatrixbycalculator = new Shell();
		shlMatrixbycalculator.setSize(450, 300);
		shlMatrixbycalculator.setText("Matrix 2-by-2-calculator");
		
		Label lblEnterA = new Label(shlMatrixbycalculator, SWT.NONE);
		lblEnterA.setBounds(10, 10, 61, 19);
		lblEnterA.setText("Enter A");
		
		Label lblEnterB = new Label(shlMatrixbycalculator, SWT.NONE);
		lblEnterB.setText("Enter B");
		lblEnterB.setBounds(102, 10, 61, 19);
		
		Label lblResult = new Label(shlMatrixbycalculator, SWT.NONE);
		lblResult.setText("Result");
		lblResult.setBounds(211, 10, 61, 19);
		
		m_a00Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_a00Text.setBounds(10, 35, 27, 25);
		
		m_a01Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_a01Text.setBounds(43, 35, 27, 25);
		
		m_a10Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_a10Text.setBounds(10, 66, 27, 25);
		
		m_a11Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_a11Text.setBounds(44, 66, 27, 25);
		
		m_b00Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_b00Text.setBounds(97, 35, 27, 25);
		
		m_b01Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_b01Text.setBounds(130, 35, 27, 25);
		
		m_b10Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_b10Text.setBounds(97, 66, 27, 25);
		
		m_b11Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_b11Text.setBounds(130, 66, 27, 25);
		
		m_c00Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_c00Text.setEditable(false);
		m_c00Text.setBounds(177, 35, 85, 25);
		
		m_c01Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_c01Text.setEditable(false);
		m_c01Text.setBounds(273, 35, 96, 25);
		
		m_c10Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_c10Text.setEditable(false);
		m_c10Text.setBounds(177, 66, 85, 25);
		
		m_c11Text = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_c11Text.setEditable(false);
		m_c11Text.setBounds(273, 66, 96, 25);
		
		m_determinantResult = new Text(shlMatrixbycalculator, SWT.BORDER);
		m_determinantResult.setEditable(false);
		m_determinantResult.setBounds(136, 130, 61, 25);
		
		Button determinantButton = new Button(shlMatrixbycalculator, SWT.NONE);
		determinantButton.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_determinantHandler.processAction();
			}
		});
		determinantButton.setBounds(10, 128, 114, 29);
		determinantButton.setText("determinant");
		
		Button btnAdd = new Button(shlMatrixbycalculator, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_AddMatrixHandler.processAction();
			}
		});
		btnAdd.setBounds(102, 97, 43, 29);
		btnAdd.setText("+");
		
		Button buttonSubtract = new Button(shlMatrixbycalculator, SWT.NONE);
		buttonSubtract.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_SubtractHandler.processAction();
			}
		});
		buttonSubtract.setText("-");
		buttonSubtract.setBounds(20, 97, 43, 29);
		
		Button btnInverse = new Button(shlMatrixbycalculator, SWT.NONE);
		btnInverse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_InverseHandler.processAction();
			}
		});
		btnInverse.setBounds(235, 128, 94, 29);
		btnInverse.setText("Inverse");
		
		button = new Button(shlMatrixbycalculator, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_MultiplicationHandler.processAction();
			}
		});
		button.setBounds(177, 97, 52, 29);
		button.setText(" *");

	}

	@Override
	public String getmatrixA00()
	{
		return m_a00Text.getText();
	}

	@Override
	public String getmatrixA01()
	{
		return m_a01Text.getText();
	}

	@Override
	public String getmatrixA10()
	{
		return m_a10Text.getText();
	}

	@Override
	public String getmatrixA11()
	{
		return m_a11Text.getText();
	}

	@Override
	public String getmatrixB00()
	{
		return m_b00Text.getText();
	}

	@Override
	public String getmatrixB01()
	{
		return m_b01Text.getText();
	}

	@Override
	public String getmatrixB10()
	{
		return m_b10Text.getText();
	}

	@Override
	public String getmatrixB11()
	{
		return m_b11Text.getText();
	}

	@Override
	public void setResultC00(String c00)
	{
		m_c00Text.setText(c00);
	}

	@Override
	public void setResultC01(String c01)
	{
		m_c01Text.setText(c01);
	}

	@Override
	public void setResultC10(String c10)
	{
		m_c10Text.setText(c10);

	}

	@Override
	public void setResultC11(String c11)
	{
		m_c11Text.setText(c11);
	}

	@Override
	public void setDeterminatResult(String determinantResult)
	{
		m_determinantResult.setText(determinantResult);
	}

	@Override
	public void setAddActionHandler(IActionHandler handler)
	{
		m_AddMatrixHandler = handler;
	}

	@Override
	public void setDeterminantActionHandler(IActionHandler handler)
	{
		m_determinantHandler = handler;

	}

	@Override
	public void setSubtractActionHandler(IActionHandler handler)
	{
		
		m_SubtractHandler = handler;
	}

	@Override
	public void setMultiplyActionHandler(IActionHandler handler)
	{
		m_MultiplicationHandler = handler;
	}

	@Override
	public void setInverseActionHandler(IActionHandler handler)
	{
		m_InverseHandler = handler;
		
	}
}
