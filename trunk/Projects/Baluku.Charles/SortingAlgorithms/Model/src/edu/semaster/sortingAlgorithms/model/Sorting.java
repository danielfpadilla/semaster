package edu.semaster.sortingAlgorithms.model;

public abstract class Sorting
{
	public abstract String getSortingName();

	public int[] sortArray(int[] unsortedArray)
	{
		if (unsortedArray == null)
		{
			throw new NullPointerException("Zero Element Array");
		}
		return sortInternal(unsortedArray);
	}

	protected abstract int[] sortInternal(int[] unsortedArray);
}