package src;

import java.util.IllegalFormatException;

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
		catch(NumberFormatException e)
		{
		  m_view.setErrorMessage("Incorrect or Empty Input");
		  //m_view.m_calculateAreaButtonEnabled = false;
		}
		catch(IllegalFormatException e)
		{
			//m_view.setErrorMessage(e.getMessage());
			System.out.print(e.getMessage());
		}

	}

}
