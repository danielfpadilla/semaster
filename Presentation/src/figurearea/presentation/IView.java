package figurearea.presentation;

public interface IView
{
	public String getConeHeight();
	public String getConeRadius();
	public boolean coneIsSelected();
	
	public String getCubeEdgeLength();
	public boolean cubeIsSelected();

	public String getCylinderRadius();
	public String getCylinderHeight();
	public boolean cylinderIsSelected();
	
	public String getSphereRadius();
	public boolean sphereIsSelected();
    
	public String getSquareBasedPyramidBaseLength();
	public String getSquareBasedPyramidBaseHeight();
	public boolean squarePyramidIsSelected();

	public String getTorusMinorRadius();
	public String getTorusMajorRadius();
	public boolean torusIsSelected();
	
	public void setCalculatedAreaResult(String area);
	public void setErrorMessage(String message);
	public void setStateOfCalculateAreaButton(boolean flag);
	public void setStateOfErrorIcon(boolean flag);

	public void processInputActionHandler(IActionHandler handler);
    public void setCalculateAreaActionHandler(IActionHandler handler);

}
