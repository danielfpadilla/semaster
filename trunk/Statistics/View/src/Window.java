import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.w3c.dom.css.ViewCSS;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.custom.TableTree;



public class Window extends View {

	protected Shell shell;
	private Text m_number1Text;
	private Text m_number2Text;
	private Text m_resultText;
	private Text m_sizeText;
	private Table table;
	private Text m_probability1Text;
	private Text m_probability2Text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Window window = new Window();
			new Presenter(window);
			window.open();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(703, 534);
		shell.setText("SWT Application");
		
		Label lblComplex = new Label(shell, SWT.NONE);
		lblComplex.setBounds(384, 22, 46, 13);
		lblComplex.setText("Number 1");
		
		m_number1Text = new Text(shell, SWT.BORDER);
		m_number1Text.setBounds(436, 19, 76, 19);
		
		Label lblNumber = new Label(shell, SWT.NONE);
		lblNumber.setBounds(384, 47, 46, 13);
		lblNumber.setText("Number 2");
		
		m_number2Text = new Text(shell, SWT.BORDER);
		m_number2Text.setBounds(436, 44, 76, 19);
		
		Button btnAdd = new Button(shell, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				m_number1 = m_number1Text.getText();
				m_number2 = m_number2Text.getText();
				m_handler.processAddAction();
				m_resultText.setText(m_result);
			}
		});
		btnAdd.setBounds(384, 90, 68, 23);
		btnAdd.setText("Add");
		
		Label lblResult = new Label(shell, SWT.NONE);
		lblResult.setBounds(507, 134, 49, 13);
		lblResult.setText("Result:");
		
		m_resultText = new Text(shell, SWT.BORDER);
		m_resultText.setBounds(569, 131, 76, 19);
		
		Button btnMultiply = new Button(shell, SWT.NONE);
		btnMultiply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_number1 = m_number1Text.getText();
				m_number2 = m_number2Text.getText();
				m_handler.processMultiplyAction();
				m_resultText.setText(m_result);
				
			}
		});
		btnMultiply.setBounds(384, 129, 75, 25);
		btnMultiply.setText("Multiply");
		
		Button EquiprobabilityButton = new Button(shell, SWT.RADIO);
		EquiprobabilityButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{				
				m_type = 1;						
			}
		});
		EquiprobabilityButton.setBounds(42, 46, 177, 16);
		EquiprobabilityButton.setText("Equiprobability Distribution");
		
		Button DiscreteButton = new Button(shell, SWT.RADIO);
		DiscreteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{				
				m_type = -1;
			}
		});
		DiscreteButton.setBounds(42, 72, 140, 16);
		DiscreteButton.setText("Discrete Distribution");
		
		Label lblChoose = new Label(shell, SWT.NONE);
		lblChoose.setBounds(32, 20, 157, 15);
		lblChoose.setText("Choose type of Distribution :");
		
		Label lblAdd = new Label(shell, SWT.NONE);
		lblAdd.setBounds(32, 111, 127, 15);
		lblAdd.setText("Add numbers of value :");
		
		m_sizeText = new Text(shell, SWT.BORDER);
		m_sizeText.setBounds(163, 111, 76, 21);
		
		Button ButtonOk = new Button(shell, SWT.NONE);
		ButtonOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{				
				m_size = m_sizeText.getText();
				
			}
		});
		
		ButtonOk.setBounds(250, 111, 75, 25);
		ButtonOk.setText("Ok");		
		
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e) {
				m_number1 = m_number1Text.getText();
				m_number2 = m_number2Text.getText();
				m_probability1 = m_probability1Text.getText();
				m_probability2 = m_probability2Text.getText();
				m_handler.processExpectationAction();
				m_resultText.setText(m_result);
			}
		});
		btnNewButton_1.setBounds(384, 170, 75, 25);
		btnNewButton_1.setText("Expectation");
		
		m_probability1Text = new Text(shell, SWT.BORDER);
		m_probability1Text.setBounds(556, 17, 76, 21);
		
		m_probability2Text = new Text(shell, SWT.BORDER);
		m_probability2Text.setBounds(556, 47, 76, 21);
		


	}
}
