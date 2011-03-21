package presentation.source;

public interface IView
{
	public String getConeRadius();

	public String getConeHeight();

	public String getCubeEdgeLength();

	public String getCylinderRadius();

	public String getCylinderHeight();

	public String getSphereRadius();

	public String getSquareBasedPyramidBaseLength();

	public String getSquareBasedPyramidBaseHeight();

	public String getTorusMinorRadius();

	public String getTorusMajorRadius();

	public void setCalculatedAreaResult(String area);

	public void setCalculateConeAreaActionHandler(IActionHandler handler);

	public void setCalculateCubeAreaActionHandler(IActionHandler handler);

	public void setCalculateCylinderAreaActionHandler(IActionHandler handler);

	public void setCalculateSphereAreaActionHandler(IActionHandler handler);

	public void setCalculateSquareBasedPyramidAreaActionHandler(
			IActionHandler handler);

	public void setCalculateTorusAreaActionHandler(IActionHandler handler);

}
