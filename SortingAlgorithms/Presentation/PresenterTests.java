package Presentation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PresenterTests
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
	public void canCreateAnArrayForSortingInQuicksort()
	{
		m_view.m_sortingMethod =  "QuickSort";
		m_view.m_sortingArray.processAction(); 
		assertNotNull(m_quickSort);
	}
	
	@Test
	public void canCreateAnArrayForSortingInMergesort()
	{
		m_view.m_sortingMethod = "MergeSort";
		m_view.m_sortingArray.processAction(); 
		assertNotNull(m_mergeSort);
	}
	
	
	@Test
	public void canSortARandomlyGeneratedArrayInQuickSort()
	{
		m_view.m_sortingMethod = "QuickSort";
		m_view.m_size = "10";
		int[] m_view.unsorted = {"9","3","10","6","7","2","1","8","5","4"};
		int[] m_actualsorted = m_view.quickSort.sortingprocess(m_view.unsorted);
		int[] m_expectedsorted =	{1,2,3,4,5,6,7,8,9,10} ;
		m_view.m_sortingprocess.processAction();
		assertArrayEquals(m_expectedsorted, m_actualsorted);
		
	}
	
	@Test
	public void canSortARandomlyGeneratedArrayInQuickSort()
	{
		m_view.m_sortingMethod = "MergeSort";
		m_view.m_size = "10";
		int[] m_view.m_unsorted = {"9","3","10","6","7","2","1","8","5","4"};
		int[] m_actualsorted = m_view.MergeSort.sortingprocess(m_view.m_unsorted);
		int[] m_expectedsorted =	{1,2,3,4,5,6,7,8,9,10} ;
		m_view.m_sortingprocess.processAction();
		assertEquals(m_expectedsorted, m_actualsorted);
		
	}
}
