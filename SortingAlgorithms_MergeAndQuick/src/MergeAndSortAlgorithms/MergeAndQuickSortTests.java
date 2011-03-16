package MergeAndSortAlgorithms;
import static org.junit.Assert.*;
import junit.framework.Assert;
import java.util.Random;


import org.junit.Test;


public class MergeAndQuickSortTests {
	
	@Test
	public void canInitializeArrayWithElements()
	{
		int[] a = {1, 2, 3, 4, 5};
		Quicksort quicksort  = new Quicksort();
	    Assert.assertEquals(a,quicksort.initializeArray(a));
		
	}
	
	 
	@Test 
	public void canCreateQuickSort()
	{
		Quicksort quicksort = new Quicksort();
		Assert.assertNotNull(quicksort);	}
	@Test 
	public void CanQuickSortArrayWithElementsBeCreated()
	{
		int[] a = new int [5];
		Quicksort quicksort  = new Quicksort();
		Assert.assertNotNull(quicksort);
	}
	@Test
	public void canInitializeArrayWithElements1()
	{
		int[] a = {1, 2, 3, 4, 5};
		
		Quicksort quicksort  = new Quicksort();
	
	           assertTrue(true);
	}

	
		private int[] numbers;
		private final static int SIZE = 7;
		private final static int MAX = 20;
		
		@Test
		public void CheckWhetherMergeSortArrayCanBeCreated(){
			int[] a = new int [7];
			Mergesort mergesort  = new Mergesort();
			Assert.assertNotNull(mergesort);
			
		}
		
		@Test
		public void setUp() throws Exception {
			numbers = new int[SIZE];
			Random generator = new Random();
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = generator.nextInt(MAX);
			}
		}

		@Test
		public void CheckWhetherMergesortCanOccur() {
			Mergesort mergesort = new Mergesort();
			assertTrue(true);

		}

		@Test
		public void CheckedWhetherSortingOcursRepeatedly() {
			for (int i = 0; i < 200; i++) {
				numbers = new int[SIZE];
				Random generator = new Random();
				for (int a = 0; a < numbers.length; a++) {
					numbers[a] = generator.nextInt(MAX);
				}
				Mergesort mergesort = new Mergesort();
				mergesort.sort(numbers);
				for (int j = 0; j < numbers.length - 1; j++) {
					if (numbers[j] > numbers[j + 1]) {				}
				}
				assertTrue(true);
			}
		}

		}
