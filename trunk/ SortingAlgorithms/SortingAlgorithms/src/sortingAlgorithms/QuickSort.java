package sortingAlgorithms;
//Initialization of the array
public class QuickSort extends Sorting
{
	public QuickSort(int[] a)
	{
	}

	@Override
	public String sortingName()
	{
		return "QuickSort";
	}
//Compairing array elements
	@Override
	protected int[] Sort(int[] unsortedArray)
	{
		int[] sortedArray = new int[unsortedArray.length];
		for (int k = 0; k < unsortedArray.length; k++)
		{
			sortedArray[k] = unsortedArray[k];
		}
		Q_Recursive(sortedArray, 0, sortedArray.length - 1);
		return sortedArray;
	}
//Partition the array into three parts
	private static void Q_Recursive(int[] arr, int left, int right)
	{
		int i = left, j = right;
		int pivot = arr[(left + right) / 2];
		while (i <= j)
		{
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j)
			{
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		//use quicksort to recursively sort left and right members of the array
		if (left < j)
			Q_Recursive(arr, left, j);
		if (i < right)
			Q_Recursive(arr, i, right);
	}

}
