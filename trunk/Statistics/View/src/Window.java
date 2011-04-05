
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.w3c.dom.css.ViewCSS;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.swt.custom.TableEditor;



public class Window extends View {

	protected  Shell shell;
	private Text m_resultText;
	private Text m_sizeText;
	private Table table;
	private Text valueText;

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
		shell.setModified(true);
		shell.setSize(703, 534);
		shell.setText("SWT Application");
		
		Label lblResult = new Label(shell, SWT.NONE);
		lblResult.setBounds(391, 432, 49, 13);
		lblResult.setText("Result:");
		
		m_resultText = new Text(shell, SWT.BORDER);
		m_resultText.setBounds(456, 429, 76, 19);
		
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
		lblAdd.setBounds(260, 20, 127, 15);
		lblAdd.setText("Enter numbers of value :");
		
		m_sizeText = new Text(shell, SWT.BORDER);
		m_sizeText.setBounds(260, 44, 49, 21);
		
				
		Button ButtonOk = new Button(shell, SWT.NONE);
		ButtonOk.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e)
			{				
				m_size = m_sizeText.getText();
				size = Integer.parseInt(m_size);
				m_array = new double[size];		
				
				TableItem[] tableItem ;
				tableItem = new TableItem[size];
				for(int i = 0; i < size; i++)
				{
					tableItem[i] = new TableItem(table, SWT.NONE);
				}		
				m_temp = valueText.getText();
				String[] value = m_temp.split("\\,");
				
				for(int i = 0; i < size; i++)
				{
					tableItem[i].setText(value[i]);
				}
			
			}
		});
		
		ButtonOk.setBounds(365, 69, 55, 23);
		ButtonOk.setText("Ok");		
		
		
		Button btnExpectation = new Button(shell, SWT.NONE);
		btnExpectation.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e)
			{			
				String[] value = m_temp.split("\\,");
				m_array = new double[size];
				for(int i = 0; i < size; i++)
				{
					m_array[i] = Double.parseDouble(value[i]);
				}
				m_handler.processExpectationAction();
				m_resultText.setText(m_result);				
			}
		});
		btnExpectation.setBounds(261, 153, 75, 25);
		btnExpectation.setText("Expectation");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table.setHeaderVisible(true);
		table.setBounds(42, 169, 105, 249);
		table.setLinesVisible(true);
				
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Value");						
		
		valueText = new Text(shell, SWT.BORDER);
		valueText.setBounds(260, 70, 76, 21);
		
		Button btnVariance = new Button(shell, SWT.NONE);
		btnVariance.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String[] value = m_temp.split("\\,");
				m_array = new double[size];
				for(int i = 0; i < size; i++)
				{
					m_array[i] = Double.parseDouble(value[i]);
				}
				m_handler.processVarianceAction();
				m_resultText.setText(m_result);
			}
		});
		btnVariance.setBounds(260, 184, 75, 25);
		btnVariance.setText("Variance");
		
		Button btnThirdInitialMoment = new Button(shell, SWT.NONE);
		btnThirdInitialMoment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String[] value = m_temp.split("\\,");
				m_array = new double[size];
				for(int i = 0; i < size; i++)
				{
					m_array[i] = Double.parseDouble(value[i]);
				}
				m_handler.processThirdInitialMomentAction();
				m_resultText.setText(m_result);
			}
		});
		btnThirdInitialMoment.setBounds(233, 215, 127, 25);
		btnThirdInitialMoment.setText("Third Initial Moment");
		
		Button btnFourthInitialMoment = new Button(shell, SWT.NONE);
		btnFourthInitialMoment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String[] value = m_temp.split("\\,");
				m_array = new double[size];
				for(int i = 0; i < size; i++)
				{
					m_array[i] = Double.parseDouble(value[i]);
				}
				m_handler.processFourthInitialMomentAction();
				m_resultText.setText(m_result);
			}
		});
		btnFourthInitialMoment.setBounds(233, 249, 127, 25);
		btnFourthInitialMoment.setText("Fourth Initial Moment");


	}
}
