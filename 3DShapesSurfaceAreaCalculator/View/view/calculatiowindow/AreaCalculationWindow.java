package view.calculatiowindow;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import presentation.source.IActionHandler;
import presentation.source.IView;
import presentation.source.Presenter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class AreaCalculationWindow implements IView
{

	protected Shell shldSolidArea;
	private Text m_textRadius;
	private Text m_textHeight;
	private Text m_textResult;
	private IActionHandler m_cubeAreaHandler;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			AreaCalculationWindow window = new AreaCalculationWindow();
			new Presenter(window);
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
		shldSolidArea.open();
		shldSolidArea.layout();
		while (!shldSolidArea.isDisposed())
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
		shldSolidArea = new Shell();
		shldSolidArea.setSize(450, 346);
		shldSolidArea.setText("3D Shapes Area Calculator 1.0");
		
		Button btnNewButton = new Button(shldSolidArea, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_cubeAreaHandler.processAction();
			}
		});
		btnNewButton.setBounds(65, 179, 68, 23);
		btnNewButton.setText("Calculate");
		
		Label lblConeRadius = new Label(shldSolidArea, SWT.NONE);
		lblConeRadius.setBounds(53, 51, 73, 13);
		lblConeRadius.setText("Cone Radius:");
		
		Label lblConeHeight = new Label(shldSolidArea, SWT.NONE);
		lblConeHeight.setBounds(53, 90, 59, 13);
		lblConeHeight.setText("Cone Height");
		
		m_textRadius = new Text(shldSolidArea, SWT.BORDER);
		m_textRadius.setBounds(146, 51, 76, 23);
		
		m_textHeight = new Text(shldSolidArea, SWT.BORDER);
		m_textHeight.setBounds(146, 87, 76, 23);
		
		m_textResult = new Text(shldSolidArea, SWT.BORDER);
		m_textResult.setBounds(146, 181, 118, 19);

	}

	@Override
	public String getConeRadius()
	{
		return m_textRadius.getText();
	}

	@Override
	public String getConeHeight()
	{
		
		return m_textHeight.getText();
	}

	@Override
	public String getCubeEdgeLength()
	{
		return null;
	}

	@Override
	public String getCylinderRadius()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCylinderHeight()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSphereRadius()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSquareBasedPyramidBaseLength()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSquareBasedPyramidBaseHeight()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTorusMinorRadius()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTorusMajorRadius()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCalculatedAreaResult(String area)
	{
			m_textResult.setText(area);
	}

	@Override
	public void setCalculateConeAreaActionHandler(IActionHandler handler)
	{
		m_cubeAreaHandler = handler;
		
	}

	@Override
	public void setCalculateCubeAreaActionHandler(IActionHandler handler)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCalculateCylinderAreaActionHandler(IActionHandler handler)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCalculateSphereAreaActionHandler(IActionHandler handler)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCalculateSquareBasedPyramidAreaActionHandler(
			IActionHandler handler)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCalculateTorusAreaActionHandler(IActionHandler handler)
	{
		// TODO Auto-generated method stub
		
	}
}
