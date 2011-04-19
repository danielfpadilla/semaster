package presentation;

public class FakeView implements IView
{
	public boolean m_mergeSortSelected = false;
	public boolean m_quickSortSelected = false;
	public String m_unsortedArray;
	public String m_sortedArray;
	public String m_size;
	public String m_setUnsortedArray;
	public IActionHandler m_sortingArrayHandler;
	public IActionHandler m_generateArrayHandler;
	public IActionHandler m_numberOfElementsHandler;

	@Override
	public boolean mergeSortIsSelected()
	{
		return m_mergeSortSelected;
	}

	@Override
	public boolean quickSortIsSelected()
	{
		return m_quickSortSelected;
	}

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
	public void generateRandomArray(IActionHandler handler)
	{
		m_generateArrayHandler = handler;

	}

	@Override
	public void sortArray(IActionHandler handler)
	{
		m_sortingArrayHandler = handler;
	}

	@Override
	public void selectedArraySize(IActionHandler handler)
	{
		m_numberOfElementsHandler = handler;

	}

	@Override
	public void setUnsortedArray(String unsortedArray)
	{
		m_setUnsortedArray = unsortedArray;
       
	}

	@Override
	public void sortingArray(IActionHandler handler) 
	{
		// TODO Auto-generated method stub	
	}

}
