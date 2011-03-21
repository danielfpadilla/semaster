package presentation.source;

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
	public void canCalculateAreaOfCone()
	{
		m_view.m_coneRadius = "3.0";
		m_view.m_coneHeight = "4.0";
		m_view.m_coneArea.processAction();
	   assertEquals("75.398223", m_view.m_area.substring(0, 9));
		
	}
	@Test
	public void canCalculateAreaOfCube()
	{
		m_view.m_cubeFaceLength = "10";
		m_view.m_cubeArea.processAction();
		assertEquals("600.0", m_view.m_area.substring(0,5));
	}
	@Test
	public void canCalculateAreaOfCylinder()
	{
		m_view.m_cylinderRadius = "7";
		m_view.m_cylinderHeight = "10";
		m_view.m_cylinderArea.processAction();
		assertEquals("747.6990", m_view.m_area.substring(0,8));
	}
	@Test
	public void canCalculateAreaOfSphere()
	{
		m_view.m_sphereRadius = "10";
		m_view.m_sphereArea.processAction();
		assertEquals("1256.6370", m_view.m_area.substring(0, 9));
	}
	@Test
	public void canCalculateAreaOfSquareBasedPyramid()
	{
		m_view.m_pyramidBaselength = "6.0";
		m_view.m_pyramidBaseHeight = "4.0";
		m_view.m_squareBasedPyramidArea.processAction();
		assertEquals("96.0",m_view.m_area.substring(0, 4));
	}
	@Test
	public void canCalculateAreaOfTorus()
	{
		m_view.m_torusMinorRadius = "3.0";
		m_view.m_torusMajorRadius = "10.0";
		m_view.m_torusArea.processAction();
		assertEquals("1184.3525", m_view.m_area.substring(0, 9));
	}
}
