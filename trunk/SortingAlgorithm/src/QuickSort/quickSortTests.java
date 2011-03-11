package QuickSort;

import junit.framework.Assert;

import org.junit.Test;

import QuickSort.SortAlgorithm.QuickSort;

public class quickSortTests {
	@Test 
	public void canCreateQuickSort()
	{
		QuickSort quicksort = new QuickSort();
		Assert.assertNotNull(quicksort);	}
	@Test 
	public void CanQuickSortArrayWithElementsBeCreated()
	{
		int[] a = new int [5];
		QuickSort quicksort  = new QuickSort();
		Assert.assertNotNull(quicksort);
	}
	@Test
	public void canInitializeArrayWithElements()
	{
		int[] a = {1, 2, 3, 4, 5};
		
		QuickSort quicksort  = new QuickSort();
		Assert.assertNull(a,quicksort.initializeArray(a));
		
	}
	@Test
	public void canSortAnUnsortedArray()
	{
		int [] unsorted  = {5, 4 , 3, 2, 1};
		QuickSort quicksort = new QuickSort();
		int [] actualsorted = quicksort.quickSortAlgorithm(unsorted); 
		int [] expectedsorted = {1, 2, 3, 4, 5};
		Assert.assertTrue(QuickSort.arrayEquals(expectedsorted ,actualsorted));
	}
}