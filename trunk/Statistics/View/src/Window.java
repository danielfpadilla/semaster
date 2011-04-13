
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
import org.eclipse.wb.swt.SWTResourceManager;

public class Window extends View {

	protected  Shell shell;
	private Text m_resultText;
	private Text m_sizeText;
	private Table table;
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
		
		Button btnSkewness = new Button(shell, SWT.NONE);
		btnSkewness.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				if(m_type == - 1)
				{				
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
		btnSkewness.setBounds(345, 325, 140, 25);
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
		btnExcess.setBounds(345, 354, 140, 25);
		btnExcess.setText("Excess");
		
		m_sizeText = new Text(shell, SWT.BORDER);
		m_sizeText.setBounds(364, 14, 49, 21);
		
				
		Button ButtonOk = new Button(shell, SWT.NONE);
		ButtonOk.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_size = m_sizeText.getText();
				size = Integer.parseInt(m_size);
				
				if(m_type == 1)
				{
					tableItem = new TableItem[size + 1];
					
					for(int i = 0; i < size; i++)
					{
						tableItem[i] = new TableItem(table, SWT.NONE);
						tableItem[i].setText(" ");												
					}		
					
					tableItem[size] = new TableItem(table, SWT.NONE);
					tableItem[size].setText(" ");
					
				}else
				{					
					tableItem = new TableItem[size + 1];					
					tableItem_1 = new TableItem[size + 1];
					
					for(int i = 0; i < size; i++)
					{
						tableItem[i] = new TableItem(table, SWT.NONE);
						tableItem[i].setText(" ");
						tableItem_1[i] = new TableItem(table_1, SWT.NONE);
						tableItem_1[i].setText(" ");
					}	
					
					tableItem[size] = new TableItem(table, SWT.NONE);
					tableItem[size].setText(" ");
					tableItem_1[size] = new TableItem(table_1, SWT.NONE);
					tableItem_1[size].setText(" ");
											
				}			
			}
		});
		
		ButtonOk.setBounds(430, 12, 55, 23);
		ButtonOk.setText("Ok");		
		
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
		lblAdd.setBounds(240, 18, 127, 15);
		lblAdd.setText("Enter numbers of value :");
				
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
				btnThirdCentralMoment.setBounds(345, 232, 140, 25);
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
				btnFourthInitialMoment.setBounds(345, 263, 140, 25);
				btnFourthInitialMoment.setText("Fourth Initial Moment");
				
					Button btnFourthCentralMoment = new Button(shell, SWT.NONE);
					btnFourthCentralMoment.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) 
						{
							if(m_type == - 1)
							{				
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
					btnFourthCentralMoment.setBounds(345, 294, 140, 25);
					btnFourthCentralMoment.setText("Fourth Central Moment");
		
				table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.HIDE_SELECTION | SWT.VIRTUAL);
				table.setFont(SWTResourceManager.getFont("Tahoma", 8, SWT.NORMAL));
				table.setBounds(10, 108, 90, 334);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				TableColumn column1 = new TableColumn(table, SWT.NONE);
				column1.setWidth(80);
				column1.setText("value");
				
				table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
				table_1.setBounds(106, 108, 89, 334);
				table_1.setHeaderVisible(true);
				table_1.setLinesVisible(true);
				
				TableColumn tblclmnProbability = new TableColumn(table_1, SWT.NONE);
				tblclmnProbability.setWidth(80);
				tblclmnProbability.setText("Probability");
				
				// add TableEditor
				final TableEditor editor = new TableEditor(table);
				final TableEditor editor_1 = new TableEditor(table_1);
				
				editor.horizontalAlignment = SWT.LEFT;
				editor.grabHorizontal = true;
				editor.minimumWidth = 30;
				
				editor_1.horizontalAlignment = SWT.LEFT;
				editor_1.grabHorizontal = true;
				editor_1.minimumWidth = 30;
				
				final int EDITABLECOLUMN = 0;
				
				table.addSelectionListener(new SelectionAdapter() 
				{
				      public void widgetSelected(SelectionEvent e) 
				      {		      
				        Control oldEditor = editor.getEditor();
				        if (oldEditor != null)
				          oldEditor.dispose();

				        TableItem item = (TableItem) e.item;
				        if (item == null)
				          return;
				        
				        Text newEditor = new Text(table, SWT.NONE);
				        newEditor.setText(item.getText(EDITABLECOLUMN));
				        newEditor.addModifyListener(new ModifyListener() 
				        {
				          public void modifyText(ModifyEvent me) 
				          {
				            Text text = (Text) editor.getEditor();
				            editor.getItem().setText(EDITABLECOLUMN, text.getText());
				          }
				        });
				        newEditor.selectAll();
				        newEditor.setFocus();
				        editor.setEditor(newEditor, item, EDITABLECOLUMN);
				      }
				 });
				
				table_1.addSelectionListener(new SelectionAdapter() 
				{
				      public void widgetSelected(SelectionEvent e) 
				      {		      
				        Control oldEditor = editor.getEditor();
				        if (oldEditor != null)
				          oldEditor.dispose();

				        TableItem item = (TableItem) e.item;
				        if (item == null)
				          return;
				        
				        Text newEditor = new Text(table_1, SWT.NONE);
				        newEditor.setText(item.getText(EDITABLECOLUMN));
				        newEditor.addModifyListener(new ModifyListener() 
				        {
				          public void modifyText(ModifyEvent me) 
				          {
				            Text text = (Text) editor.getEditor();
				            editor.getItem().setText(EDITABLECOLUMN, text.getText());
				          }
				        });
				        newEditor.selectAll();
				        newEditor.setFocus();
				        editor.setEditor(newEditor, item, EDITABLECOLUMN);
				      }
				 });	
		

		
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
		btnExpectation.setBounds(345, 139, 140, 25);
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
		btnVariance.setBounds(345, 170, 140, 25);
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
		btnThirdInitialMoment.setBounds(345, 201, 140, 25);
		btnThirdInitialMoment.setText("Third Initial Moment");
		
		Label lblResult = new Label(shell, SWT.NONE);
		lblResult.setBounds(504, 178, 38, 13);
		lblResult.setText("Result:");
		
		m_resultText = new Text(shell, SWT.BORDER);
		m_resultText.setBounds(548, 175, 76, 19);

		
		shell.setSize(700, 700);
	    shell.open();
		
		Button btnAdd = new Button(shell, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				m_arrayOfValue = new double[size];								
				value = new String[size];						
				
				for(int i = 0; i < size; i++)
				{
					value[i] = tableItem[i].getText();
				}
				if(m_type == -1)
				{
					m_arrayOfProbability = new double[size];
					probability = new String[size];
					
					for(int i = 0; i < size; i++)
					{
						probability[i] = tableItem_1[i].getText();
					}
				}
				
				m_handler.processParseArgumentAction();
			}
		});
		btnAdd.setBounds(10, 455, 75, 25);
		btnAdd.setText("Add");
		
		Button btnClear = new Button(shell, SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				m_handler.processClearAction();
				
				m_sizeText.setText(m_size);
				m_resultText.setText(m_result);
			
				for(int i = 0; i < size + 1; i++)
				{
					table.remove(0);
					if(m_type == -1)
					{
						table_1.remove(0);						
					}					
				}				
			}
		});
		btnClear.setBounds(105, 455, 75, 25);
		btnClear.setText("Clear");

	}
}
