package applicationwindow.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

import figurearea.presentation.*;
import org.eclipse.wb.swt.SWTResourceManager;

public class AreaCalculationWindow implements IView
{
	Display display = new Display();
	private Label m_lblErrorIcon;
	protected Shell m_shldSolidArea;
	private Text m_torusMinorRadiusText;
	private Text m_torusMajorRadiusText;
	private Text m_cubeEdgelengthText;
	private Text m_cylinderRadiusText;
	private Text m_cylinderHeightText;
	private Text m_sphereRadiusText;
	private Text m_pyramidBaselengthText;
	private Text m_pyramidHeightText;
	private Text m_coneRadiusText;
	private Text m_coneHeightText;
	private Text m_areaResultText;
	private TabFolder m_tabFolder;
	private IActionHandler m_figureAreaHandler;
	private IActionHandler m_processInputHandler;
	private Label m_lblErrorMessage;
	Button m_btnCalculateArea;
	
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
	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		m_shldSolidArea.open();
		m_shldSolidArea.layout();
		while (!m_shldSolidArea.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}
	protected void createContents()
	{

		m_shldSolidArea = new Shell();
		m_shldSolidArea.setImage(SWTResourceManager.getImage(AreaCalculationWindow.class, "/javax/swing/plaf/basic/icons/JavaCup16.png"));
		m_shldSolidArea.setToolTipText("");
		m_shldSolidArea.setSize(370, 326);
		m_shldSolidArea.setText("3D Shapes Area Calculator 1.0");
		m_shldSolidArea.setLayout(null);

		m_tabFolder = new TabFolder(m_shldSolidArea, SWT.NONE);
		m_tabFolder.setBounds(10, 10, 353, 180);
		m_tabFolder.setSelection(0);
		TabItem cone = new TabItem(m_tabFolder, SWT.NONE);
		cone.setText("Cone");
		Composite composite = new Composite(m_tabFolder, SWT.NONE);
		cone.setControl(composite);
		ModifyListener listener = new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				m_processInputHandler.processAction();

			}

		};

		m_coneRadiusText = new Text(composite, SWT.BORDER);
		m_coneRadiusText.setBounds(108, 26, 122, 19);
		m_coneRadiusText.addModifyListener(listener);

		m_coneHeightText = new Text(composite, SWT.BORDER);
		m_coneHeightText.setBounds(108, 65, 122, 19);
		m_coneHeightText.addModifyListener(listener);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(28, 29, 49, 13);
		lblNewLabel.setText("Radius :");

		Label lblHeight_1 = new Label(composite, SWT.NONE);
		lblHeight_1.setBounds(28, 68, 49, 13);
		lblHeight_1.setText("Height:");

		TabItem cube = new TabItem(m_tabFolder, SWT.NONE);
		cube.setText("Cube");

		Composite composite_1 = new Composite(m_tabFolder, SWT.NONE);
		cube.setControl(composite_1);

		m_cubeEdgelengthText = new Text(composite_1, SWT.BORDER);
		m_cubeEdgelengthText.setBounds(115, 55, 109, 19);
		m_cubeEdgelengthText.addModifyListener(listener);

		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setBounds(29, 58, 68, 13);
		lblNewLabel_2.setText("Edge length:");

		TabItem cylinder = new TabItem(m_tabFolder, SWT.NONE);
		cylinder.setText("Cylinder");

		Composite composite_2 = new Composite(m_tabFolder, SWT.NONE);
		cylinder.setControl(composite_2);

		m_cylinderRadiusText = new Text(composite_2, SWT.BORDER);
		m_cylinderRadiusText.setBounds(91, 44, 123, 19);
		m_cylinderRadiusText.addModifyListener(listener);

		m_cylinderHeightText = new Text(composite_2, SWT.BORDER);
		m_cylinderHeightText.setBounds(91, 84, 123, 19);
		m_cylinderHeightText.addModifyListener(listener);

		Label lblNewLabel_3 = new Label(composite_2, SWT.NONE);
		lblNewLabel_3.setBounds(29, 47, 56, 13);
		lblNewLabel_3.setText(" Radius:");

		Label lblHeight = new Label(composite_2, SWT.NONE);
		lblHeight.setBounds(36, 87, 49, 13);
		lblHeight.setText("Height:");

		TabItem sphere = new TabItem(m_tabFolder, SWT.NONE);
		sphere.setText("Sphere");

		Composite composite_3 = new Composite(m_tabFolder, SWT.NONE);
		sphere.setControl(composite_3);

		m_sphereRadiusText = new Text(composite_3, SWT.BORDER);
		m_sphereRadiusText.setBounds(75, 42, 135, 19);
		m_sphereRadiusText.addModifyListener(listener);

		Label lblRadius = new Label(composite_3, SWT.NONE);
		lblRadius.setBounds(20, 45, 49, 13);
		lblRadius.setText("Radius:");

		TabItem squarebasedpyramid = new TabItem(m_tabFolder, SWT.NONE);
		squarebasedpyramid.setText("SquareBasedPyramid");

		Composite composite_4 = new Composite(m_tabFolder, SWT.NONE);
		squarebasedpyramid.setControl(composite_4);

		Label lblNewLabel_4 = new Label(composite_4, SWT.NONE);
		lblNewLabel_4.setBounds(36, 75, 49, 13);
		lblNewLabel_4.setText("Height:");

		Label lblNewLabel_5 = new Label(composite_4, SWT.NONE);
		lblNewLabel_5.setBounds(29, 33, 68, 13);
		lblNewLabel_5.setText("BaseLength:");

		m_pyramidBaselengthText = new Text(composite_4, SWT.BORDER);
		m_pyramidBaselengthText.setBounds(113, 30, 132, 19);
		m_pyramidBaselengthText.addModifyListener(listener);

		m_pyramidHeightText = new Text(composite_4, SWT.BORDER);
		m_pyramidHeightText.setBounds(116, 75, 129, 19);
		m_pyramidHeightText.addModifyListener(listener);

		TabItem torus = new TabItem(m_tabFolder, SWT.NONE);
		torus.setText("Torus");

		Composite composite_5 = new Composite(m_tabFolder, SWT.NONE);
		torus.setControl(composite_5);

		Label lblMajorRadius = new Label(composite_5, SWT.NONE);
		lblMajorRadius.setBounds(26, 30, 68, 13);
		lblMajorRadius.setText("Minor radius :");

		Label lblMajorRadius_1 = new Label(composite_5, SWT.NONE);
		lblMajorRadius_1.setBounds(26, 69, 68, 13);
		lblMajorRadius_1.setText("Major radius :");

		m_torusMinorRadiusText = new Text(composite_5, SWT.BORDER);
		m_torusMinorRadiusText.setBounds(137, 30, 121, 19);
		m_torusMinorRadiusText.addModifyListener(listener);

		m_torusMajorRadiusText = new Text(composite_5, SWT.BORDER);
		m_torusMajorRadiusText.setBounds(137, 69, 121, 19);
		m_torusMajorRadiusText.addModifyListener(listener);

		m_btnCalculateArea = new Button(m_shldSolidArea, SWT.NONE);

		m_btnCalculateArea.setEnabled(true);

		m_btnCalculateArea.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				m_figureAreaHandler.processAction();
			}
		});
		m_btnCalculateArea.setBounds(35, 233, 92, 23);
		m_btnCalculateArea.setText("Calculate Area");

		m_areaResultText = new Text(m_shldSolidArea, SWT.BORDER | SWT.READ_ONLY);
		m_areaResultText.setBounds(164, 235, 156, 19);

		m_lblErrorMessage = new Label(m_shldSolidArea, SWT.NONE);
		m_lblErrorMessage.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		m_lblErrorMessage.setText("Enter the parameters");
		m_lblErrorMessage.setToolTipText("");
		m_lblErrorMessage.setBounds(49, 200, 276, 19);

		m_lblErrorIcon = new Label(m_shldSolidArea, SWT.NONE);
		m_lblErrorIcon.setImage(SWTResourceManager.getImage(AreaCalculationWindow.class, "/com/sun/java/swing/plaf/windows/icons/Error.gif"));
		m_lblErrorIcon.setBounds(10, 196, 33, 31);
		m_lblErrorIcon.setVisible(false);

	}

	@Override
	public String getConeRadius()
	{
		return m_coneRadiusText.getText();
	}

	@Override
	public String getConeHeight()
	{

		return m_coneHeightText.getText();
	}

	@Override
	public String getCubeEdgeLength()
	{
		return m_cubeEdgelengthText.getText();
	}

	@Override
	public String getCylinderRadius()
	{
		return m_cylinderRadiusText.getText();
	}

	@Override
	public String getCylinderHeight()
	{
		return m_cylinderHeightText.getText();
	}

	@Override
	public String getSphereRadius()
	{
		return m_sphereRadiusText.getText();
	}

	@Override
	public String getSquareBasedPyramidBaseLength()
	{
		return m_pyramidBaselengthText.getText();
	}

	@Override
	public String getSquareBasedPyramidBaseHeight()
	{
		return m_pyramidHeightText.getText();
	}

	@Override
	public String getTorusMinorRadius()
	{
		return m_torusMinorRadiusText.getText();
	}

	@Override
	public String getTorusMajorRadius()
	{
		return m_torusMajorRadiusText.getText();

	}

	@Override
	public boolean coneIsSelected()
	{
		return m_tabFolder.getSelection()[0].getText() == "Cone";

	}

	@Override
	public boolean cubeIsSelected()
	{
		return m_tabFolder.getSelection()[0].getText() == "Cube";
	}

	@Override
	public boolean cylinderIsSelected()
	{
		return m_tabFolder.getSelection()[0].getText() == "Cylinder";
	}

	@Override
	public boolean sphereIsSelected()
	{
		return m_tabFolder.getSelection()[0].getText() == "Sphere";
	}

	@Override
	public boolean squarePyramidIsSelected()
	{
		return m_tabFolder.getSelection()[0].getText() == "SquareBasedPyramid";
	}

	@Override
	public boolean torusIsSelected()
	{
		return m_tabFolder.getSelection()[0].getText() == "Torus";
	}

	@Override
	public void setErrorMessage(String message)
	{
		m_lblErrorMessage.setText(message);

	}

	@Override
	public void setCalculateAreaActionHandler(IActionHandler handler)
	{
		m_figureAreaHandler = handler;

	}

	@Override
	public void setCalculatedAreaResult(String area)
	{
		m_areaResultText.setText(area);

		m_areaResultText.clearSelection();
	}

	@Override
	public void setStateOfCalculateAreaButton(boolean flag)
	{
		m_btnCalculateArea.setEnabled(flag);
	}

	@Override
	public void processInputActionHandler(IActionHandler handler)
	{
		m_processInputHandler = handler;
	}

	@Override
	public void setStateOfErrorIcon(boolean flag)
	{
		m_lblErrorIcon.setVisible(flag);

	}
}