package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class SortingWindow
{

	protected Shell shell;
	private Text text;

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
		text.setBounds(21, 31, 227, 19);
		
		Button btnQuickSort = new Button(shell, SWT.NONE);
		btnQuickSort.setBounds(21, 92, 68, 23);
		btnQuickSort.setText("Quick Sort");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(187, 92, 68, 23);
		btnNewButton.setText("Merge Sort");

	}
}
