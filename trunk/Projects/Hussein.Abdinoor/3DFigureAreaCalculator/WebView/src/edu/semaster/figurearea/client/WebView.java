package edu.semaster.figurearea.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabBar.Tab;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.EntryPoint;

import edu.semaster.figurearea.presentation.IActionHandler;
import edu.semaster.figurearea.presentation.IView;
import edu.semaster.figurearea.presentation.Presenter;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class WebView extends Composite implements EntryPoint, IView
{
	Presenter m_presenter;
	//DecoratedTabPanel m_selectedTab = new DecoratedTabPanel();
	TabPanel m_selectedTab = new TabPanel();
	private static final Binder binder = GWT.create(Binder.class);
	@UiField TextBox m_coneRadius;
	@UiField TextBox m_coneHeight;
	@UiField TextBox m_cylinderRadius;
	@UiField TextBox m_cylinderHeight;
	@UiField TextBox m_pramidLength;
	@UiField TextBox m_pyramidHeight;
	@UiField TextBox m_torusMajorRadius;
	@UiField TextBox m_torusMinorRadius;
	@UiField TextBox m_sphereRadius;
	@UiField TextBox m_cubeFaceLength;
	@UiField TextBox m_areaResult;
	@UiField Button m_calculateAreaButton;
	private IActionHandler m_figureAreaHandler;
    // private IActionHandler m_processInputHandler;
	interface Binder extends UiBinder<Widget, WebView>
	{
	}

	public WebView()
	{
		initWidget(binder.createAndBindUi(this));
	}

	public void onModuleLoad()
	{
		RootPanel.get().add(this);
		m_presenter = new Presenter(this);
	}
	@Override
	public boolean coneIsSelected()
	{
		//return m_selectedTab.getTabBar().getSelectedTab() == 0;
	    return false;
		
	}

	@Override
	public boolean cubeIsSelected()
	{
		//return m_selectedTab.getStylePrimaryName() == "Cube";
		return false;
	}

	@Override
	public boolean cylinderIsSelected()
	{
		return m_selectedTab.getStylePrimaryName() =="Cylinder";
		//return true;
	}

	@Override
	public boolean sphereIsSelected()
	{
		Tab tab = (Tab)m_selectedTab.getTabBar().getTab(
				m_selectedTab.getTabBar().getSelectedTab());
		//String str = tab.toString();
		
		return tab.toString() == "Sphere";
		
		//getStylePrimaryName() =="Sphere";
	}

	@Override
	public boolean squarePyramidIsSelected()
	{
		return m_selectedTab.getStylePrimaryName() =="Pyramid";
	}

	@Override
	public boolean torusIsSelected()
	{
		return m_selectedTab.getStylePrimaryName() =="Torus";
	}

	@Override
	public String getConeHeight()
	{
		return m_coneHeight.getText();
	}

	@Override
	public String getConeRadius()
	{
		return m_coneRadius.getText();
	}

	@Override
	public String getCubeEdgeLength()
	{
		return m_cubeFaceLength.getText();
	}

	@Override
	public String getCylinderRadius()
	{
		return m_cylinderRadius.getText();
	}

	@Override
	public String getCylinderHeight()
	{
		return m_cylinderHeight.getName();
	}

	@Override
	public String getSphereRadius()
	{
		return m_sphereRadius.getText();
	}

	@Override
	public String getSquareBasedPyramidBaseLength()
	{
		return m_pramidLength.getText();
	}

	@Override
	public String getSquareBasedPyramidBaseHeight()
	{
		return m_pyramidHeight.getText();
	}

	@Override
	public String getTorusMinorRadius()
	{
		return m_torusMinorRadius.getText();
	}

	@Override
	public String getTorusMajorRadius()
	{
		return m_torusMajorRadius.getText();
	}

	@Override
	public void setCalculatedAreaResult(String area)
	{
		m_areaResult.setText(area);

	}

	@Override
	public void setErrorMessage(String message)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setStateOfCalculateAreaButton(boolean flag)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setStateOfErrorIcon(boolean flag)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void processInputActionHandler(IActionHandler handler)
	{
		//m_processInputHandler = handler;

	}

	@Override
	public void setCalculateAreaActionHandler(IActionHandler handler)
	{
		m_figureAreaHandler = handler;

	}
	@UiHandler("m_calculateAreaButton")
	void onM_calculateAreaButtonClick(ClickEvent event) {
		m_figureAreaHandler.processAction();
	}

}