package view.calculatiowindow;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import presentation.source.IActionHandler;
import presentation.source.IView;
import presentation.source.Presenter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


public class AreaCalculationWindow implements IView
{

	protected Shell shldSolidArea;
	private Text m_minorRadiusText;
	private Text m_majorRadiusText;
	private Text m_torusAreaText;
	private Text m_coneRadiusText;
	private Text m_coneHeightText;
	private Text m_coneAreaText;
	private Text m_cubeEdgelengthText;
	private Text m_cubeAreaText;
	private Text m_cylinderRadiusText;
	private Text m_cylinderHeightText;
	private Text m_cylinderAreaText;
	private Text m_SphereRadiusText;
	private Text m_sphereAreaText;
	private Text m_m_pyramidBaselengthText;
	private Text m_pyramidHeightText;
	private Text m_pyramidResultText;
	//private IActionHandler m_cubeAreaHandler;
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
		shldSolidArea.setSize(370, 305);
		shldSolidArea.setText("3D Shapes Area Calculator 1.0");
		shldSolidArea.setLayout(null);
		
		TabFolder tabFolder = new TabFolder(shldSolidArea, SWT.NONE);
		tabFolder.setBounds(10, 10, 353, 261);
		
		TabItem tbtmCone = new TabItem(tabFolder, SWT.NONE);
		tbtmCone.setText("Cone");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmCone.setControl(composite);
		
		Button btnCalculateConeArea = new Button(composite, SWT.NONE);
		btnCalculateConeArea.setBounds(10, 133, 68, 23);
		btnCalculateConeArea.setText("Calculate");
		
		m_coneRadiusText = new Text(composite, SWT.BORDER);
		m_coneRadiusText.setBounds(83, 26, 127, 19);
		
		m_coneHeightText = new Text(composite, SWT.BORDER);
		m_coneHeightText.setBounds(83, 65, 127, 19);
		
		m_coneAreaText = new Text(composite, SWT.BORDER);
		m_coneAreaText.setBounds(102, 135, 153, 19);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(20, 29, 49, 13);
		lblNewLabel.setText("Radius:");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(20, 68, 49, 13);
		lblNewLabel_1.setText("Height:");
		
		TabItem tbtmCube = new TabItem(tabFolder, SWT.NONE);
		tbtmCube.setText("Cube");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmCube.setControl(composite_1);
		
		m_cubeEdgelengthText = new Text(composite_1, SWT.BORDER);
		m_cubeEdgelengthText.setBounds(115, 55, 109, 19);
		
		m_cubeAreaText = new Text(composite_1, SWT.BORDER);
		m_cubeAreaText.setBounds(115, 124, 171, 19);
		
		Button btnCalculateCubeArea = new Button(composite_1, SWT.NONE);
		btnCalculateCubeArea.setBounds(29, 122, 68, 23);
		btnCalculateCubeArea.setText("Calculate");
		
		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setBounds(29, 58, 68, 13);
		lblNewLabel_2.setText("Edge length:");
		
		TabItem tbtmCylinder = new TabItem(tabFolder, SWT.NONE);
		tbtmCylinder.setText("Cylinder");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmCylinder.setControl(composite_2);
		
		Button btnCalculateCylinderArea = new Button(composite_2, SWT.NONE);
		btnCalculateCylinderArea.setBounds(35, 170, 68, 23);
		btnCalculateCylinderArea.setText("Calculate");
		
		m_cylinderRadiusText = new Text(composite_2, SWT.BORDER);
		m_cylinderRadiusText.setBounds(120, 44, 123, 19);
		
		m_cylinderHeightText = new Text(composite_2, SWT.BORDER);
		m_cylinderHeightText.setBounds(120, 84, 123, 19);
		
		m_cylinderAreaText = new Text(composite_2, SWT.BORDER);
		m_cylinderAreaText.setBounds(146, 174, 156, 19);
		
		Label lblNewLabel_3 = new Label(composite_2, SWT.NONE);
		lblNewLabel_3.setBounds(47, 44, 56, 13);
		lblNewLabel_3.setText(" Radius:");
		
		Label lblHeight = new Label(composite_2, SWT.NONE);
		lblHeight.setBounds(54, 84, 49, 13);
		lblHeight.setText("Height:");
		
		TabItem tbtmSphere = new TabItem(tabFolder, SWT.NONE);
		tbtmSphere.setText("Sphere");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmSphere.setControl(composite_3);
		
		m_SphereRadiusText = new Text(composite_3, SWT.BORDER);
		m_SphereRadiusText.setBounds(168, 42, 76, 19);
		
		m_sphereAreaText = new Text(composite_3, SWT.BORDER);
		m_sphereAreaText.setBounds(126, 116, 137, 19);
		
		Button btnCalculateSphereArea = new Button(composite_3, SWT.NONE);
		btnCalculateSphereArea.setBounds(21, 114, 68, 23);
		btnCalculateSphereArea.setText("Calculate");
		
		Label lblRadius = new Label(composite_3, SWT.NONE);
		lblRadius.setBounds(40, 42, 49, 13);
		lblRadius.setText("Radius:");
		
		TabItem tbtmSquarebasedpyramid = new TabItem(tabFolder, SWT.NONE);
		tbtmSquarebasedpyramid.setText("SquareBasedPyramid");
		
		Composite composite_4 = new Composite(tabFolder, SWT.NONE);
		tbtmSquarebasedpyramid.setControl(composite_4);
		
		Button btnCalculatePyramidArea = new Button(composite_4, SWT.NONE);
		btnCalculatePyramidArea.setBounds(29, 120, 68, 23);
		btnCalculatePyramidArea.setText("Calculate");
		
		Label lblNewLabel_4 = new Label(composite_4, SWT.NONE);
		lblNewLabel_4.setBounds(36, 75, 49, 13);
		lblNewLabel_4.setText("Height:");
		
		Label lblNewLabel_5 = new Label(composite_4, SWT.NONE);
		lblNewLabel_5.setBounds(29, 33, 68, 13);
		lblNewLabel_5.setText("BaseLength:");
		
		m_m_pyramidBaselengthText = new Text(composite_4, SWT.BORDER);
		m_m_pyramidBaselengthText.setBounds(113, 30, 132, 19);
		
		m_pyramidHeightText = new Text(composite_4, SWT.BORDER);
		m_pyramidHeightText.setBounds(116, 75, 129, 19);
		
		m_pyramidResultText = new Text(composite_4, SWT.BORDER);
		m_pyramidResultText.setBounds(116, 124, 152, 19);
		
		TabItem tbtmTorus = new TabItem(tabFolder, SWT.NONE);
		tbtmTorus.setText("Torus");
		
		Composite composite_5 = new Composite(tabFolder, SWT.NONE);
		tbtmTorus.setControl(composite_5);
		
		Button btnCalculateTorusArea = new Button(composite_5, SWT.NONE);
		btnCalculateTorusArea.setBounds(40, 145, 68, 23);
		btnCalculateTorusArea.setText("Calculate");
		
		Label lblMajorRadius = new Label(composite_5, SWT.NONE);
		lblMajorRadius.setBounds(26, 30, 68, 13);
		lblMajorRadius.setText("Minor radius :");
		
		Label lblMajorRadius_1 = new Label(composite_5, SWT.NONE);
		lblMajorRadius_1.setBounds(26, 69, 68, 13);
		lblMajorRadius_1.setText("Major radius :");
		
		m_minorRadiusText = new Text(composite_5, SWT.BORDER);
		m_minorRadiusText.setBounds(137, 30, 121, 19);
		
		m_majorRadiusText = new Text(composite_5, SWT.BORDER);
		m_majorRadiusText.setBounds(137, 69, 121, 19);
		
		m_torusAreaText = new Text(composite_5, SWT.BORDER);
		m_torusAreaText.setBounds(137, 147, 164, 19);

	}

	@Override
	public String getConeRadius()
	{
	  return null;
	}

	@Override
	public String getConeHeight()
	{
		
		return null;
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
			//m_textResult.setText(area);
	}

	@Override
	public void setCalculateConeAreaActionHandler(IActionHandler handler)
	{
		//m_cubeAreaHandler = handler;
		
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
