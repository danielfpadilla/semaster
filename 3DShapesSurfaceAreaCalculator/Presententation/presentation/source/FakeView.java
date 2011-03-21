package presentation.source;

public class FakeView implements IView
{
	public String m_coneRadius;
	public String m_coneHeight;
	public String m_cubeFaceLength;
	public String m_cylinderRadius;
	public String m_cylinderHeight;
	public String m_sphereRadius;
	public String m_pyramidBaselength;
	public String m_pyramidBaseHeight;
	public String m_torusMajorRadius;
	public String m_torusMinorRadius;
	public String m_area;
	public IActionHandler m_coneArea;
	public IActionHandler m_cubeArea;
	public IActionHandler m_cylinderArea;
	public IActionHandler m_sphereArea;
	public IActionHandler m_squareBasedPyramidArea;
	public IActionHandler m_torusArea;
	
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

		return m_pyramidBaselength;
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
	public void setCalculateConeAreaActionHandler(IActionHandler handler)
	{
		m_coneArea = handler;
		
	}

	@Override
	public void setCalculateCubeAreaActionHandler(IActionHandler handler)
	{
	  m_cubeArea = handler;
		
	}

	@Override
	public void setCalculateCylinderAreaActionHandler(IActionHandler handler)
	{
		m_cylinderArea = handler;
		
	}

	@Override
	public void setCalculateSphereAreaActionHandler(IActionHandler handler)
	{
	 m_sphereArea = handler;		
	}

	@Override
	public void setCalculateSquareBasedPyramidAreaActionHandler(
			IActionHandler handler)
	{
		m_squareBasedPyramidArea = handler;
		
	}

	@Override
	public void setCalculateTorusAreaActionHandler(IActionHandler handler)
	{
		m_torusArea = handler;
		
	}

	@Override
	public void setCalculatedAreaResult(String area)
	{
		m_area = area;
		
		
	}


}
