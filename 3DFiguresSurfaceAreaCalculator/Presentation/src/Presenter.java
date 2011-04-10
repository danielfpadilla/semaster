package src;

import src.surfaceareacalculator.Cone;
import src.surfaceareacalculator.Cube;
import src.surfaceareacalculator.Cylinder;
import src.surfaceareacalculator.I3DFigure;
import src.surfaceareacalculator.Sphere;
import src.surfaceareacalculator.SquareBasedPyramid;
import src.surfaceareacalculator.Torus;

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

	protected void verifyInput(String string)
	{
		char[] chars = new char[string.length()];
		string.getChars(0, chars.length, chars, 0);
		
		for (int i = 0; i < chars.length; i++)
		{
			if (!(chars[0]!= '0') && '0' <= chars[i] && chars[i] <= '9' || chars[i] == '.')
			{
				throw new NumberFormatException();
			}
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
			}
			catch (NumberFormatException f)
			{
				m_view.setErrorMessage("Invalid cube radius or height");
				m_view.setStateOfCalculateAreaButton(false);
			}
		}
		if (m_view.cubeIsSelected())
		{
			try
			{
				verifyInput(m_view.getCubeEdgeLength());
			}
			catch (NumberFormatException f)
			{
				m_view.setErrorMessage("Invalid cube facelength");
				m_view.setStateOfCalculateAreaButton(false);
			}
		}
		if (m_view.cylinderIsSelected())
		{
			try
			{
				verifyInput(m_view.getCylinderRadius());
				verifyInput(m_view.getCylinderHeight());
			}
			catch (NumberFormatException f)
			{
				m_view.setErrorMessage("Invalid cylinder radius or height");
				m_view.setStateOfCalculateAreaButton(false);
			}
		}
		if (m_view.sphereIsSelected())
		{
			try
			{
				verifyInput(m_view.getSphereRadius());
			}
			catch (NumberFormatException f)
			{
				m_view.setErrorMessage("Invalid sphere radius.");
				m_view.setStateOfCalculateAreaButton(false);
			}

		}
		if (m_view.squarePyramidIsSelected())
		{
			try
			{
				verifyInput(m_view.getSquareBasedPyramidBaseLength());
				verifyInput(m_view.getSquareBasedPyramidBaseHeight());

			}
			catch (NumberFormatException f)
			{
				m_view.setErrorMessage("Invalid square pyramid baseLength or Height");
				m_view.setStateOfCalculateAreaButton(false);

			}

		}
		if (m_view.torusIsSelected())
		{
			try
			{
				verifyInput(m_view.getTorusMinorRadius());
				verifyInput(m_view.getTorusMajorRadius());
			}
			catch (NumberFormatException f)
			{
				m_view.setErrorMessage("Invalid arguments or minor radius greater than major radius");
				m_view.setStateOfCalculateAreaButton(false);

			}

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
		}
		catch (ArithmeticException e)
		{
			m_view.setErrorMessage(e.getMessage());
		}

	}

}
