package project;

public class MergeSort {
	private int number;
	public MergeSort(){}
	public void sort(int[] values) {
		this.number = values;
		number = values.length;

		Mergesort(0, number - 1);
	}
//Split the Array two to create the left and right part of the array
	private void Mergesort(int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			Mergesort(left, middle);
			Mergesort(middle + 1, right);
 		    merge(left, middle, right);
			
		}
	}
//Creation of atemporary array
	private void merge(int left, int middle, int right) {

		int[]tempArray = new int[number];
		for (int i = left; i <= right; i++) {
			tempArray[i] = numbers[i];
		}

		int i = left;
		int j = middle + 1;
		int k = left;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= right) {
			if (tempArray[i] <= tempArray[j]) {
				numbers[k] = tempArray[i];
				i++;
			} else {
				numbers[k] = tempArray[j];
				j++;
			     }
			    k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = tempArray[i];
			k++;
			i++;
		}
		tempArray = null;

	}
		
	
	

	}



