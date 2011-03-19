package sortingAlgorithmsTestcases;

import static org.junit.Assert.*;

import org.junit.Test;

import sortingAlgorithms.QuickSort;

public class QuickSortTests
{

	@Test
	public void canCreateArrayWithElements()
	{
		int[] a = new int[5];
		QuickSort quicksort = new QuickSort(a);
		assertNotNull(quicksort);
	}

	@Test
	public void canSortOneElementArray()
	{
		int[] unsorted =
		{ 9 };
		QuickSort quicksort = new QuickSort(unsorted);
		int[] actualsorted = quicksort.sortArray(unsorted);
		int[] expectedsorted =
		{ 9 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void canSortOTwoElementArray()
	{
		int[] unsorted =
		{ 9, 2 };
		QuickSort quicksort = new QuickSort(unsorted);
		int[] actualsorted = quicksort.sortArray(unsorted);
		int[] expectedsorted =
		{ 2, 9 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void canSortAnEvenNumberedArray()
	{
		int[] unsorted =
		{ 32, 30, 10, 8, 12, 10, 88, 2 };
		QuickSort quicksort = new QuickSort(unsorted);
		int[] actualsorted = quicksort.sortArray(unsorted);
		int[] expectedsorted =
		{ 2, 8, 10, 10, 12, 30, 32, 88 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void canSortAnODDNumberedArray()
	{
		int[] unsorted =
		{ 33, 131, 11, 1, 71, 141, 3, 1 };
		QuickSort quicksort = new QuickSort(unsorted);
		int[] actualsorted = quicksort.sortArray(unsorted);
		int[] expectedsorted =
		{ 1, 1, 3, 11, 33, 71, 131, 141 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void canSortAnMixedUnsortedArray()
	{
		int[] unsorted =
		{ 5, 4, 3, 2, 1 };
		QuickSort quicksort = new QuickSort(unsorted);
		int[] actualsorted = quicksort.sortArray(unsorted);
		int[] expectedsorted =
		{ 1, 2, 3, 4, 5 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void checkWhetherTheLengthOfBothArraysAreEqual()
	{
		int[] unsorted =
		{ 5, 4, 3, 2, 1 };
		QuickSort quicksort = new QuickSort(unsorted);
		int[] actualsorted = quicksort.sortArray(unsorted);
		assertEquals(unsorted.length, actualsorted.length);

	}

	@Test(expected = NullPointerException.class)
	public void exceptionIsThrowIfAnArrayIsEmpty()
	{
		int unsorted[] =
		{};
		QuickSort quicksort = new QuickSort(unsorted);
		quicksort.sortArray(null);
	}

}
