
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableEditor;



public class Window extends View {

	protected  Shell shell;
	private Text m_resultText;
	private Text m_sizeText;
	private Table table;
	private Text valueText;
	private Text probabilityText;
	private Table table_1;

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
		
		Button btnFourthInitialMoment = new Button(shell, SWT.NONE);
		btnFourthInitialMoment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String[] value = m_value.split("\\,");
				m_arrayOfValue = new double[size];
				for(int i = 0; i < size; i++)
				{
					m_arrayOfValue[i] = Double.parseDouble(value[i]);
				}
				m_handler.processFourthInitialMomentAction();
				m_resultText.setText(m_result);
			}
		});
		btnFourthInitialMoment.setBounds(300, 261, 127, 25);
		btnFourthInitialMoment.setText("Fourth Initial Moment");
		
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
				m_arrayOfValue = new double[size];
				
				if(m_type == 1)
				{
					TableItem[] tableItem ;
					tableItem = new TableItem[size];
					for(int i = 0; i < size; i++)
					{
						tableItem[i] = new TableItem(table, SWT.NONE);
					}		
					m_value = valueText.getText();
					String[] value = m_value.split("\\,");
					
					for(int i = 0; i < size; i++)
					{
						tableItem[i].setText(value[i]);
					}
				}else
				{
					m_arrayOfProbability = new double[size];
					
					table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
					table_1.setBounds(150, 180, 103, 249);
					table_1.setHeaderVisible(true);
					table_1.setLinesVisible(true);
					
					TableColumn tblclmnProbability = new TableColumn(table_1, SWT.NONE);
					tblclmnProbability.setWidth(100);
					tblclmnProbability.setText("Probability");	
					
					TableItem[] tableItem ;
					TableItem[] tableItem_1 ;
					tableItem = new TableItem[size];
					tableItem_1 = new TableItem[size];
					
					for(int i = 0; i < size; i++)
					{
						tableItem[i] = new TableItem(table, SWT.NONE);
						tableItem_1[i] = new TableItem(table_1, SWT.NONE);
					}		
					m_value = valueText.getText();
					m_probability = probabilityText.getText();
					
					String[] value = m_value.split("\\,");
					String[] probability = m_probability.split("\\,");
					
					for(int i = 0; i < size; i++)
					{
						tableItem[i].setText(value[i]);
						tableItem_1[i].setText(probability[i]);
						
					}				
					
				}
			
			}
		});
		
		ButtonOk.setBounds(365, 69, 55, 23);
		ButtonOk.setText("Ok");		
		
		Button btnThirdInitialMoment = new Button(shell, SWT.NONE);
		btnThirdInitialMoment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String[] value = m_value.split("\\,");
				m_arrayOfValue = new double[size];
				for(int i = 0; i < size; i++)
				{
					m_arrayOfValue[i] = Double.parseDouble(value[i]);
				}
				m_handler.processThirdInitialMomentAction();
				m_resultText.setText(m_result);
			}
		});
		btnThirdInitialMoment.setBounds(300, 230, 127, 25);
		btnThirdInitialMoment.setText("Third Initial Moment");
		
		Button btnVariance = new Button(shell, SWT.NONE);
		btnVariance.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				String[] value = m_value.split("\\,");
				m_arrayOfValue = new double[size];
				for(int i = 0; i < size; i++)
				{
					m_arrayOfValue[i] = Double.parseDouble(value[i]);
				}
				m_handler.processVarianceAction();
				m_resultText.setText(m_result);
			}
		});
		btnVariance.setBounds(317, 195, 75, 25);
		btnVariance.setText("Variance");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table.setHeaderVisible(true);
		table.setBounds(42, 180, 103, 249);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Value");	
		
		
		Button btnExpectation = new Button(shell, SWT.NONE);
		btnExpectation.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e)
			{			
				String[] value = m_value.split("\\,");
				m_arrayOfValue = new double[size];
				for(int i = 0; i < size; i++)
				{
					m_arrayOfValue[i] = Double.parseDouble(value[i]);
				}
				m_handler.processExpectationAction();
				m_resultText.setText(m_result);				
			}
		});
		btnExpectation.setBounds(317, 164, 75, 25);
		btnExpectation.setText("Expectation");
		
		probabilityText = new Text(shell, SWT.BORDER);
		probabilityText.setBounds(260, 97, 76, 19);
		
		valueText = new Text(shell, SWT.BORDER);
		valueText.setBounds(260, 70, 76, 21);


	}
}
