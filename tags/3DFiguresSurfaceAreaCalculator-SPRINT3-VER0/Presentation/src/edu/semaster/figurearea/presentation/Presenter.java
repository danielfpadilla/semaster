package edu.semaster.figurearea.presentation;

import edu.semaster.figurearea.model.*;

public class Presenter
{

	private I3DFigure m_figure;
	private IView m_view;

	public Presenter(IView view)
	{
		m_view = view;
		m_view.setCalculateAreaActionHandler(new IActionHandler()
		{
			@Override
			public void processAction()
			{
				Presenter.this.calculateFigureArea();
			}
		});
		m_view.processInputActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				Presenter.this.processUserInput();

			}
		});
	}

	protected void processUserInput()
	{
		try
		{
			m_figure = getFigure();
		} catch (InvalidParameterException ex)
		{
			m_view.setErrorMessage(ex.getErrorMessage());
			m_view.setStateOfErrorIcon(true);
			m_view.setStateOfCalculateAreaButton(false);
			return;
		}

		m_view.setErrorMessage("");
		m_view.setStateOfErrorIcon(false);
		m_view.setStateOfCalculateAreaButton(true);

	}

	protected void verifyInput(String text, String exceptionMessage)
			throws InvalidParameterException
	{
		try
		{
			if (text.length() == 0)
			{
				throw new InvalidParameterException("Empty or null input");
			}
			double val = Double.parseDouble(text);
			if (val <= 0)
			{
				throw new InvalidParameterException(
						"Negative argument not allowed");
			}

		} catch (NumberFormatException e)
		{
			throw new InvalidParameterException(exceptionMessage);
		}

	}

	protected void checkTorusValidity(String a, String b)
			throws InvalidParameterException
	{
		if (Double.parseDouble(a) <= Double.parseDouble(b))
		{
			throw new InvalidParameterException(
					"Incorrect input : minor radius greater than major radius");
		}
	}

	protected I3DFigure getFigure() throws InvalidParameterException
	{
		I3DFigure m_selectedFigure = null;
		if (m_view.coneIsSelected())
		{
			verifyInput(m_view.getConeRadius(), "Invalid cone radius");
			verifyInput(m_view.getConeHeight(), "Invalid cone height");
			m_selectedFigure = new Cone(Double.parseDouble(m_view
					.getConeRadius()), Double.parseDouble(m_view
					.getConeHeight()));

		}
		if (m_view.cubeIsSelected())
		{
			verifyInput(m_view.getCubeEdgeLength(), "Invalid cube facelength");
			m_selectedFigure = new Cube(Double.parseDouble(m_view
					.getCubeEdgeLength()));
		}
		if (m_view.cylinderIsSelected())
		{
			verifyInput(m_view.getCylinderRadius(), "Invalid Cylinder radius");
			verifyInput(m_view.getCylinderHeight(), "Invalid Cylinder height");
			m_selectedFigure = new Cylinder(Double.parseDouble(m_view
					.getCylinderRadius()), Double.parseDouble(m_view
					.getCylinderHeight()));
		}
		if (m_view.sphereIsSelected())
		{
			verifyInput(m_view.getSphereRadius(), "Invalid Sphere radius");

			m_selectedFigure = new Sphere(Double.parseDouble(m_view
					.getSphereRadius()));

		}
		if (m_view.squarePyramidIsSelected())
		{
			verifyInput(m_view.getSquareBasedPyramidBaseLength(),
					"Invalid Pyramid base length");
			verifyInput(m_view.getSquareBasedPyramidBaseHeight(),
					"Invalid Pyramid base height");
			m_selectedFigure = new SquareBasedPyramid(
					Double.parseDouble(m_view.getSquareBasedPyramidBaseLength()),
					Double.parseDouble(m_view.getSquareBasedPyramidBaseHeight()));
		}
		if (m_view.torusIsSelected())
		{
			verifyInput(m_view.getTorusMinorRadius(),
					"Invalid torus minor radius");
			verifyInput(m_view.getTorusMajorRadius(),
					"Invalid torus major radius");
			checkTorusValidity(m_view.getTorusMajorRadius(),
					m_view.getTorusMinorRadius());
			m_selectedFigure = new Torus(Double.parseDouble(m_view
					.getTorusMinorRadius()), Double.parseDouble(m_view
					.getTorusMajorRadius()));
		}
		return m_selectedFigure;
	}

	protected void calculateFigureArea()
	{
		try
		{
			m_figure = getFigure();
			m_view.setCalculatedAreaResult(Double.toString(m_figure
					.calculateArea()));
		} catch (InvalidParameterException e)
		{

		}
	}

}
