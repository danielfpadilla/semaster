package edu.semaster.checkers.model;

public  class Move {
	private final int sourceX;
	private final int sourceY;
	
	
	private final int targetX;
	private final int targetY;

	public Move(final int sourceX,final int sourceY,final int targetX, final int targetY) {
		if (sourceX < 0 || targetX < 0||(sourceY < 0 || targetY < 0))
			throw new IllegalArgumentException();
		this.sourceX = sourceX;
		this.sourceY = sourceY;
		this.targetX = targetX;
		this.targetY = targetY;
	}

	public int getSourceX() {
		return this.sourceX;
	}
	public int getSourceY() {
		return this.sourceY;
	}
	public int getTargetX() {
		return this.targetX;
	}

	public int getTargetY() {
		return this.targetY;
	}

	public String toString() {
		return this.getClass().getCanonicalName() + "(" + this.sourceX +"," +this.sourceY + ")" 
		        + "->" + "(" + this.targetX +"," +this.targetY + ")";
			
	}

	public static final int pathLength(final Move[] moveSequence) {
		for (int index = 0; index < moveSequence.length; ++index) {
			if (moveSequence[index] == null)
				return index;
		}
		return moveSequence.length;
	}
}
