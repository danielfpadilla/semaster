package edu.semaster.checkers.presenter;

public class FigureType {
	public static enum Type {
		WHITE, WHITE_KING, BLACK, BLACK_KING;
	}

	private Type mFigure;

	public void setFigureType(Type figure) {
		mFigure = figure;
	}

	public Type getFigureType() {
		return mFigure;

	}
}
