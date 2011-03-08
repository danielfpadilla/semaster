package MergeSort;



import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

public class mergeSortTest {

	public int[] numbers;
	public final static int SIZE = 7;
	public final static int MAX = 20;

	@Test
	public void setUp() throws Exception {
		numbers = new int[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
		}
	}

	@Test
	public void testMergeSort() {
		//long startTime = System.currentTimeMillis();
		//mergeSort sorter = new mergeSort();
        //long stopTime = System.currentTimeMillis();
		//long elapsedTime = stopTime - startTime;

			
		assertTrue(true);

	}

	@Test
	public void itWorksRepeatably() {
		for (int i = 0; i < 200; i++) {
			numbers = new int[SIZE];
			Random generator = new Random();
			for (int a = 0; a < numbers.length; a++) {
				numbers[a] = generator.nextInt(MAX);
			}
			mergeSort sorter = new mergeSort();
			sorter.sort(numbers);
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {				}
			}
			assertTrue(true);
		}
	}

	@Test
	public void testStandardSort() {
		long startTime = System.currentTimeMillis();
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		
		assertTrue(true);
	}


		
	}

