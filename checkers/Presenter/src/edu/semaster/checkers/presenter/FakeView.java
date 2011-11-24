package edu.semaster.checkers.presenter;

public class FakeView implements IView {
	Point p1;
	IFigureMoveHandler mActionHandler;
	FigureType mType;
	String mStatusMessage;

	@Override
	public void setFigurePosition(Point p) {
		p1.x = p.x;
		p1.y = p.y;
	}

	@Override
	public void processInputActionHandler(IFigureMoveHandler handler) {

		mActionHandler = handler;
	}

	@Override
	public void setFigureType(FigureType type) {
		mType = type;

	}

	@Override
	public void refreshUserInterface() {
		// TODO Auto-generated method stub
	}

	@Override
	public void highlightClickedSquarePosition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStatusMessage(String message) {
		mStatusMessage = message;

	}

}
