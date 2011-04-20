package presentation;

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
	public void canMergeSortMethodBeSelectedForSorting()
	{
		assertNotNull(m_view.m_mergeSortSelected);
	}
	
	@Test
	public void canQuickSortMethodBeSelectedForArraySorting()
	{
		assertNotNull(m_view.m_quickSortSelected);
	}
	
	
	
	
	

}
