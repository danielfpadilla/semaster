import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.w3c.dom.css.ViewCSS;


public class Window extends View {

	protected Shell shell;
	private Text m_number1Text;
	private Text m_number2Text;
	private Text m_resultText;

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
		lblComplex.setBounds(63, 51, 46, 13);
		lblComplex.setText("Number 1");
		
		m_number1Text = new Text(shell, SWT.BORDER);
		m_number1Text.setBounds(137, 51, 76, 19);
		
		Label lblNumber = new Label(shell, SWT.NONE);
		lblNumber.setBounds(63, 105, 46, 13);
		lblNumber.setText("Number 2");
		
		m_number2Text = new Text(shell, SWT.BORDER);
		m_number2Text.setBounds(137, 102, 76, 19);
		
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
		btnAdd.setBounds(255, 77, 68, 23);
		btnAdd.setText("Add");
		
		Label lblResult = new Label(shell, SWT.NONE);
		lblResult.setBounds(363, 82, 49, 13);
		lblResult.setText("Result:");
		
		m_resultText = new Text(shell, SWT.BORDER);
		m_resultText.setBounds(418, 79, 76, 19);

	}
}
