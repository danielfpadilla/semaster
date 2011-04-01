package Presentation;

public abstract class FakeView implements Iview
{
    public String m_helperArray;
    public String m_unsortedArray;
	public String m_expectedsorted;
	public int[] m_actualsorted;
    public boolean m_SortedArray;
    public IActionHandler m_Merge;
	public IActionHandler m_mergeSort;
	public IActionHandler m_quickSort;
	public IActionHandler m_MergeSortHandler;
	public IActionHandler m_QuickSortHandler;


	
	
	

	

	@Override
	public String sethelperArray()
	{
		return m_helperArray;
	}

	@Override
	public void setMerge(IActionHandler handler)
	{
		m_Merge = handler;
		
	}

	@Override
	public void setSortedArray(IActionHandler handler)
	{
		m_SortedArray = true;
		
	}

	@Override
	public void setMergeSortHandler(IActionHandler handler)
	{
		m_MergeSortHandler = handler;
	}

	@Override
	public void setQuickSortHandler(IActionHandler handler)
	{
	  m_QuickSortHandler = handler;
	}

	

}
