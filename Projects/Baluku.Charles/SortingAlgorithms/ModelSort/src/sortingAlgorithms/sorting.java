package sortingAlgorithms;

public abstract class sorting
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
