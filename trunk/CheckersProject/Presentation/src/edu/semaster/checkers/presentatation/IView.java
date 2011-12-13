package edu.semaster.checkers.presentatation;

import edu.semaster.checkers.baseProject.FigureType;

public interface IView {
	
	public void refreshUserInterface();

	public void highlightClickedSquarePosition(Point p, boolean highlighted);

	public void setStatusMessage(String message);

	public void clearHighlighting();

	void setFigurePosition(Point p, FigureType figureType);

}
