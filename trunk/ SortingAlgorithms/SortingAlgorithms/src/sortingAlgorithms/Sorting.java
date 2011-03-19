package sortingAlgorithms;

public abstract class Sorting
{
	public String sortingName()
	{
		return " ";
	}

	public int[] sortArray(int[] unsortedArray)
	{
		if (unsortedArray == null)
		{
			throw new NullPointerException("Zero Element Array");
		}
		return Sort(unsortedArray);
	}

	protected abstract int[] Sort(int[] unsortedArray);
}
