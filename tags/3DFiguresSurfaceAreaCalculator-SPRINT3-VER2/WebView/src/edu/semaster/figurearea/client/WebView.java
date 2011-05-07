package edu.semaster.figurearea.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.event.dom.client.KeyUpEvent;

public class WebView extends Composite implements EntryPoint, IView
{
	Presenter m_presenter;
	private static final Binder m_binder = GWT.create(Binder.class);
	@UiField TextBox m_coneRadius;
	@UiField TextBox m_cubeFaceLength;
	@UiField TextBox m_coneHeight;
	@UiField TextBox m_cylinderRadius;
	@UiField TextBox m_cylinderHeight;
	@UiField TextBox m_sphereRadius;
	@UiField TextBox m_pyramidLength;
	@UiField TextBox m_pyramidHeight;
	@UiField TextBox m_torusMajorRadius;
	@UiField TextBox m_torusMinorRadius;
	@UiField TextBox m_areaResult;
	@UiField Button m_calculateAreaButton;
	@UiField TabLayoutPanel m_selectedTab;
	@UiField Label m_labelErrorMessage;
	@UiField Image m_errorImage;
	TextBox m_textBox;
	private IActionHandler m_figureAreaHandler;
	private IActionHandler m_processInputHandler;

	interface Binder extends UiBinder<Widget, WebView>
	{
	}

	public WebView()
	{
		initWidget(m_binder.createAndBindUi(this));
	}

	public void onModuleLoad()
	{
		RootPanel.get().add(this);
		m_presenter = new Presenter(this);
		m_errorImage.setVisible(false);
	}
	private Widget getSelectedTab()
	{
		int index = m_selectedTab.getSelectedIndex();
		Widget widget = m_selectedTab.getTabWidget(index);
		return widget;
	}
	@Override
	public boolean coneIsSelected()
	{
		Widget widget = getSelectedTab();
		return widget.toString().contains("Cone");
		
	}

	@Override
	public boolean cubeIsSelected()
	{
		Widget widget = getSelectedTab();
		return widget.toString().contains("Cube");
		
	}

	@Override
	public boolean cylinderIsSelected()
	{
		Widget widget = getSelectedTab();
		return widget.toString().contains("Cylinder");
		
	}

	@Override
	public boolean sphereIsSelected()
	{
		Widget widget = getSelectedTab();
		return widget.toString().contains("Sphere");
	
	}

	@Override
	public boolean squarePyramidIsSelected()
	{
		Widget widget = getSelectedTab();
		return widget.toString().contains("Pyramid");
	}

	@Override
	public boolean torusIsSelected()
	{
		Widget widget = getSelectedTab();
		return widget.toString().contains("Torus");
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
		return m_cylinderHeight.getText();
	}

	@Override
	public String getSphereRadius()
	{
		return m_sphereRadius.getText();
	}

	@Override
	public String getSquareBasedPyramidBaseLength()
	{
		return m_pyramidLength.getText();
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
		m_labelErrorMessage.setText(message);

	}

	@Override
	public void setStateOfCalculateAreaButton(boolean flag)
	{
		m_calculateAreaButton.setEnabled(flag);

	}

	@Override
	public void setStateOfErrorIcon(boolean flag)
	{
		m_errorImage.setVisible(flag);
	}

	@Override
	public void processInputActionHandler(IActionHandler handler)
	{
		m_processInputHandler = handler;

	}

	@Override
	public void setCalculateAreaActionHandler(IActionHandler handler)
	{
		m_figureAreaHandler = handler;

	}

	@UiHandler("m_calculateAreaButton")
	void onM_calculateAreaButtonClick(ClickEvent event)
	{
		m_figureAreaHandler.processAction();
	}

	@UiHandler("m_coneRadius")
	void onM_coneRadiusKeyPress(KeyUpEvent event)
	{
		m_processInputHandler.processAction();
	}

	@UiHandler("m_coneHeight")
	void onM_coneHeightKeyPress(KeyUpEvent event)
	{
		m_processInputHandler.processAction();
	}

	@UiHandler("m_cylinderHeight")
	void onM_cylinderHeightKeyPress(KeyUpEvent event) {
		m_processInputHandler.processAction();
	}
	@UiHandler("m_cylinderRadius")
	void onM_cylinderRadiusKeyPress(KeyUpEvent event) {
		m_processInputHandler.processAction();
	}
	@UiHandler("m_cubeFaceLength")
	void onM_cubeFaceLengthKeyPress(KeyUpEvent event) {
		m_processInputHandler.processAction();
	}
	@UiHandler("m_pyramidLength")
	void onM_pyramidLengthKeyPress(KeyUpEvent event) {
		m_processInputHandler.processAction();
	}
	@UiHandler("m_sphereRadius")
	void onM_sphereRadiusKeyPress(KeyUpEvent event) {
		m_processInputHandler.processAction();
	}
	@UiHandler("m_torusMinorRadius")
	void onM_torusMinorRadiusKeyPress(KeyUpEvent event) {
		m_processInputHandler.processAction();
	}
	@UiHandler("m_pyramidHeight")
	void onM_pyramidHeightKeyPress(KeyUpEvent event) {
		m_processInputHandler.processAction();
	}
	@UiHandler("m_torusMajorRadius")
	void onM_torusMajorRadiusKeyUp(KeyUpEvent event) {
		m_processInputHandler.processAction();
	}
}
