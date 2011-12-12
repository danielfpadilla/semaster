package edu.semaster.checkers.presentatation;

public interface IView {
	
	public void refreshUserInterface();

	public void highlightClickedSquarePosition(Point p, boolean highlighted);

	public void setStatusMessage(String message);

	public void clearHighlighting();

	void setFigurePosition(Point p, edu.semaster.checkers.baseProject.Piece type);

}
