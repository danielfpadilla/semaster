package edu.semaster.sortingAlgorithms.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.core.client.EntryPoint;

import edu.semaster.sortingAlgorithms.presentation.IActionHandler;
import edu.semaster.sortingAlgorithms.presentation.IView;
import edu.semaster.sortingAlgorithms.presentation.Presenter;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.event.logical.shared.AttachEvent;

public class WebView extends Composite implements EntryPoint, IView
{
	Presenter m_presenter;
	private static final Binder m_binder = GWT.create(Binder.class);
	@UiField TextBox m_sortedArray;
	@UiField TextBox m_randomlygenerateArray;
	@UiField Button m_randomlygeneratedArray;
	@UiField RadioButton radioButton;
	@UiField TextBox textBox;
	@UiField Button button;
	@UiField TextBox textBox_1;
	TextBox m_textBox;

	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, WebView> {
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
	public String getUnsortedArray() {
		
		return null;
	}

	@Override
	public void setUnsortedArray(String unsortedArray) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mergeSortIsSelected() {
		
		return false;
	}

	@Override
	public boolean quickSortIsSelected() {
		
		return false;
	}

	@Override
	public void setSortedArray(String sortedArray) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getArraySize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateRandomArray(IActionHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectedArraySize(IActionHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortArray(IActionHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortingArray(IActionHandler handler) 
	{
		// TODO Auto-generated method stub
		
	}

	@UiHandler("radioButton")//MergeSort
	public void onRadioButtonClick(ClickEvent event) 
	{
	}
	@UiHandler("textBox")//GeneratedArray 
	public void onTextBoxAttachOrDetach(ClickEvent event) 
	{
	}
	@UiHandler("button")//Randomly generate Array button
	public void onButtonClick(ClickEvent event) 
	{
	}
	
	
	
	@UiHandler("textBox_1")//Array size
	public void onTextBox_1AttachOrDetach(AttachEvent event)
	{
	}
	

    
    @UiHandler("button_1")//enterArraySize
	public void onButton_1Click(ClickEvent event) {
	}
 
	{
	}
	
	
	
}
