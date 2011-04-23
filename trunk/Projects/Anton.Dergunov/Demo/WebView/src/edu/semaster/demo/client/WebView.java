package edu.semaster.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;

import edu.semaster.demo.presentation.IActionHandler;
import edu.semaster.demo.presentation.IView;
import edu.semaster.demo.presentation.Presenter;

public class WebView extends Composite implements EntryPoint, IView {

	private static final Binder binder = GWT.create(Binder.class);
	@UiField Button m_addButton;
	@UiField Button m_multiplyButton;
	@UiField TextBox m_real1;
	@UiField TextBox m_imaginary1;
	@UiField TextBox m_real2;
	@UiField TextBox m_imaginary2;
	@UiField TextBox m_result;
	private IActionHandler m_addActionHandler;
	private IActionHandler m_multiplyActionHandler;
	private Presenter m_presenter;

	interface Binder extends UiBinder<Widget, WebView> {
	}

	public WebView() {
		initWidget(binder.createAndBindUi(this));
	}

	public void onModuleLoad()
	{
		RootPanel.get("rootPanel").add(this);
		m_presenter = new Presenter(this);
	}

	@UiHandler("m_addButton")
	void onM_addButtonClick(ClickEvent event) {
		m_addActionHandler.processAction();
	}
	@UiHandler("m_multiplyButton")
	void onM_multiplyButtonClick(ClickEvent event) {
		m_multiplyActionHandler.processAction();
	}

	@Override
	public String getReal1() {
		return m_real1.getText();
	}

	@Override
	public String getImaginary1() {
		return m_imaginary1.getText();
	}

	@Override
	public String getReal2() {
		return m_real2.getText();
	}

	@Override
	public String getImaginary2() {
		return m_imaginary2.getText();
	}

	@Override
	public void setResult(String string) {
		m_result.setText(string);
	}

	@Override
	public void setAddActionHandler(IActionHandler handler) {
		m_addActionHandler = handler;
	}

	@Override
	public void setMultiplyActionHandler(IActionHandler handler) {
		m_multiplyActionHandler = handler;
	}
}
