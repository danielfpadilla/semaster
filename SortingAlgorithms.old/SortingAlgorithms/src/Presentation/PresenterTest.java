package Presentation;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sortingAlgorithms.MergeSort;
import sortingAlgorithms.QuickSort;


public class PresenterTest
{
	FakeView m_view;
	Presenter m_presenter;

	@Before
	public void setUp()
	{
	    //m_view = new FakeView();
		m_presenter = new Presenter(m_view);
	}
	
	 @After
	 public void tearDown()
	         {
		             m_view = null;
	                 m_presenter = null;
	         }
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
		public void checkWhetherTheLengthOfBothArraysAreEqual1()
		{
			int[] unsorted =
			{ 0, 4, 56, 16, 10, 2, 12, 22 };
			MergeSort mergeSort = new MergeSort(unsorted);
			int[] actualsorted = mergeSort.sortArray(unsorted);
			assertEquals(unsorted.length, actualsorted.length);
		}

		@Test(expected = NullPointerException.class)
		public void exceptionIsThrowIfAnArrayIsEmpty1()
		{
			int[] unsorted =
			{};
			MergeSort mergeSort = new MergeSort(unsorted);
			mergeSort.sortArray(null);
		}
		
		@Test
		public void canCreateArrayWithElements()
		{
			int[] a = new int[5];
			QuickSort quickSort = new QuickSort(a);
			assertNotNull(quickSort);
		}

		//Tests using Quick sort
		@Test
		public void canSortOneElementArray1()
		{
			int[] unsorted =
			{ 9 };
			QuickSort quickSort = new QuickSort(unsorted);
			int[] actualsorted = quickSort.sortArray(unsorted);
			int[] expectedsorted =
			{ 9 };
			assertArrayEquals(expectedsorted, actualsorted);
		}

		@Test
		public void canSortOTwoElementArray()
		{
			int[] unsorted =
			{ 9, 2 };
			QuickSort quickSort = new QuickSort(unsorted);
			int[] actualsorted = quickSort.sortArray(unsorted);
			int[] expectedsorted =
			{ 2, 9 };
			assertArrayEquals(expectedsorted, actualsorted);
		}

		@Test
		public void canSortAnEvenNumberedArray()
		{
			int[] unsorted =
			{ 32, 30, 10, 8, 12, 10, 88, 2 };
			QuickSort quickSort = new QuickSort(unsorted);
			int[] actualsorted = quickSort.sortArray(unsorted);
			int[] expectedsorted =
			{ 2, 8, 10, 10, 12, 30, 32, 88 };
			assertArrayEquals(expectedsorted, actualsorted);
		}

		@Test
		public void canSortAnODDNumberedArray()
		{
			int[] unsorted =
			{ 33, 131, 11, 1, 71, 141, 3, 1 };
			QuickSort quickSort = new QuickSort(unsorted);
			int[] actualsorted = quickSort.sortArray(unsorted);
			int[] expectedsorted =
			{ 1, 1, 3, 11, 33, 71, 131, 141 };
			assertArrayEquals(expectedsorted, actualsorted);
		}

		@Test
		public void canSortAnMixedUnsortedArray()
		{
			int[] unsorted =
			{ 5, 4, 3, 2, 1 };
			QuickSort quickSort = new QuickSort(unsorted);
			int[] actualsorted = quickSort.sortArray(unsorted);
			int[] expectedsorted =
			{ 1, 2, 3, 4, 5 };
			assertArrayEquals(expectedsorted, actualsorted);
		}

		@Test
		public void checkWhetherTheLengthOfBothArraysAreEqual()
		{
			int[] unsorted =
			{ 5, 4, 3, 2, 1 };
			QuickSort quickSort = new QuickSort(unsorted);
			int[] actualsorted = quickSort.sortArray(unsorted);
			assertEquals(unsorted.length, actualsorted.length);

		}

		@Test(expected = NullPointerException.class)
		public void exceptionIsThrowIfAnArrayIsEmpty()
		{
			int unsorted[] =
			{};
			QuickSort quickSort = new QuickSort(unsorted);
			quickSort.sortArray(null);
		}


	}



