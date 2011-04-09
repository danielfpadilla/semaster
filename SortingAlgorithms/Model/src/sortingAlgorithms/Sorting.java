package sortingAlgorithms;


public abstract class Sorting
{
	public abstract String getSortingName();
	
	/*public String sortArray(int parseInt)
	{
		
		int[] iArray = null;
		String tmp = ArrayList.toString(iArray).replace(",","");
		String enconded = tmp.substring(1,tmp.length()-2);
		return null;
	
	}*/

	public int[] sortArray(int[] unsortedArray)
	{
		if (unsortedArray == null)
		{
			throw new NullPointerException("Zero Element Array");
		}
		return sortInternal(unsortedArray);
	}

	protected abstract int[] sortInternal(int[] unsortedArray);
}
