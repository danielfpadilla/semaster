package edu.semaster.figurearea.presentation;

public class FakeView implements IView
{
	public String m_coneRadius;
	public String m_coneHeight;
	public boolean m_coneSelected = false;
	
	public String m_cubeFaceLength;
	public boolean m_cubeSelected = false;
	
	public String m_cylinderHeight;
	public String m_cylinderRadius;
	public boolean m_cylinderSelected = false;
	
	public String m_sphereRadius;
	public boolean m_sphereSelected = false;
	
	public String m_pyramidBaseLength;
	public String m_pyramidBaseHeight;
	public boolean m_squarePyramidSelected = false;
	
	public String m_torusMajorRadius;
	public String m_torusMinorRadius;
	public boolean m_torusSelected = false;
	
	public boolean m_calculateButtonState;
	public boolean m_errorIconState;
	
	public String m_area;
	public String m_warningErrorMessage;
	
	public IActionHandler m_areaHandler;
	public IActionHandler m_inputHandler;

	@Override
	public boolean coneIsSelected()
	{
		return m_coneSelected;
	}

	@Override
	public boolean cubeIsSelected()
	{
		return m_cubeSelected;
	}

	@Override
	public boolean cylinderIsSelected()
	{
		return m_cylinderSelected;

	}

	@Override
	public boolean sphereIsSelected()
	{
		return m_sphereSelected;
	}

	@Override
	public boolean squarePyramidIsSelected()
	{
		return m_squarePyramidSelected;
	}

	@Override
	public boolean torusIsSelected()
	{
		return m_torusSelected;
	}

	@Override
	public String getConeRadius()
	{
		return m_coneRadius;
	}

	@Override
	public String getConeHeight()
	{
		return m_coneHeight;
	}

	@Override
	public String getCubeEdgeLength()
	{
		return m_cubeFaceLength;
	}

	@Override
	public String getCylinderRadius()
	{
		return m_cylinderRadius;
	}

	@Override
	public String getCylinderHeight()
	{
		return m_cylinderHeight;
	}

	@Override
	public String getSphereRadius()
	{

		return m_sphereRadius;
	}

	@Override
	public String getSquareBasedPyramidBaseLength()
	{

		return m_pyramidBaseLength;
	}

	@Override
	public String getSquareBasedPyramidBaseHeight()
	{

		return m_pyramidBaseHeight;
	}

	@Override
	public String getTorusMinorRadius()
	{

		return m_torusMinorRadius;
	}

	@Override
	public String getTorusMajorRadius()
	{

		return m_torusMajorRadius;
	}

	@Override
	public void setCalculatedAreaResult(String area)
	{
		m_area = area;

	}

	@Override
	public void setCalculateAreaActionHandler(IActionHandler handler)
	{
		m_areaHandler = handler;

	}

	@Override
	public void setErrorMessage(String message)
	{
		m_warningErrorMessage = message;
	}

	@Override
	public void processInputActionHandler(IActionHandler handler)
	{
		m_inputHandler = handler;

	}

	@Override
	public void setStateOfCalculateAreaButton(boolean flag)
	{
		m_calculateButtonState = flag;

	}

	@Override
	public void setStateOfErrorIcon(boolean flag)
	{
		m_errorIconState = flag;

	}

}
