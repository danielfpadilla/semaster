package Presentation;

import org.junit.After;
import org.junit.Assert;
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
	public void canSortARandomlyGeneratedArray()
	{
		m_view.m_sorting = "QuickSort";
		m_view.m_size = "10";
		m_view.m_sortingArray.processAction();
		Assert.assertArrayEquals(expecteds, actuals);
		
	}
}
