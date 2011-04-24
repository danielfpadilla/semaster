package edu.semaster.figurearea.presentation;

import edu.semaster.figurearea.model.*;

public class Presenter
{
	private IView m_view;
	private I3DFigure m_figure;

	public Presenter(IView view)
	{
		m_view = view;
		m_view.setCalculateAreaActionHandler(new IActionHandler()
		{
			@Override
			public void processAction()
			{
				Presenter.this.processFigureAreaCalculation();
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

	protected void verifyInput(String string) throws InvalidParameterException
	{

		if (string.length() == 0)
		{
			throw new NumberFormatException("empty or null input");

		}
		char[] chars = new char[string.length()];
		string.getChars(0, chars.length, chars, 0);

		for (int i = 0; i < chars.length; i++)
		{
			if (!(chars[0] != '0' && '0' <= chars[i] && chars[i] <= '9' || chars[i] == '.'))
			{
				if (m_view.coneIsSelected())
					throw new InvalidParameterException(
							"Invalid cone radius or height");
				if (m_view.cubeIsSelected())
					throw new InvalidParameterException(
							"Invalid cube facelength");
				if (m_view.cylinderIsSelected())
					throw new InvalidParameterException(
							"Invalid cylinder radius or height");
				if (m_view.sphereIsSelected())
					throw new InvalidParameterException(
							"Invalid sphere radius.");
				if (m_view.squarePyramidIsSelected())
					throw new InvalidParameterException(
							"Invalid square pyramid baseLength or Height");
				if (m_view.torusIsSelected())
					throw new InvalidParameterException(
							"Invalid arguments of minor radius greater or major radius");
			}
		}

	}
	
   protected void checkTorusValidity(String a, String b)
	{
		if (Double.parseDouble(a) <= Double.parseDouble(b))
		{
			throw new ArithmeticException(
					"Major Radius less than minor radius.");
		}
	}

	protected void processUserInput()
	{
		if (m_view.coneIsSelected())
		{

			try
			{
				verifyInput(m_view.getConeRadius());
				verifyInput(m_view.getConeHeight());

			} catch (InvalidParameterException e)
			{
				m_view.setErrorMessage(e.getErrorMessage());
				m_view.setStateOfErrorIcon(true);
				m_view.setStateOfCalculateAreaButton(false);
				return;
			}
			m_view.setErrorMessage("");
			m_view.setStateOfErrorIcon(false);
			m_view.setStateOfCalculateAreaButton(true);

		}
		if (m_view.cubeIsSelected())
		{
			try
			{
				verifyInput(m_view.getCubeEdgeLength());
			} catch (InvalidParameterException e)
			{
				m_view.setErrorMessage("Invalid cube facelength");
				m_view.setStateOfErrorIcon(true);
				m_view.setStateOfCalculateAreaButton(false);
				return;
			}
			m_view.setErrorMessage("");
			m_view.setStateOfErrorIcon(false);
			m_view.setStateOfCalculateAreaButton(true);
		}
		if (m_view.cylinderIsSelected())
		{
			try
			{
				verifyInput(m_view.getCylinderRadius());

				verifyInput(m_view.getCylinderHeight());
			} catch (InvalidParameterException e)
			{
				m_view.setErrorMessage(e.getErrorMessage());
				m_view.setStateOfErrorIcon(true);
				m_view.setStateOfCalculateAreaButton(false);
				return;
			}
			m_view.setErrorMessage("");
			m_view.setStateOfErrorIcon(false);
			m_view.setStateOfCalculateAreaButton(true);
		}
		if (m_view.sphereIsSelected())
		{
			try
			{
				verifyInput(m_view.getSphereRadius());
			} catch (InvalidParameterException e)
			{
				m_view.setErrorMessage(e.getErrorMessage());
				m_view.setStateOfErrorIcon(true);
				m_view.setStateOfCalculateAreaButton(false);
				return;
			}
			m_view.setErrorMessage("");
			m_view.setStateOfErrorIcon(false);
			m_view.setStateOfCalculateAreaButton(true);

		}
		if (m_view.squarePyramidIsSelected())
		{
			try
			{
				verifyInput(m_view.getSquareBasedPyramidBaseLength());
				verifyInput(m_view.getSquareBasedPyramidBaseHeight());

			} catch (InvalidParameterException e)
			{
				m_view.setErrorMessage(e.getErrorMessage());
				m_view.setStateOfErrorIcon(true);
				m_view.setStateOfCalculateAreaButton(false);
				return;
			}

			m_view.setErrorMessage("");
			m_view.setStateOfErrorIcon(false);
			m_view.setStateOfCalculateAreaButton(true);

		}
		if (m_view.torusIsSelected())
		{

			try
			{

				verifyInput(m_view.getTorusMinorRadius());
				verifyInput(m_view.getTorusMajorRadius());
				checkTorusValidity(m_view.getTorusMajorRadius(),
						m_view.getTorusMinorRadius());

			} catch (InvalidParameterException e)
			{
				m_view.setErrorMessage(e.getErrorMessage());
				m_view.setStateOfErrorIcon(true);
				m_view.setStateOfCalculateAreaButton(false);
				return;
			} catch (ArithmeticException a)
			{
				m_view.setErrorMessage("Incorrect input : minor radius greater than major radius");
				m_view.setStateOfErrorIcon(true);
				m_view.setStateOfCalculateAreaButton(false);
				return;

			}
			m_view.setErrorMessage("");
			m_view.setStateOfErrorIcon(false);
			m_view.setStateOfCalculateAreaButton(true);

		}

	}

	protected void calculateFigureArea()
	{
		if (m_view.coneIsSelected())
		{
			m_figure = new Cone(Double.parseDouble(m_view.getConeRadius()),
					Double.parseDouble(m_view.getConeHeight()));
		}
		if (m_view.cubeIsSelected())
		{
			m_figure = new Cube(Double.parseDouble(m_view.getCubeEdgeLength()));
		}
		if (m_view.cylinderIsSelected())
		{
			m_figure = new Cylinder(Double.parseDouble(m_view
					.getCylinderRadius()), Double.parseDouble(m_view
					.getCylinderHeight()));
		}
		if (m_view.sphereIsSelected())
		{
			m_figure = new Sphere(Double.parseDouble(m_view.getSphereRadius()));
		}
		if (m_view.squarePyramidIsSelected())
		{
			m_figure = new SquareBasedPyramid(
					Double.parseDouble(m_view.getSquareBasedPyramidBaseLength()),
					Double.parseDouble(m_view.getSquareBasedPyramidBaseHeight()));
		}
		if (m_view.torusIsSelected())
		{
			m_figure = new Torus(Double.parseDouble(m_view
					.getTorusMinorRadius()), Double.parseDouble(m_view
					.getTorusMajorRadius()));
		}
		m_view.setCalculatedAreaResult(Double.toString(m_figure.calculateArea()));

	}

	protected void processFigureAreaCalculation()
	{
		try
		{
			calculateFigureArea();
		} catch (ArithmeticException e)
		{
			m_view.setErrorMessage(e.getMessage());
		}

	}

}
