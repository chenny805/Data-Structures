package com.alexchenny;

/*
 * Merge Sort
 * 
 * Best Case Time Complexity: O(nlogn)
 * Worst Case Time Complexity: O(nlogn)
 * Note: This sorting algorithm requires more overhead than quick sort
 * 
 * Description:
 * 		Think merge. This is a divide-and-conquer algorithm usually implemented with recursion (similar to quick sort). 
 * 		(The merge method is the key to this sorting algorithm)
 * 		The idea is:
 * 			1) pass in the unsorted array
 * 			2) divide the array into two equal sized arrays (give or take 1 index)
 * 			3) keep dividing the array until the sub array is of 1 element then return (END CONDITION)
 * 			4) use merge() method to merge the array and create a longer sub-array that's sorted (note that the real array's 
 * 				values are being updated and not the clone arrays by the merge method)
 * 			5) keep merging until recursion calls are all fulfilled
 */


public class Merge_Sort implements Sortable {

	@Override
	public double[] sort(double[] array) {
		int a = 0;
		int c = array.length-1;
		// take note of the index c = array length -1
		mergeSort(array, a, c);
		return array;
	}
	
	private static double[] mergeSort(double[] array, int a, int c) {
		if (a < c) {
//			int b = a+(c-a)/2;
			int b = (a+c)/2;
			mergeSort(array, a, b);
			mergeSort(array, b+1, c);
			merge(array, a, b ,c);
		}
		return array;
	} // end method
	
	
	private static void merge(double[] array, int a, int b, int c) {
		// size of the sub arrays
		int lSize = (b - a)+1;
		int rSize = (c - b);
		
		// create sub arrays to copy data from inputed array
		double [] lArray = new double[lSize+1];
		double [] rArray = new double[rSize+1];
		
		
		// divide and copy array to two sub arrays
		for (int i = 0; i < lSize; i ++) {
			lArray[i] = array[a+i];
		}
		for (int j = 0; j < rSize; j ++) {
			rArray[j] = array[b+j+1];
		}
		
		// set the last index of sub array to infinity for comparison later
		lArray[lSize] = Double.POSITIVE_INFINITY;
		rArray[rSize] = Double.POSITIVE_INFINITY;
		
		int i = 0;
		int j = 0;
		
		// sort the real array using sub arrays
		for (int k = a; k <= c; k++) {
			if (lArray[i] <= rArray[j]) {
				array[k] = lArray[i];
				i++;
			} else {
				array[k] = rArray[j];
				j++;
			}
		}
	} // end method

} // end class
