package sortingAlgorithmsTestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sortingAlgorithms.MergeSort;



public class MergeSortTestcases
{
	MergeSort mergeSort;

	@Before
	public void setUp()
	{
		mergeSort = new MergeSort();
	}

	@After
	public void tearDown()
	{
		mergeSort = null;
	}

	@Test
	public void canCreateAnArrayWithElements()
	{
		assertNotNull(mergeSort);
	}

	@Test
	public void canReturnSortingName()
	{
		assertEquals("MergeSort", mergeSort.getSortingName());
	}

	@Test
	public void canSortOneElementArray()
	{
		int[] unsorted = { 10 };
		int[] actualsorted = mergeSort.sortArray(unsorted);
		int[] expectedsorted = { 10 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void canSortTwoElementArray()
	{
		int[] unsorted =
		{ 78, 30 };
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
		int[] actualsorted = mergeSort.sortArray(unsorted);
		int[] expectedsorted =
		{ 1, 3, 5, 7, 9, 11, 25, 43 };
		assertArrayEquals(expectedsorted, actualsorted);

	}

	@Test
	public void canSortEvenNumberedArray()
	{
		int[] unsorted =
		{ 3, 5, 1, 9, 11, 25, 43, 7 };
		int[] actualsorted = mergeSort.sortArray(unsorted);
		int[] expectedsorted =
		{ 1, 3, 5, 7, 9, 11, 25, 43 };
		assertArrayEquals(expectedsorted, actualsorted);

	}

	@Test
	public void canSortAMixedUnsortedArray()
	{
		int[] unsorted =
		{ 0, 4, 56, 16, 10, 2, 12, 22 };
		int[] actualsorted = mergeSort.sortArray(unsorted);
		int[] expectedsorted =
		{ 0, 2, 4, 10, 12, 16, 22, 56 };
		assertArrayEquals(expectedsorted, actualsorted);
	}

	@Test
	public void checkWhetherTheLengthOfBothArraysAreEqual()
	{
		int[] unsorted =
		{ 0, 4, 56, 16, 10, 2, 12, 22 };
		int[] actualsorted = mergeSort.sortArray(unsorted);
		assertEquals(unsorted.length, actualsorted.length);
	}

	@Test(expected = NullPointerException.class)
	public void exceptionIsThrowIfAnArrayIsEmpty()
	{
		mergeSort.sortArray(null);
	}

}
