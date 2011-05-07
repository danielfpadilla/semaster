package edu.Semaster.FractionCalculator.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import edu.Semaster.FractionCalculator.Presenter.FractionPresenter;
import edu.Semaster.FractionCalculator.Presenter.IActionHandler;
import edu.Semaster.FractionCalculator.Presenter.IFractionView;

public class WebView extends Composite implements EntryPoint, IFractionView
{

	private static final Binder binder = GWT.create(Binder.class);
	@UiField
	TextBox m_result;
	@UiField
	Label m_numerator1;
	@UiField
	Label m_numerator2;
	@UiField
	Label m_denominator1;
	@UiField
	Label m_denominator2;
	@UiField
	Button m_addButton;
	@UiField
	Button m_substractButton;
	@UiField
	Button m_clearButton;
	@UiField
	Button m_divideButton;
	@UiField
	Button m_multiplyButton;

	private IActionHandler m_addActionHandler;
	private IActionHandler m_substractActionHandler;
	private IActionHandler m_multiplyActionHandler;
	private IActionHandler m_divideActionHandler;
	private IActionHandler m_clearActionHandler;
	//private IActionHandler m_inputActionHandler;
	private Label m_errorLabel;
	private Label m_myImage;
	FractionPresenter m_presenter;

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
		 m_presenter = new FractionPresenter(this);
	}

	@UiHandler("m_addButton")
	void onM_addButtonClick(ClickEvent event)
	{
		m_addActionHandler.processAction();
	}

	@UiHandler("m_substractButton")
	void onM_substractButtonClick(ClickEvent event)
	{
		m_substractActionHandler.processAction();
	}

	@UiHandler("m_clearButton")
	void onM_clearButtonClick(ClickEvent event)
	{
		m_clearActionHandler.processAction();
	}

	@UiHandler("m_divideButton")
	void onM_divideButtonClick(ClickEvent event)
	{
		m_divideActionHandler.processAction();
	}

	@UiHandler("m_multiplyButton")
	void onM_multiplyButtonClick(ClickEvent event)
	{
		m_multiplyActionHandler.processAction();
	}

	@Override
	public String getNumerator1()
	{
		return m_numerator1.getText();
	}

	@Override
	public String getDenominator1()
	{
		return m_denominator1.getText();
	}

	@Override
	public String getNumerator2()
	{

		return m_numerator2.getText();
	}

	@Override
	public String getDenominator2()
	{
		return m_denominator2.getText();
	}

	@Override
	public void setNumerator1(String string)
	{
		m_numerator1.setText(string);

	}

	@Override
	public void setDenominator1(String string)
	{
		m_denominator1.setText(string);

	}

	@Override
	public void setNumerator2(String string)
	{
		m_numerator2.setText(string);

	}

	@Override
	public void setDenominator2(String string)
	{
		m_denominator2.setText(string);

	}

	@Override
	public void setResult(String string)
	{
		m_result.setText(string);

	}

	@Override
	public void setAddActionHandler(IActionHandler handler)
	{
		m_addActionHandler = handler;
	}

	@Override
	public void setSubstractActionHandler(IActionHandler handler)
	{
		m_substractActionHandler = handler;

	}

	@Override
	public void setMultiplyActionHandler(IActionHandler handler)
	{
		m_multiplyActionHandler = handler;

	}

	@Override
	public void setDevideActionHandler(IActionHandler handler)
	{
		m_divideActionHandler = handler;

	}

	@Override
	public void setInputActionHandler(IActionHandler handler)
	{
		//m_inputActionHandler = handler;

	}

	@Override
	public void setClearActionHandler(IActionHandler handler)
	{
		m_clearActionHandler = handler;

	}

	@Override
	public void setErrorCondition(boolean error, String message)
	{
		
		

	}
}