package sortingCalculator;

import junit.framework.Assert;

import org.junit.Test;

public class QuickSortTests {
	@Test 
	public void canCreateQuickSort()
	{
		QuickSort quicksort = new QuickSort();
		Assert.assertNotNull(quicksort);
	}
	@Test 
	public void canCreateArrayWithElements()
	{
		int[] a = new int [5];
		QuickSort quicksort  = new QuickSort(a);
		Assert.assertNotNull(quicksort);
	}
	@Test
	public void canInitializeArrayWithElements()
	{
		int[] a = {1, 2, 3, 4, 5};
		
		QuickSort quicksort  = new QuickSort(a);
		Assert.assertEquals(a,quicksort.initializeArray(a));
		
	}
	@Test
	public void canSortAnUnsortedArray()
	{
		int [] unsorted  = {5, 4 , 3, 2, 1};
		QuickSort quicksort = new QuickSort(unsorted);
		int [] actualsorted = quicksort.quickSortAlgorithm(unsorted); 
		int [] expectedsorted = {1, 2, 3, 4, 5};
		Assert.assertTrue(QuickSort.arrayEquals(expectedsorted ,actualsorted));
	}

}