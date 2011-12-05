package edu.semaster.checkers.presenter;

public interface IView {
	public void setFigurePosition(Point p, FigureType type);

	public void refreshUserInterface();

	public void highlightClickedSquarePosition(Point p, boolean highlighted);

	public void setStatusMessage(String message);

	public void clearHighlighting();
}
