package edu.semaster.sortingAlgorithms.presentationTestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import edu.semaster.sortingAlgorithms.presentation.*;

public class PresenterTestCases
{
	FakeView m_view;
	Presenter m_presenter;
	
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
	public void canSortingTakePlace()
	{
	 assertNotNull(m_view.m_sortingArrayHandler);	
	}
	
	@Test
	public void canGenerateRandomArray()
	{
	   assertNotNull(m_view.m_generateArrayHandler);
	}
	
	@Test
	public void canParseArrayToString()
	{
		assertNotNull(m_view.toString());
	}
	
	@Test
	public void canParseArraySize()
	{
		assertNotNull(m_view.m_numberOfElementsHandler);
	}
	
	@Test
	public void canReturnArraySize()
	{
		assertNotNull(m_view.m_numberOfElementsHandler);
	}
	
	@Test
	public void canMergeSortAlgorithmBeSelectedForSorting()
	{
		assertNotNull(m_view.m_mergeSortSelected);
	}
	
	@Test
	public void canQuickSortAlgorithmBeSelectedForArraySorting()
	{
		assertNotNull(m_view.m_quickSortSelected);
	}
	
	@Test
	public void canRandomlyGeneratedArrayBeSortedWithQuickSort()
	{
		m_view.m_sortingMethod = "QuickSort";
		m_view.m_size = "10";
		m_view.m_unsortedArray = "4 432 565 2";
		m_view.m_sortedArray = "2 4 432 565";
		assertEquals("4 432 565 2",m_view.m_unsortedArray);
		
	}
	@Test
	public void canRandomlyGeneratedArrayBeSortedWithMergeSort()
	{
		m_view.m_sortingMethod = "MergeSort";
		m_view.m_size = "10";
		m_view.m_unsortedArray = "4 432 565 2";
		m_view.m_sortedArray = "2 4 432 565";
		assertEquals("2 4 432 565",m_view.m_sortedArray);
		
	}
	
	
	
	
	

}