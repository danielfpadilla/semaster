package edu.semaster.checkers.model;

public class Move {
	private final int source;
	private final int target;

	public Move(final int source, final int target) {
		if (source < 0 || target < 0)
			throw new IllegalArgumentException();
		this.source = source;
		this.target = target;
	}

	public int getSource() {
		return this.source;
	}

	public int getTarget() {
		return this.target;
	}

	public String toString() {
		return this.getClass().getCanonicalName() + "(" + this.source + "->"
				+ this.target + ")";
	}

	public static final int pathLength(final Move[] moveSequence) {
		for (int index = 0; index < moveSequence.length; ++index) {
			if (moveSequence[index] == null)
				return index;
		}
		return moveSequence.length;
	}
}
