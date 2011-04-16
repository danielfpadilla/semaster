package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import Presentation.IActionHandler;
import Presentation.Iview;
import Presentation.Presenter;



public class SortingWindow implements Iview
{

	
	protected Shell shell;
	private Text m_unsortedArray;
	private Text m_sortedArray;
	private Text m_arrayElements;
	public IActionHandler m_arrayGeneratorHandler;
	public IActionHandler m_arraySizeHandler;
	private Text text;
	private Text txtArraySize;
	private IActionHandler m_sortArrayHandler;
	private String m_SortingMethod;


	public static void main1(String[] args)
	{
		try
		{
			SortingWindow window = new SortingWindow();
			new Presenter(window);
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			SortingWindow window = new SortingWindow();
			window.open();
		} catch (Exception e)
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
		shell.setSize(396, 300);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(21, 69, 227, 19);
		
		Button btnMergeSort = new Button(shell, SWT.RADIO);
		btnMergeSort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnMergeSort.setBounds(21, 116, 83, 16);
		btnMergeSort.setText("Merge Sort");
		
		Button btnQuickSort = new Button(shell, SWT.RADIO);
		btnQuickSort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnQuickSort.setBounds(136, 116, 83, 16);
		btnQuickSort.setText("Quick Sort");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setBounds(42, 144, 123, 23);
		btnNewButton_1.setText("Generate Randon Array");
		
		Button btnStartSorting = new Button(shell, SWT.NONE);
		btnStartSorting.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				m_sortArrayHandler.processAction();
			}
		});
		btnStartSorting.setBounds(44, 195, 145, 23);
		btnStartSorting.setText("Start Sorting");
		
		Label lblEnterSizeOf = new Label(shell, SWT.NONE);
		lblEnterSizeOf.setBounds(21, 23, 109, 13);
		lblEnterSizeOf.setText("Enter Array Size :");
		
		Label lblChooseSortingMethod = new Label(shell, SWT.NONE);
		lblChooseSortingMethod.setBounds(21, 94, 123, 13);
		lblChooseSortingMethod.setText("Choose Sorting Method:");
		
		txtArraySize = new Text(shell, SWT.BORDER);
		txtArraySize.setText("Array size");
		txtArraySize.setBounds(136, 20, 86, 19);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(20, 52, 84, 13);
		lblNewLabel.setText("Sort Result");

	}

	@Override
	public String getUnsortedArray()
	{
		return null;
	}

	@Override
	public void setUnsortedArray(String unsortedArray)
	{
	  m_unsortedArray.setText(unsortedArray);
		
	}

	@Override
	public boolean mergeSortIsSelected()
	{
		return true;
	}

	@Override
	public boolean quickSortIsSelected()
	{
		return false;
	}

	@Override
	public void setSortedArray(String sortedArray)
	{
		m_sortedArray.setText(sortedArray);
		
	}

	@Override
	public String getArraySize()
	{
		return m_arrayElements.getText();
	}

	@Override
	public void generateRandomArray(IActionHandler handler)
	{
		m_arrayGeneratorHandler = handler;
		
	}

	@Override
	public void selectedArraySize(IActionHandler handler)
	{
		m_arraySizeHandler = handler;
	}

	@Override
	public void sortArray(IActionHandler handler)
	{
	  m_sortArrayHandler = handler;
		
	}

	@Override
	public String getSortingMethod()
	{
		
		return m_SortingMethod; 
	}
}


	

