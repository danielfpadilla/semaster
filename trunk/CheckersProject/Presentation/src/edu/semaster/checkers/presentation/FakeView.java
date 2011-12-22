package edu.semaster.checkers.presentation;

import edu.semaster.checkers.baseproject.FigureType;
import edu.semaster.checkers.baseproject.Point;


public class FakeView implements IView {
	Point p1;
	FigureType mType;
	String mStatusMessage;

	public void refreshUserInterface() {
		// TODO Auto-generated method stub
	}

	@Override
	public void highlightClickedSquarePosition(Point p, boolean highlighted) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStatusMessage(String message) {
		mStatusMessage = message;

	}

	@Override
	public void clearHighlighting() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFigurePosition(Point p, FigureType figureType) {
		p1.x = p.x;
		p1.y = p.y;
		mType = figureType;

	}

}
