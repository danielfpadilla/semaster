package sortingAlgorithms;

public class MergeSort extends Sorting
{
	private int m_numberOfElements;
	public int[] m_numbers = new int[m_numberOfElements];

	@Override
	
	public String getSortingName()
	{
		return "MergeSort";
	}

	@Override
	public int[] sortInternal(int[] ArrayElements)
	{
		this.m_numbers = ArrayElements;
		m_numberOfElements = ArrayElements.length;

		mergeSort(0, m_numberOfElements - 1);
		return ArrayElements;
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

		int[] helperArray = new int[m_numberOfElements];
		for (int i = low; i <= high; i++)
		{
			helperArray[i] = m_numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high)
		{
			if (helperArray[i] <= helperArray[j])
			{
				m_numbers[k] = helperArray[i];
				i++;
			} else
			{
				m_numbers[k] = helperArray[j];
				j++;
			}
			k++;
		}
		while (i <= middle)
		{
			m_numbers[k] = helperArray[i];
			k++;
			i++;
		}
		helperArray = null;

	}

	

	

}
