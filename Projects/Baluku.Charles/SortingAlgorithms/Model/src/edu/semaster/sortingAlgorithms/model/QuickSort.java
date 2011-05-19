package edu.semaster.sortingAlgorithms.model;

public class QuickSort extends Sorting
{
	@Override
	public String getSortingName() 
	{
		return "QuickSort";
	}

	@Override
	protected int[] sortInternal(int[] unsortedArray)
	{
		int[] sortedArray = new int[unsortedArray.length];
		for (int k = 0; k < unsortedArray.length; k++)
		{
			sortedArray[k] = unsortedArray[k];
		}
		quickSortRecursive(sortedArray, 0, sortedArray.length - 1);
		return sortedArray;
	}

	private static void quickSortRecursive(int[] arr, int left, int right)
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
		if (left < j)
			quickSortRecursive(arr, left, j);
		if (i < right)
			quickSortRecursive(arr, i, right);
	}

	
}