package com.alexchenny;

/*
 * Quick Sort
 * 
 * Best Case Time Complexity: O(nlogn)
 * Worst Case Time Complexity: O(n^2)
 * 
 * Description:
 * 		Think partition. This is a divide-and-conquer algorithm usually implemented with recursion. 
 * 		The idea is:
 * 			1) pass in the unsorted array
 * 			2) pick pivot index (usually the last index of the array. For the best result
 * 				make sure that the pivot is the median value of the entire array, and put it in the last index)
 * 			3) sort the array from the first index to (array.length-1) so that number on the left
 * 				of i has a smaller value than the pivot and number on the right of i has a bigger value than the pivot.
 * 			4) replace i+1 with pivot
 * 			5) recursively call QuickSort(array, first index, last index) with the updated values 
 * 				to sort left of the pivot and right of the pivot (hence the divide and conquer approach)
 */

public class Quick_Sort implements Sortable {

	/*
	 * Start sorting algorithm by first getting the first and last index of
	 * array
	 */
	public double[] sort(double[] array) {
		// finding the range of the array
		int lastIndex = array.length-1;
		int firstIndex = 0;
		// start sorting algorithm (recursive)
		quickSort(array, firstIndex, lastIndex);

		return array;
	} // end method

	/*
	 * Description: 
	 * 			Start the quick sort algorithm, pick the pivot value and
	 * 			recursively sort the array by dividing the array into smaller sections.
	 * Input: 
	 * 			The array to be sorted, an index range to sort (given that some
	 *	 		part of the array is already sorted) 
	 *Output: 
	 *			A new index where the all
	 * 			numbers to the left are smaller and all numbers to the right are bigger.
	 */
	private static void quickSort(double[] array, int a, int b) {
		int pivot = 0;
		// sort every index
		if (a < b) {
			// retrieve the current pivot value
			pivot = partition(array, a, b);
			// sort all index from 0 to one less than current pivot
			quickSort(array, a, pivot - 1);
			// sort all index from current pivot plus one to last index
			quickSort(array, pivot + 1, b);
		} 
	}

	/*
	 * Description: 
	 * 				Sort the array so that all all values to the left is smaller 
	 * 				than the pivot value, and all values to the right are bigger.
	 * Input:
	 * 				The array and the range indices to be sorted.
	 * Output: 
	 *				Return position of pivot value (which is sorted)
	 * 
	 */
	private static int partition(double[] array, int a, int b) {
		double pivot = array[b];
		int i = a-1;
		// iterate from index [ a, b]
		for (int j = a; j < b; j++) {
			// if value at index j is greater than pivot
			if (array[j] > pivot) {
			} else {
				i++;
				double temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		} // end for loop
		// exchange pivot with i+1 value
		double temp = array[i+1];
		array[i+1] = array[b];
		array[b] = temp;
		// return new pivot
		return i+1;
	}

} // end class
