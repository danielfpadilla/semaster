package Presentation;

public interface Iview
{
	public String getLeft();

	public String getRight();

	public String getPivot();
	
	public String getsortedArray();
	
	public String getunsortedArray();
	
	public String sethelperArray();
	
	public void setsortedArray(String string);
	
	public void setunsortedArray(String string);
	
	public void setexpectedsorted(String string);
	
	public void setactualsorted(String string);
	
	public void setMerge(String string);

	public void setSortedArray(String string);

	public void setMergeSortHandler(IActionHandler handler);

	public void setQuickSortHandler(IActionHandler handler);

	public void setMerge(IActionHandler handler);

	public void setSortedArray(IActionHandler handler);
	


}
