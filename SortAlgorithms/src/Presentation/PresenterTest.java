package Presentation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class PresenterTest
{
	
	private FakeView m_view;
	private Presenter m_presenter;
	private Object m_view;

	@Before
	public void setUp()
	{
	    m_view = new FakeView();
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
		 m_view.m_SortedArray = true;
         m_view.m_MergeSortHandler.processAction();
         Assert.assertNotNull("4", m_view.m_mergeSort);

		 
		}

		@Test
		public void canSortOneElementArray()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{4}";
			m_view.m_expectedsorted =  "{4}";
			m_view.m_mergeSort.processAction();
			Assert.assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);
			
		}

		@Test
		public void canSortTwoElementArray()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{4,3}";
			m_view.m_expectedsorted =  "{3,4}";
			m_view.m_mergeSort.processAction();
			Assert.assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);
			
		}
		
		@Test
		public void canSortOddNumberedArray()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{3,1,5,7,9}";
			m_view.m_expectedsorted =  "{1,3,5,7,9}";
			m_view.m_mergeSort.processAction();
			Assert.assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);
		}

		@Test
		public void canSortEvenNumberedArray()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{4,2,6,8,10}";
			m_view.m_expectedsorted =  "{2,4,6,8,10}";
			m_view.m_mergeSort.processAction();
			Assert.assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);

		}

		@Test
		public void canSortAMixedUnsortedArray()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{2,4,1,3,6,5}";
			m_view.m_expectedsorted =  "{1,2,3,4,5,6}";
			m_view.m_mergeSort.processAction();
			Assert.assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);
		}

		@Test
		public void checkWhetherTheLengthOfBothArraysAreEqual1()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{0,4,56,16,10,2,12,22}";
			m_view.m_expectedsorted =  "{4}";
			m_view.m_mergeSort.processAction();
			Assert.assertEquals(m_view.m_unsortedArray.length(), m_view.m_actualsorted.length());
		}

		@Test(expected = NullPointerException.class)
		public void exceptionIsThrowIfAnArrayIsEmpty1()
		{
			m_view.m_unsortedArray =
			"{}";
			m_view.m_mergeSort.processAction();
			m_view.m_mergeSort.sortArray(null);
		}
		
		//presenter Tests for quicksort 
		@Test
		public void canCreateArrayWithElements()
		{
			m_view.m_SortedArray = true;
	         m_view.m_QuickSortHandler.processAction();
	         Assert.assertNotNull("4", m_view.m_quickSort);

		}

		
		@Test
		public void canSortOneElementArray1()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{4}";
			m_view.m_expectedsorted =  "{4}";
			m_view.m_quickSort.processAction();
			Assert.assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);
			
		}

		@Test
		public void canSortOTwoElementArray()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{4,3}";
			m_view.m_expectedsorted =  "{3,4}";
			m_view.m_quickSort.processAction();
			Assert.assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);
			
		}

		@Test
		public void canSortAnEvenNumberedArray()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{4,2,6,8,10,12}";
			m_view.m_expectedsorted =  "{2,4,6,8,10,12}";
			m_view.m_quickSort.processAction();
			Assert.assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);

		}

		@Test
		public void canSortAnODDNumberedArray()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{5,3,7,9,11,13}";
			m_view.m_expectedsorted =  "{3,5,7,9,11,13}";
			m_view.m_quickSort.processAction();
			assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);

		}

		@Test
		public void canSortAnMixedUnsortedArray()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{1,3,4,2,5,6,8,7,9,10}";
			m_view.m_expectedsorted =  "{1,2,3,4,5,6,7,8,9,10}";
			m_view.m_quickSort.processAction();
			Assert.assertEquals(m_view.m_expectedsorted, m_view.m_actualsorted);

		}

		@Test
		public void checkWhetherTheLengthOfBothArraysAreEqual()
		{
			m_view.m_SortedArray = true;
			m_view.m_unsortedArray = "{0,4,56,16,10,2,12,22}";
			m_view.m_expectedsorted =  "{4}";
			m_view.m_mergeSort.processAction();
			Assert.assertEquals(m_view.m_unsortedArray.length(), m_view.m_actualsorted.length());
		}
/*
		@Test(expected = NullPointerException.class)
		public void exceptionIsThrowIfAnArrayIsEmpty()
		{
			int unsorted[] =
			{};
			QuickSort quickSort = new QuickSort(unsorted);
			quickSort.sortArray(null);
		}

*/
	}



