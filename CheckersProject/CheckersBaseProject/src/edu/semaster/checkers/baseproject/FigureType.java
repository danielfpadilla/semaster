package edu.semaster.checkers.baseproject;

public class FigureType {
	
	public static enum Type {
		WHITE, WHITE_KING, BLACK, BLACK_KING, NONE;
	}

	private Type mFigure = Type.NONE;
 
	public FigureType(Type type) {
		mFigure = type;
	}

	public FigureType() {
	}

	public void setFigureType(Type figure) {
		mFigure = figure;
	}

	public Type getFigureType() {
		return mFigure;

	}
}
