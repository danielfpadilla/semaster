package edu.semaster.checkers.presenter;

public class FakeView implements IView{
	Point p1;

	@Override
	public void setFigurePosition(Point p) {
		p1.x = p.x;
		p1.y = p.y;	
	}

	@Override
	public Point getFigurePosition() {
		return p1;
	}

}
