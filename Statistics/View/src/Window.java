
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
	private Text m_valueText;
	private Text m_probabilityText;
	private Table table_1;
	public TableItem[] tableItem;
	public TableItem[] tableItem_1;


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
		shell.setSize(950, 700);
		shell.setText("SWT Application");
	
		Button btnFourthCentralMoment = new Button(shell, SWT.NONE);
		btnFourthCentralMoment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				if(m_type == - 1)
				{				
					String[] value = m_value.split("\\,");	
					String[] probability = m_probability.split("\\,");
					m_arrayOfValue = new double[size];
					m_arrayOfProbability = new double[size];
				
					for(int i = 0; i < size; i++)
					{
						m_arrayOfValue[i] = Double.parseDouble(value[i]);
						m_arrayOfProbability[i] = Double.parseDouble(probability[i]);
					}
					m_handler.processFourthCentralMomentAction();
					m_resultText.setText(m_result);
				} else
					m_resultText.setText("0.0");
			}
		});
		btnFourthCentralMoment.setBounds(342, 294, 140, 25);
		btnFourthCentralMoment.setText("Fourth Central Moment");
		
		Button btnSkewness = new Button(shell, SWT.NONE);
		btnSkewness.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				if(m_type == - 1)
				{				
					String[] value = m_value.split("\\,");	
					String[] probability = m_probability.split("\\,");
					m_arrayOfValue = new double[size];
					m_arrayOfProbability = new double[size];
				
					for(int i = 0; i < size; i++)
					{
						m_arrayOfValue[i] = Double.parseDouble(value[i]);
						m_arrayOfProbability[i] = Double.parseDouble(probability[i]);
					}
					m_handler.processSkewnessAction();
					m_resultText.setText(m_result);
				} else
					m_resultText.setText("0.0");
			}
		});
		btnSkewness.setBounds(345, 325, 127, 25);
		btnSkewness.setText("Skewness");
		
		Button btnExcess = new Button(shell, SWT.NONE);
		btnExcess.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				if(m_type == - 1)
				{	
					m_handler.processParseArgumentAction();
					m_handler.processExcessAction();
					m_resultText.setText(m_result);
				} else
					m_resultText.setText("0.0");
			}
		});
		btnExcess.setBounds(345, 354, 127, 25);
		btnExcess.setText("Excess");
		
		m_sizeText = new Text(shell, SWT.BORDER);
		m_sizeText.setBounds(466, 15, 49, 21);
		
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
		
				
		Button ButtonOk = new Button(shell, SWT.NONE);
		ButtonOk.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_size = m_sizeText.getText();
				size = Integer.parseInt(m_size);
				m_arrayOfValue = new double[size];
				m_value = m_valueText.getText();
				
				if(m_type == 1)
				{
					tableItem = new TableItem[size];
					for(int i = 0; i < size; i++)
					{
						tableItem[i] = new TableItem(table, SWT.NONE);
						tableItem[i].setText(new String[] { "number " + i, "" });
						TableItem item = new TableItem(table, SWT.NONE);
		    			 item.setText(new String[] { "item " + i, "edit this value" });
						
					}		
					
					m_handler.processParseArgumentAction();
					
					for(int i = 0; i < size; i++)
					{
						tableItem[i].setText(value[i]);
					}
				}else
				{
					m_arrayOfProbability = new double[size];				
					
					tableItem = new TableItem[size];
					tableItem_1 = new TableItem[size];
					
					for(int i = 0; i < size; i++)
					{
						tableItem[i] = new TableItem(table, SWT.NONE);
						tableItem_1[i] = new TableItem(table_1, SWT.NONE);
					}		
				
					m_probability = m_probabilityText.getText();					
					m_handler.processParseArgumentAction();
					
					for(int i = 0; i < size; i++)
					{
						tableItem[i].setText(value[i]);
						tableItem_1[i].setText(probability[i]);						
					}						
				}			
			}
		});
		
		ButtonOk.setBounds(605, 42, 55, 23);
		ButtonOk.setText("Ok");		
		
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
		lblAdd.setBounds(240, 18, 127, 15);
		lblAdd.setText("Enter numbers of value :");
		
		Label lblChoose_1 = new Label(shell, SWT.NONE);
		lblChoose_1.setBounds(345, 120, 170, 13);
		lblChoose_1.setText("Choose numerical characteristics :");
		
		
		Button btnExpectation = new Button(shell, SWT.NONE);
		btnExpectation.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e)
			{	
				m_handler.processParseArgumentAction();				
				m_handler.processExpectationAction();
				m_resultText.setText(m_result);				
			}
		});
		btnExpectation.setBounds(345, 139, 127, 25);
		btnExpectation.setText("Expectation");
		
		Button btnVariance = new Button(shell, SWT.NONE);
		btnVariance.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_handler.processParseArgumentAction();	
				m_handler.processVarianceAction();
				m_resultText.setText(m_result);
			}
		});
		btnVariance.setBounds(345, 170, 127, 25);
		btnVariance.setText("Variance");
		
		Button btnThirdInitialMoment = new Button(shell, SWT.NONE);
		btnThirdInitialMoment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_handler.processParseArgumentAction();
				m_handler.processThirdInitialMomentAction();
				m_resultText.setText(m_result);
			}
		});
		btnThirdInitialMoment.setBounds(345, 201, 127, 25);
		btnThirdInitialMoment.setText("Third Initial Moment");
		
		Button btnThirdCentralMoment = new Button(shell, SWT.NONE);
		btnThirdCentralMoment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				if(m_type == - 1)
				{				
					m_handler.processParseArgumentAction();
					m_handler.processThirdCentralMomentAction();
					m_resultText.setText(m_result);
				} else
					m_resultText.setText("0.0");
			}
		});
		btnThirdCentralMoment.setBounds(345, 232, 127, 25);
		btnThirdCentralMoment.setText("Third Central Moment");
		
		Button btnFourthInitialMoment = new Button(shell, SWT.NONE);
		btnFourthInitialMoment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_handler.processParseArgumentAction();
				m_handler.processFourthInitialMomentAction();
				m_resultText.setText(m_result);
			}
		});
		btnFourthInitialMoment.setBounds(345, 263, 127, 25);
		btnFourthInitialMoment.setText("Fourth Initial Moment");
		
		Label lblResult = new Label(shell, SWT.NONE);
		lblResult.setBounds(504, 178, 38, 13);
		lblResult.setText("Result:");
		
		m_resultText = new Text(shell, SWT.BORDER);
		m_resultText.setBounds(548, 175, 76, 19);
		
	/*	table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setBounds(25, 120, 104, 249);
		table.setLinesVisible(true);
		
		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setWidth(37);
		column1.setText("number");
		
		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setWidth(75);
		column2.setText("Value");	*/
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 108, 170, 334);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setWidth(65);
		column1.setText("New Column");
		
		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setWidth(100);
		column2.setText("New Column");
		
		column1.pack();
	    column2.pack();
		
		// add TableEditor
		final TableEditor editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.CENTER;
		editor.grabHorizontal = true;
		editor.minimumWidth = 250;
		final int EDITABLECOLUMN = 1;
		
		table.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent e) {
		        // Clean up any previous editor control
		        Control oldEditor = editor.getEditor();
		        if (oldEditor != null)
		          oldEditor.dispose();

		        // Identify the selected row
		        TableItem item = (TableItem) e.item;
		        if (item == null)
		          return;

		        // The control that will be the editor must be a child of the Table
		        Text newEditor = new Text(table, SWT.NONE);
		        newEditor.setText(item.getText(EDITABLECOLUMN));
		        newEditor.addModifyListener(new ModifyListener() {
		          public void modifyText(ModifyEvent me) {
		            Text text = (Text) editor.getEditor();
		            editor.getItem().setText(EDITABLECOLUMN, text.getText());
		          }
		        });
		        newEditor.selectAll();
		        newEditor.setFocus();
		        editor.setEditor(newEditor, item, EDITABLECOLUMN);
		      }
		    });
		
		shell.setSize(700, 700);
	    shell.open();
		
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(186, 108, 104, 334);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnProbability = new TableColumn(table_1, SWT.NONE);
		tblclmnProbability.setWidth(100);
		tblclmnProbability.setText("Probability");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(240, 73, 125, 13);
		lblNewLabel.setText("Enter the probabilities:");
		
		m_probabilityText = new Text(shell, SWT.BORDER);
		m_probabilityText.setBounds(466, 71, 109, 19);
		
		Label lblEnterValues = new Label(shell, SWT.NONE);
		lblEnterValues.setBounds(240, 47, 210, 13);
		lblEnterValues.setText("Enter the values(separated by commas):");
		
		m_valueText = new Text(shell, SWT.BORDER);
		m_valueText.setBounds(466, 45, 109, 21);
		
		Button btnClear = new Button(shell, SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				m_handler.processClearAction();
				
				m_sizeText.setText(m_size);
				m_valueText.setText(m_value);
				m_probabilityText.setText(m_probability);	
				m_resultText.setText(m_result);
			
				for(int i = 0; i < size; i++)
				{
					table.remove(0);
					if(m_type == -1)
					{
						table_1.remove(0);						
					}					
				}				
			}
		});
		btnClear.setBounds(42, 476, 75, 25);
		btnClear.setText("Clear");

	}
}
