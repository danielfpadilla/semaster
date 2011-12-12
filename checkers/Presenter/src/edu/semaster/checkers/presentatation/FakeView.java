package edu.semaster.checkers.presentatation;

import edu.semaster.checkers.baseProject.Piece;

public class FakeView implements IView {
	Point p1;
	Piece mType;
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
	public void setFigurePosition(Point p, Piece type) {
		p1.x = p.x;
		p1.y = p.y;
		mType = type;

	}

	@Override
	public void clearHighlighting() {
		// TODO Auto-generated method stub
		
	}

}
