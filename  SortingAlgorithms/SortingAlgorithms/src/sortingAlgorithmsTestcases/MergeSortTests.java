package sortingAlgorithmsTestcases;

import static org.junit.Assert.*;

import org.junit.Test;

import sortingAlgorithms.MergeSort;

public class MergeSortTests
{

	@Test
	public void canCreateAnArrayWithElements()
	{
		int num = 3;
		int[] a = new int[num];
		MergeSort mergeSort = new MergeSort(a);
		assertNotNull(mergeSort);
	}

	@Test
	public void canSortOneElementArray()
	{
		int[] unsorted =
		{ 10 };
		MergeSort mergeSort = new MergeSort(unsorted);
		int[] actualsorted = mergeSort.sortArray(unsorted);
		int[] expectedsorted =
		{ 10 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void canSortTwoElementArray()
	{
		int[] unsorted =
		{ 78, 30 };
		MergeSort mergeSort = new MergeSort(unsorted);
		int[] actualsorted = mergeSort.sortArray(unsorted);
		int[] expectedsorted =
		{ 30, 78 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void canSortOddNumberedArray()
	{
		int[] unsorted =
		{ 3, 5, 1, 9, 11, 25, 43, 7 };
		MergeSort mergeSort = new MergeSort(unsorted);
		int[] actualsorted = mergeSort.sortArray(unsorted);
		int[] expectedsorted =
		{ 1, 3, 5, 7, 9, 11, 25, 43 };
		assertArrayEquals(expectedsorted, actualsorted);

	}

	@Test
	public void canSortEvenNumberedArray()
	{
		int[] unsorted =
		{ 2, 4, 6, 10, 22, 44, 8,12 };
		MergeSort mergeSort = new MergeSort(unsorted);
		int[] actualsorted = mergeSort.sortArray(unsorted);
		int[] expectedsorted =
		{ 2, 4, 6, 8, 10, 12, 22, 44 };
		assertArrayEquals(expectedsorted, actualsorted);

	}

	@Test
	public void canSortAMixedUnsortedArray()
	{
		int[] unsorted =
		{ 0, 4, 56, 17, 10, 2, 13, 22 };
		MergeSort mergeSort = new MergeSort(unsorted);
		int[] actualsorted = mergeSort.sortArray(unsorted);
		int[] expectedsorted =
		{ 0, 2, 4, 10, 13, 17, 22, 56 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void checkWhetherTheLengthOfBothArraysAreEqual()
	{
		int[] unsorted =
		{ 0, 4, 56, 16, 10, 2, 12, 22 };
		MergeSort mergeSort = new MergeSort(unsorted);
		int[] actualsorted = mergeSort.sortArray(unsorted);
		assertEquals(unsorted.length, actualsorted.length);
	}

	@Test(expected = NullPointerException.class)
	public void exceptionIsThrowIfAnArrayIsEmpty()
	{
		int[] unsorted =
		{};
		MergeSort mergeSort = new MergeSort(unsorted);
		mergeSort.sortArray(null);
	}

}
