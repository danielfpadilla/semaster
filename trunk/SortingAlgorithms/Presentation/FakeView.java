package Presentation;

public class FakeView implements Iview
{
	public String m_unsortedArray;
	public String m_sortedArray;
	public String m_sorting;
	public String m_size;
	public IActionHandler m_sortingArray;
	public IActionHandler m_generateArrayHandler;
	@Override
	public String getUnsortedArray()
	{
		return m_unsortedArray;
	}

	@Override
	public void setSortedArray(String sortedArray)
	{
	  m_sortedArray = sortedArray;

	}

	@Override
	public String getArraySize()
	{
		return m_size;
	}
	@Override
	public String getSortingMethod()
	{
		return m_sortingMethod;
	}
	@Override
	public void generateRandomArray(IActionHandler handler)
	{
		m_generateArrayHandler = handler;

	}

	@Override
	public void sortArray(IActionHandler handler)
	{
		m_sortingArray = handler;
	}

	@Override
	public void setUnsortedArray(String sortedArray)
	{
        m_unsortedArray = handler;
	}

	

}
