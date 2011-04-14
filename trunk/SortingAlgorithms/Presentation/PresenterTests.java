package Presentation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PresenterTests
{
	FakeView m_view;
	Presenter m_presenter;
	private int[] expectedsorted;
	private int[] actualsorted;
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
		assertNotNull(m_view.m_sortingArray);
	}
	
	@Test
	public void canCreateAnArrayForSortingInMergesort()
	{
		m_view.m_sortingMethod = "MergeSort";
		m_view.m_sortingArray.processAction(); 
		assertNotNull(m_view.m_sortingArray);
	}
	
	
	@Test
	public void canSortARandomlyGeneratedArrayInQuickSort()
	{
		m_view.m_sortingMethod = "QuickSort";
		m_view.m_size = "10";
		int[] m_view.unsorted = "2","1","8","5","4";
		int[] actualsorted = m_view.quickSort.sortingArray(m_view.unsorted);
		int[] expectedsorted =	"1","2","4","5","8" ;
		m_view.m_sortingArray.processAction();
		assertArrayEquals(expectedsorted, actualsorted);
		
	}
	
	@Test
	public void canSortARandomlyGeneratedArrayInQuickSort()
	{
		m_view.m_sortingMethod = "MergeSort";
		m_view.m_size = "10";
		int[] m_view.unsorted = "2","1","8","5","4";
		int[] actualsorted = m_view.MergeSort.sortingArray(m_view.unsorted);
		int[] expectedsorted =	"1","2","4","5","8" ;
		m_view.m_sortingArray.processAction();
		assertArrayEquals(expectedsorted, actualsorted);
		
	}
}
