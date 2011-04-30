package edu.semaster.figureareacalculator.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.EntryPoint;
import edu.semaster.figurearea.presentation.*;

public class WebView extends Composite implements EntryPoint, IView {
   Presenter m_presenter;
    private static final Binder binder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Widget, WebView> {
    }

    public WebView() {
        initWidget(binder.createAndBindUi(this));
    }

    public void onModuleLoad()
    {
        RootPanel.get().add(this);
        m_presenter = new Presenter(this);
    }

	@Override
	public String getConeHeight()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConeRadius()
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
	public String getCubeEdgeLength()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cubeIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
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
	public boolean cylinderIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSphereRadius()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sphereIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
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
	public boolean squarePyramidIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
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
	public boolean torusIsSelected()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCalculatedAreaResult(String area)
	{
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCalculateAreaActionHandler(IActionHandler handler)
	{
		// TODO Auto-generated method stub
		
	}
}