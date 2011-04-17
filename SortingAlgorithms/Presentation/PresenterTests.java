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
		m_view.m_sortingArrayHandler.processAction(); 
		assertNotNull(m_view.m_sortingArrayHandler);
	}
	
	@Test
	public void canCreateAnArrayForSortingInMergesort()
	{
		//m_view.m_sortingMethod = "MergeSort";
		m_view.m_sortingArrayHandler.processAction(); 
		assertNotNull(m_view.m_sortingArrayHandler);
	}
	
	
	@Test
	public void canSortARandomlyGeneratedArrayQuickSort()
	{
		
		m_view.m_sortingMethod = "QuickSort";
		m_view.m_size = "5";
		String[] m_unsortedArray= {"2","1","8","5","4"};
		int[] m_actualsorted = m_view.m_quickSort.m_sortingArray(m_unsortedArray);
		int[] m_expectedsorted = {1,2,4,5,8} ;
		m_view.m_sortingArrayHandler.processAction();
		assertEquals(m_expectedsorted, m_actualsorted);
		
	}
	
	
	

	@Test
	public void canSortARandomlyGeneratedArrayMergeSort1()
	{
		m_view.m_sortingMethod = "MergeSort";
		m_view.m_size = "5";
		String[] m_unsortedArray= {"2","1","8","5","4"};
		int[] m_actualsorted = m_view.m_mergeSort.m_sortingArray(m_unsortedArray);
		int[] m_expectedsorted = {1,2,4,5,8} ;
		m_view.m_sortingArrayHandler.processAction();
		assertEquals(m_expectedsorted, m_actualsorted);
		
	}
	
}
