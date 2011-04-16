package Presentation;

public class FakeView implements Iview
{
   public boolean m_mergeSortSelected = true;
   public boolean m_quickSortSelected = true;
   public String m_unsortedArray;
   public String m_sortedArray;
   public String m_size;
   public String m_setUnsortedArray;
   public IActionHandler m_sortingArrayHandler;
   public IActionHandler m_generateArrayHandler;
   public IActionHandler m_numberOfElementsHandler;
   public String m_sortingMethod;
   public String m_mergeSort;
   public String m_quickSort;
   
   
	@Override
	public String getUnsortedArray()
	{
		return m_unsortedArray;
	}

	@Override
	public void setSortedArray(String sortArray)
	{
	  m_sortArray = sortArray;

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
	public void sortingArray(IActionHandler handler)
	{
		m_sortingArray = handler;
	}

	@Override
	public void setUnsortedArray(String sortedArray)
	{
        m_unsortedArray = handler;
	}

	

}
