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
		MergeSort mergesort = new MergeSort(a);
		assertNotNull(mergesort);
	}

	@Test
	public void canSortOneElementArray()
	{
		int[] unsorted =
		{ 10 };
		MergeSort mergesort = new MergeSort(unsorted);
		int[] actualsorted = mergesort.sortArray(unsorted);
		int[] expectedsorted =
		{ 10 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void canSortTwoElementArray()
	{
		int[] unsorted =
		{ 78, 30 };
		MergeSort mergesort = new MergeSort(unsorted);
		int[] actualsorted = mergesort.sortArray(unsorted);
		int[] expectedsorted =
		{ 30, 78 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void canSortOddNumberedArray()
	{
		int[] unsorted =
		{ 3, 5, 1, 9, 11, 25, 43, 7 };
		MergeSort mergesort = new MergeSort(unsorted);
		int[] actualsorted = mergesort.sortArray(unsorted);
		int[] expectedsorted =
		{ 1, 3, 5, 7, 9, 11, 25, 43 };
		assertArrayEquals(expectedsorted, actualsorted);

	}

	@Test
	public void canSortEvenNumberedArray()
	{
		int[] unsorted =
		{ 3, 5, 1, 9, 11, 25, 43, 7 };
		MergeSort mergesort = new MergeSort(unsorted);
		int[] actualsorted = mergesort.sortArray(unsorted);
		int[] expectedsorted =
		{ 1, 3, 5, 7, 9, 11, 25, 43 };
		assertArrayEquals(expectedsorted, actualsorted);

	}

	@Test
	public void canSortAMixedUnsortedArray()
	{
		int[] unsorted =
		{ 0, 4, 56, 16, 10, 2, 12, 22 };
		MergeSort mergesort = new MergeSort(unsorted);
		int[] actualsorted = mergesort.sortArray(unsorted);
		int[] expectedsorted =
		{ 0, 2, 4, 10, 12, 16, 22, 56 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void checkWhetherTheLengthOfBothArraysAreEqual()
	{
		int[] unsorted =
		{ 0, 4, 56, 16, 10, 2, 12, 22 };
		MergeSort mergesort = new MergeSort(unsorted);
		int[] actualsorted = mergesort.sortArray(unsorted);
		assertEquals(unsorted.length, actualsorted.length);
	}

	@Test(expected = NullPointerException.class)
	public void exceptionIsThrowIfAnArrayIsEmpty()
	{
		int[] unsorted =
		{};
		MergeSort mergesort = new MergeSort(unsorted);
		mergesort.sortArray(null);
	}

}
