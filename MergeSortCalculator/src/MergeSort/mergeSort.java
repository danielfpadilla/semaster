package MergeSort;

public class mergeSort {
	public int[] numbers;

	public int number;

	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;

		mergeSort(0, number - 1);
	}

	private void mergeSort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {

		int[]tmpArray = new int[number];
		for (int i = low; i <= high; i++) {
			tmpArray[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (tmpArray[i] <= tmpArray[j]) {
				numbers[k] = tmpArray[i];
				i++;
			} else {
				numbers[k] = tmpArray[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = tmpArray[i];
			k++;
			i++;
		}
		tmpArray = null;

	}
		
	
	
	

}
