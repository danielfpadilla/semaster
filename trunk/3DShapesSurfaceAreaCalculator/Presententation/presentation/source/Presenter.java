package presentation.source;

import model.surfaceareacalculator.Cone;
import model.surfaceareacalculator.Cube;
import model.surfaceareacalculator.Cylinder;
import model.surfaceareacalculator.Sphere;
import model.surfaceareacalculator.SquareBasedPyramid;
import model.surfaceareacalculator.Torus;

public class Presenter
{
	private IView m_view;

	public Presenter(IView view)
	{
		m_view = view;
		m_view.setCalculateConeAreaActionHandler(new IActionHandler()
		{
			@Override
			public void processAction()
			{
				Presenter.this.processConeAreaCalculationAction();

			}
		});
		m_view.setCalculateCubeAreaActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				Presenter.this.processCubeAreaCalculationAction();

			}
		});
		m_view.setCalculateCylinderAreaActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				Presenter.this.processCylinderAreaCalculationAction();

			}
		});
		m_view.setCalculateSphereAreaActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				Presenter.this.processSphereAreaCalculationAction();
			}
		});
		m_view.setCalculateSquareBasedPyramidAreaActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				Presenter.this.processSquarePramidAreaCalculationAction();
			}
		});

		m_view.setCalculateTorusAreaActionHandler(new IActionHandler()
		{

			@Override
			public void processAction()
			{
				Presenter.this.processTorusAreaCalculationAction();
			}
		});

	}

	protected void processConeAreaCalculationAction()
	{
		Cone cone = new Cone(Double.parseDouble(m_view.getConeRadius()),
				Double.parseDouble(m_view.getConeHeight()));
		String coneResult = Double.toString(cone.calculateArea());
		m_view.setCalculatedAreaResult(coneResult);

	}

	protected void processCubeAreaCalculationAction()
	{
		Cube cube = new Cube(Double.parseDouble(m_view.getCubeEdgeLength()));
		String cubeResult = Double.toString(cube.calculateArea());
		m_view.setCalculatedAreaResult(cubeResult);

	}

	protected void processCylinderAreaCalculationAction()
	{
		Cylinder cylinder = new Cylinder(Double.parseDouble(m_view
				.getCylinderRadius()), Double.parseDouble(m_view
				.getCylinderHeight()));
		String cylinderResult = Double.toString(cylinder.calculateArea());
		m_view.setCalculatedAreaResult(cylinderResult);

	}

	protected void processSphereAreaCalculationAction()
	{
		Sphere sphere = new Sphere(Double.parseDouble(m_view.getSphereRadius()));
		String sphereResult = Double.toString(sphere.calculateArea());
		m_view.setCalculatedAreaResult(sphereResult);
	}

	protected void processSquarePramidAreaCalculationAction()
	{
		SquareBasedPyramid sqpyramid = new SquareBasedPyramid(
				Double.parseDouble(m_view.getSquareBasedPyramidBaseLength()),
				Double.parseDouble(m_view.getSquareBasedPyramidBaseHeight()));
		String squarePyramidResult = Double.toString(sqpyramid.calculateArea());
		m_view.setCalculatedAreaResult(squarePyramidResult);
	}

	protected void processTorusAreaCalculationAction()
	{
		Torus torus = new Torus(
				Double.parseDouble(m_view.getTorusMinorRadius()),
				Double.parseDouble(m_view.getTorusMajorRadius()));
		String torusResult = Double.toString(torus.calculateArea());
		m_view.setCalculatedAreaResult(torusResult);
	}
}
