package sortingAlgorithms;

public class MergeSort extends Sorting
{
	private int numberOfElements;
	public int[] numbers = new int[numberOfElements];

	public MergeSort(int[] a)
	{
	}

	@Override
	public String sortingName()
	{
		return "MergeSort";
	}

	@Override
	public int[] Sort(int[] values)
	{
		this.numbers = values;
		numberOfElements = values.length;

		mergeSort(0, numberOfElements - 1);
		return values;
	}

	private void mergeSort(int low, int high)
	{
		if (low < high)
		{
			int middle = (low + high) / 2;
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high)
	{

		int[] helperArray = new int[numberOfElements];
		for (int i = low; i <= high; i++)
		{
			helperArray[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high)
		{
			if (helperArray[i] <= helperArray[j])
			{
				numbers[k] = helperArray[i];
				i++;
			} else
			{
				numbers[k] = helperArray[j];
				j++;
			}
			k++;
		}
		while (i <= middle)
		{
			numbers[k] = helperArray[i];
			k++;
			i++;
		}
		helperArray = null;

	}

}
