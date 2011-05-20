package edu.semaster.sortingAlgorithms.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.AbsolutePanel;

import edu.semaster.sortingAlgorithms.presentation.IActionHandler;
import edu.semaster.sortingAlgorithms.presentation.IView;
import edu.semaster.sortingAlgorithms.presentation.Presenter;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.dom.client.ClickEvent;


public class WebView extends Composite  implements EntryPoint, IView
{

	Presenter m_presenter;
	private static final Binder binder = GWT.create(Binder.class);
	@UiField Label m_enterArraySize;
	@UiField TextBox m_arraySize;
	@UiField Button m_generateArray;
	@UiField TextBox m_randomlyGeneratedArray;
	@UiField RadioButton m_mergeSort;
	@UiField RadioButton m_quickSort;
	@UiField Button m_sortArray;
	@UiField TextBox m_sortedArray;
	@UiField AbsolutePanel m_binder;
	

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUnsortedArray(String unsortedArray) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mergeSortIsSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean quickSortIsSelected() {
		// TODO Auto-generated method stub
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
		
	}

	@Override
	public void sortingArray(IActionHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@UiHandler("m_arraySize")
	void onM_arraySizeAttachOrDetach(AttachEvent event)
	{
	}
	@UiHandler("m_generateArray")
	void M_generateArrayOnClick(AttachEvent event) 
	{
		
	}
	@UiHandler("m_randomlyGeneratedArray")
	void M_randomlyGeneratedArrayOnAttachOrDetach(AttachEvent event)
	{
	}	@UiHandler("m_mergeSort")
	void onM_mergeSortClick(ClickEvent event) 
	{
	}

	
	
	
		@UiHandler("m_quickSort")
	void onM_quickSortClick(ClickEvent event) {
	}

	
	
	
	@UiHandler("m_sortArray")
	void onM_sortArrayClick(ClickEvent event) {
	}
}
