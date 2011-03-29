package src.calculationwindow;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;


import src.IActionHandler;
import src.IView;
import src.Presenter;


public class AreaCalculationWindow implements IView
{

	protected Shell shldSolidArea;
	private Text m_minorRadiusText;
	private Text m_majorRadiusText;
	private Text m_cubeEdgelengthText;
	private Text m_cylinderRadiusText;
	private Text m_cylinderHeightText;
	private Text m_SphereRadiusText;
	private Text m_m_pyramidBaselengthText;
	private Text m_pyramidHeightText;
	private Text m_coneRadiusText;
	private Text m_coneHeightText;
	private Text m_areaResultText;
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
		shldSolidArea.setImage(SWTResourceManager.getImage("C:\\Documents and Settings\\mbuyu\\Desktop\\Cube_Icon_by_ekamanganese.jpg"));
		shldSolidArea.setToolTipText("");
		shldSolidArea.setSize(370, 326);
		shldSolidArea.setText("3D Shapes Area Calculator 1.0");
		shldSolidArea.setLayout(null);
		
		TabFolder tabFolder = new TabFolder(shldSolidArea, SWT.NONE);
		tabFolder.setBounds(10, 10, 353, 180);
		
		TabItem tbtmCone = new TabItem(tabFolder, SWT.NONE);
		tbtmCone.setText("Cone");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmCone.setControl(composite);
		
		m_coneRadiusText = new Text(composite, SWT.BORDER);
		m_coneRadiusText.setBounds(108, 26, 122, 19);
		
		m_coneHeightText = new Text(composite, SWT.BORDER);
		m_coneHeightText.setBounds(108, 65, 122, 19);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(28, 29, 49, 13);
		lblNewLabel.setText("Radius :");
		
		Label lblHeight_1 = new Label(composite, SWT.NONE);
		lblHeight_1.setBounds(28, 68, 49, 13);
		lblHeight_1.setText("Height:");
		
		TabItem tbtmCube = new TabItem(tabFolder, SWT.NONE);
		tbtmCube.setText("Cube");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmCube.setControl(composite_1);
		
		m_cubeEdgelengthText = new Text(composite_1, SWT.BORDER);
		m_cubeEdgelengthText.setBounds(115, 55, 109, 19);
		
		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setBounds(29, 58, 68, 13);
		lblNewLabel_2.setText("Edge length:");
		
		TabItem tbtmCylinder = new TabItem(tabFolder, SWT.NONE);
		tbtmCylinder.setText("Cylinder");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmCylinder.setControl(composite_2);
		
		m_cylinderRadiusText = new Text(composite_2, SWT.BORDER);
		m_cylinderRadiusText.setBounds(91, 44, 123, 19);
		
		m_cylinderHeightText = new Text(composite_2, SWT.BORDER);
		m_cylinderHeightText.setBounds(91, 84, 123, 19);
		
		Label lblNewLabel_3 = new Label(composite_2, SWT.NONE);
		lblNewLabel_3.setBounds(29, 47, 56, 13);
		lblNewLabel_3.setText(" Radius:");
		
		Label lblHeight = new Label(composite_2, SWT.NONE);
		lblHeight.setBounds(36, 87, 49, 13);
		lblHeight.setText("Height:");
		
		TabItem tbtmSphere = new TabItem(tabFolder, SWT.NONE);
		tbtmSphere.setText("Sphere");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmSphere.setControl(composite_3);
		
		m_SphereRadiusText = new Text(composite_3, SWT.BORDER);
		m_SphereRadiusText.setBounds(75, 42, 135, 19);
		
		Label lblRadius = new Label(composite_3, SWT.NONE);
		lblRadius.setBounds(20, 45, 49, 13);
		lblRadius.setText("Radius:");
		
		TabItem tbtmSquarebasedpyramid = new TabItem(tabFolder, SWT.NONE);
		tbtmSquarebasedpyramid.setText("SquareBasedPyramid");
		
		Composite composite_4 = new Composite(tabFolder, SWT.NONE);
		tbtmSquarebasedpyramid.setControl(composite_4);
		
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
		
		TabItem tbtmTorus = new TabItem(tabFolder, SWT.NONE);
		tbtmTorus.setText("Torus");
		
		Composite composite_5 = new Composite(tabFolder, SWT.NONE);
		tbtmTorus.setControl(composite_5);
		
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
		
		Button btnCalculateArea = new Button(shldSolidArea, SWT.NONE);
		btnCalculateArea.setBounds(35, 233, 92, 23);
		btnCalculateArea.setText("Calculate Area");
		
		m_areaResultText = new Text(shldSolidArea, SWT.BORDER);
		m_areaResultText.setBounds(164, 235, 156, 19);

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
	public boolean coneIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cubeIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cylinderIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sphereIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean squarePyramidIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean torusIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setErrorMessage(String message)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCalculateButtonEnabled()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCalculateAreaActionHandler(IActionHandler handler)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCalculatedAreaResult(String area)
	{
		// TODO Auto-generated method stub
		
	}
}
