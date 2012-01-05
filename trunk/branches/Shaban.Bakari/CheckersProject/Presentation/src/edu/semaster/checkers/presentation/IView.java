package edu.semaster.checkers.presentation;

import edu.semaster.checkers.baseproject.FigureType;
import edu.semaster.checkers.baseproject.Point;


public interface IView {

	public void refreshUserInterface();

	public void highlightClickedSquarePosition(Point p, boolean highlighted);

	public void setStatusMessage(String message);

	public void clearHighlighting();

	void setFigurePosition(Point p, FigureType figureType);

}
