package project;

public class QuickSort {

		public int [] array = new int [5];
		
		public QuickSort(){}

		public int [] InitializeArray(int [] arr)
		  {
			  for(int i = 0; i < arr.length; i++)
			  {
				  array[i] = arr[i];
			  }
			return arr;
			}


	public int [] initializeArray(int [] a)
	{
		  for(int j = 0; j < a.length; j++)
		  {
			  a[j] = array[j];
		  }
		return a;
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



	private static void QuicksortRecursive(int[] arr, int low, int high)
	{
	    int i = low, j = high;
	    int middle = arr[(low + high)/2];
	    while (i <= j)
	    {
	        while (arr[i] < middle)
	            i++;
	        while (arr[j] > middle)
	            j--;
	        if (i <= j)
	        {
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            i++;
	            j--;
	        }
	   }
	           if (low < j)
	                QuicksortRecursive(arr, low, j);
	                   if (i < high)
	                QuicksortRecursive(arr, i, high);
	}
		public static boolean arrayEquals(int [] array1, int [] array2)
		{
		
		return true;
		}

	}



