package edu.semaster.figurearea.presentation;

//import java.text.NumberFormat;

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

	private void setState()
	{
		m_view.setStateOfErrorIcon(true);
		m_view.setStateOfCalculateAreaButton(false);
		return;
	}

	protected void processUserInput()
	{
		try
		{
			m_figure = getFigure();
		} catch (InvalidParameterException ex)
		{
			m_view.setErrorMessage(ex.getErrorMessage());
			setState();
			return;
		} catch (IllegalArgumentException i)
		{
			m_view.setErrorMessage(i.getMessage());
			setState();
			return;
		} catch (ArithmeticException a)
		{
			m_view.setErrorMessage(a.getMessage());
			setState();
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
			Double.parseDouble(text);
		} catch (NumberFormatException e)
		{
			throw new InvalidParameterException(exceptionMessage);
		}
		return Double.parseDouble(text);

	}

	protected I3DFigure getFigure() throws InvalidParameterException
	{
		I3DFigure m_selectedFigure = null;
		m_view.setCalculatedAreaResult("");
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
