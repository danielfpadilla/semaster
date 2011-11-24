package edu.semaster.checkers.presenter;



public interface IView {
	public void setFigurePosition(Point p);
	public void setFigureType(FigureType type);
	public void processInputActionHandler(IFigureMoveHandler handler);
	public void refreshUserInterface();
	public void highlightClickedSquarePosition();
	public void setStatusMessage(String message);
}
