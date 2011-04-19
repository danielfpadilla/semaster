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
	
	public void canParseArrayToString()
	{
		assertNotNull(m_view.toString());
	}
	
	public void canArraySizeBeReturned()
	{
		assertNotNull(m_view.m_numberOfElementsHandler);
	}
	
	public void canSortArandomlyGeneratedArray()
	{
		assertNotNull(m_view.m_sortingArrayHandler);
	}

	

}
