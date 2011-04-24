package edu.semaster.figurearea.presentationtests;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.semaster.figurearea.presentation.*;

public class PresenterTests
{
	DecimalFormat m_decimalFormat = new DecimalFormat("#.#####");
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
		m_view.m_coneSelected = true;
		m_view.m_coneRadius = "3.0";
		m_view.m_coneHeight = "4.0";
		m_view.m_areaHandler.processAction();
	    assertEquals("75.39822",m_decimalFormat.format(Double.parseDouble(m_view.m_area)));

	}

	@Test
	public void canCalculateAreaOfCube()
	{
		m_view.m_cubeSelected = true;
		m_view.m_cubeFaceLength = "10";
		m_view.m_areaHandler.processAction();
		assertEquals("600", m_decimalFormat.format(Double.parseDouble(m_view.m_area)));
	}

	@Test
	public void canCalculateAreaOfCylinder()
	{
		m_view.m_cylinderSelected = true;
		m_view.m_cylinderRadius = "7";
		m_view.m_cylinderHeight = "10";
		m_view.m_areaHandler.processAction();
		assertEquals("747.69905",m_decimalFormat.format(Double.parseDouble(m_view.m_area)));
	}

	@Test
	public void canCalculateAreaOfSphere()
	{
		m_view.m_sphereSelected = true;
		m_view.m_sphereRadius = "10";
		m_view.m_areaHandler.processAction();
		assertEquals("1256.63706", m_decimalFormat.format(Double.parseDouble(m_view.m_area)));
	}

	@Test
	public void canCalculateAreaOfSquareBasedPyramid()
	{
		m_view.m_squarePyramidSelected = true;
		m_view.m_pyramidBaseLength = "6.0";
		m_view.m_pyramidBaseHeight = "4.0";
		m_view.m_areaHandler.processAction();
		assertEquals("96", m_decimalFormat.format(Double.parseDouble(m_view.m_area)));
	}

	@Test
	public void canCalculateAreaOfTorus()
	{
		m_view.m_torusSelected = true;
		m_view.m_torusMinorRadius = "3.0";
		m_view.m_torusMajorRadius = "10.0";
		m_view.m_areaHandler.processAction();
		assertEquals("1184.35253", m_decimalFormat.format(Double.parseDouble(m_view.m_area)));
	}

	@Test
	public void canProcessInputToCheckForErrorsInCone()
	{
		m_view.m_coneSelected = true;
		m_view.m_coneRadius = "3/?.0";
		m_view.m_coneHeight = "-14.0";
		m_view.m_inputHandler.processAction();
		assertEquals("Invalid cone radius or height",
				m_view.m_warningErrorMessage);

	}

	@Test
	public void canProcessInputToCheckForErrorsInCube()
	{
		m_view.m_cubeSelected = true;
		m_view.m_cubeFaceLength = "p3d";
		m_view.m_inputHandler.processAction();
		assertEquals("Invalid cube facelength", m_view.m_warningErrorMessage);

	}

	@Test
	public void canProcessInputToCheckForErrorsInCylinder()
	{
		m_view.m_cylinderSelected = true;
		m_view.m_cylinderRadius = "-7f";
		m_view.m_cylinderHeight = "#10";
		m_view.m_inputHandler.processAction();
		assertEquals("Invalid cylinder radius or height",
				m_view.m_warningErrorMessage);

	}

	@Test
	public void canProcessInputToCheckForErrorsInSphere()
	{
		m_view.m_sphereSelected = true;
		m_view.m_sphereRadius = "0.0";
		m_view.m_inputHandler.processAction();
		assertEquals("Invalid sphere radius.", m_view.m_warningErrorMessage);

	}

	@Test
	public void canProcessInputToCheckForErrorsInSquareBasedPyramid()
	{
		m_view.m_squarePyramidSelected = true;

		m_view.m_pyramidBaseLength = "-46.0";
		m_view.m_pyramidBaseHeight = "-4.0";
		m_view.m_inputHandler.processAction();
		assertEquals("Invalid square pyramid baseLength or Height",
				m_view.m_warningErrorMessage);

	}

	@Test
	public void canProcessInputToCheckForNumberFormatErrorsforInTorus()
	{
		m_view.m_torusSelected = true;
		m_view.m_torusMinorRadius = "#0.0";
		m_view.m_torusMajorRadius = "!0";
		m_view.m_inputHandler.processAction();
		assertEquals(
				"Invalid arguments of minor radius greater or major radius",
				m_view.m_warningErrorMessage);

	}

	@Test
	public void canProcessInputToCheckThatMinorRadiusIsNotGreaterThanMajorRadiusforTorus()
	{
		m_view.m_torusSelected = true;
		m_view.m_torusMinorRadius = "10.0";
		m_view.m_torusMajorRadius = "5.0";
		m_view.m_inputHandler.processAction();
		assertEquals(
				"Incorrect input : minor radius greater than major radius",
				m_view.m_warningErrorMessage);

	}

	@Test
	public void testWhetherCalculateButtonIsDisabledIncaseOfInvalidInput()
	{
		m_view.m_cubeSelected = true;
		m_view.m_cubeFaceLength = "-3ld";
		m_view.m_inputHandler.processAction();
		assertEquals(false, m_view.m_calculateButtonState);
	}

	@Test
	public void testWhetherIconIsVisibleIncaseOfWrongInput()
	{
		m_view.m_cubeSelected = true;
		m_view.m_cubeFaceLength = "#d";
		m_view.m_inputHandler.processAction();
		assertEquals(true, m_view.m_errorIconState);

	}
}
