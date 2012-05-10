package edu.semaster.checkers.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.semaster.checkers.baseproject.FigureType;
import edu.semaster.checkers.baseproject.Point;
import edu.semaster.checkers.presentation.IView;
import edu.semaster.checkers.presentation.Presenter;

public class WebView extends Composite implements EntryPoint, IView {

	 private static final Binder binder = GWT.create(Binder.class);
	 Presenter m_presenter;

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
		public void refreshUserInterface() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void highlightClickedSquarePosition(Point p, boolean highlighted) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setStatusMessage(String message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void clearHighlighting() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setFigurePosition(Point p, FigureType figureType) {
			// TODO Auto-generated method stub
			
		}
	}