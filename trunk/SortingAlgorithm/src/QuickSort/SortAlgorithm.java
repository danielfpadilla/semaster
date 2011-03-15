package QuickSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public interface SortAlgorithm {
	public int arr = (Integer) null;

	public int[] doSort(int[] array);
	
//  public SortAlgorithm(){}
  public class QuickSort implements SortAlgorithm {
	  public int[] doSort(int[] array) {
		  {
			  
	for(int i = 0; i < arr; i++)
	  {
	
		  //array[i] = new arr[i]; 
	  }
	return array;
	  }
  }

  
  public void initializeArray(int [] a)
  {

	  for(int j = 0; j <  a.length; j++)
	  {
		  int[] array = null;
		a[j] = array[j];

	  }
	  }
public int[] quickSortAlgorithm(int[] unsortedArray)
{
    int [] sortedArray = new int[unsortedArray.length];
    for(int k = 0; k < unsortedArray.length; k++)
    {
    	sortedArray[k] = unsortedArray[k];
    }
    QuicksortRecursive(sortedArray, 0, sortedArray.length - 1);
    return sortedArray;
}



private static void QuicksortRecursive(int[] arr, int left, int right)
{
    int i = left, j = right;
    int middle = arr[(left + right)/2];
    while (i <= j)
    {
        while (arr[i] < middle)
            i++;
        while (arr[j] > middle)
            j--;
        if (i <= j)
        {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
    if (left < j)
        QuicksortRecursive(arr, left, j);
    if (i < right)
        QuicksortRecursive(arr, i, right);
}
	public static boolean arrayEquals(int [] array1, int [] array2)
	{
	
	return true;
	}

	  }
	  }
