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

	protected double verifyInput(String text, String exceptionMessage)
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
		return Double.parseDouble(text);

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
			m_selectedFigure = new Cone(verifyInput(m_view.getConeRadius(),
					"Invalid cone radius"), verifyInput(m_view.getConeHeight(),
					"Invalid cone height"));

		}
		if (m_view.cubeIsSelected())
		{
			m_selectedFigure = new Cube(verifyInput(m_view.getCubeEdgeLength(),
					"Invalid cube facelength"));
		}
		if (m_view.cylinderIsSelected())
		{
			m_selectedFigure = new Cylinder(verifyInput(
					m_view.getCylinderRadius(), "Invalid Cylinder radius"),
					verifyInput(m_view.getCylinderHeight(),
							"Invalid Cylinder height"));
		}
		if (m_view.sphereIsSelected())
		{
			m_selectedFigure = new Sphere(verifyInput(m_view.getSphereRadius(),
					"Invalid Sphere radius"));

		}
		if (m_view.squarePyramidIsSelected())
		{
			m_selectedFigure = new SquareBasedPyramid(verifyInput(
					m_view.getSquareBasedPyramidBaseLength(),
					"Invalid Pyramid base length"), verifyInput(
					m_view.getSquareBasedPyramidBaseHeight(),
					"Invalid Pyramid base height"));
		}
		if (m_view.torusIsSelected())
		{
			m_selectedFigure = new Torus(
					verifyInput(m_view.getTorusMinorRadius(),
							"Invalid torus minor radius"), verifyInput(
							m_view.getTorusMajorRadius(),
							"Invalid torus major radius"));
			checkTorusValidity(m_view.getTorusMajorRadius(),
					m_view.getTorusMinorRadius());
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
