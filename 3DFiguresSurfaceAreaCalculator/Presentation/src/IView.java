package src;

public interface IView
{
	public boolean coneIsSelected();

	public boolean cubeIsSelected();

	public boolean cylinderIsSelected();

	public boolean sphereIsSelected();

	public boolean squarePyramidIsSelected();

	public boolean torusIsSelected();

	public String getConeHeight();

	public String getConeRadius();

	public String getCubeEdgeLength();

	public String getCylinderRadius();

	public String getCylinderHeight();

	public String getSphereRadius();

	public String getSquareBasedPyramidBaseLength();

	public String getSquareBasedPyramidBaseHeight();

	public String getTorusMinorRadius();

	public String getTorusMajorRadius();

	public void setCalculatedAreaResult(String area);

	public void setErrorMessage(String message);

	public void setStateOfCalculateAreaButton(Boolean flag);

	public void processInputActionHandler(IActionHandler handler);

	public void setCalculateAreaActionHandler(IActionHandler handler);

}
