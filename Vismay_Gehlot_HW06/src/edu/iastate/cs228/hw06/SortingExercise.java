package edu.iastate.cs228.hw06;


/**
 * 
 * @author Vismay Gehlot
 * 
 * NOTE:
 * 
 * 0. Put your Firstname and Lastname after above author tag.
 * 			Make sure that in both cases the first letter is uppercase
 *    and all others are lowercase.
 * 1. You are allowed to create and use your own private helper methods.
 * 2. No data fields can be introduced.
 * 3. No custom classes of your own can be introduced or used.
 * 4. Import statements are not allowed.
 * 5. Fully qualified class names usage is not allowed.
 * 6. You are allowed to reuse any part of the source codes provided
 *    or shown under lecture notes, which do not violate any of above.
 *    
 *    
 * 
 */


public class SortingExercise
{
	/**
	 * Modified implementation of in class provided quick sort code.
	 * 
	 * 
	 * The implementation of our original quick sort needs to be
	 * revised as follows in this implementation. If the array has 
	 * 23 entries, choose the middle entry as the pivot. For arrays
	 * between 24 - 50 use the last element as the pivot value. For 
	 * arrays larger than 50 entries, use the median-of-three 
	 * pivot-selection scheme described below. For arrays fewer than 
	 * 23 entries, use insertion sort instead of quick sort.
	 * 
	 * Median-of-three pivot selection chooses as pivot the median of
	 * three entries in the array, i.e., the first entry, the middle 
	 * entry, and the last entry. We will use specific version of it
	 * as follows. 
	 * 
	 * For example, let's say original array is as follows
	 * 
	 *  5, 8, 6, 4, 9, 3, 7, 1, 2
	 * 
	 * first entry = 5
	 * middle entry = 9 // index is (0+8)/2=4
	 * last entry = 2
	 * 
	 * Median of 5, 9, 2, would be 5.
	 * Check: https://en.wikipedia.org/wiki/Median
	 * 
	 * Now our array would look as follows after positioning the pivot:
	 * 
	 *  2, 8, 6, 4, 5, 3, 7, 1, 9
	 * 
	 * Now our array would look as follows just before partitioning:
	 * 
	 *  2, 5, 6, 4, 8, 3, 7, 1, 9
	 *  
	 * Our pivot is at position 1 of array, i.e., value 5.
	 * Both low and high start as shown in source code of quick sort under
	 * lecture notes, i.e., 
	 * 
	 * int low = first + 1;
	 * int high = last;
	 * 
	 * 
	 * @param arr Array of ints to be sorted in nondecreasing order.
	 */
	public static void modifiedQuickSort(int[] arr) {
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		
		quickSort(arr, 0, arr.length - 1);
	}
	
	/**
	 * implements the modified quickSort method to sort a given array
	 * @param arr array to be sorted
	 * @param low lowest index of the array
	 * @param high highest index of the array
	 */
	private static void quickSort(int[] arr, int low, int high)
	{
		if (arr.length < 23)
		{
			int temp = 0;
			for (int i = 0; i < arr.length; i++)
			{
				for (int j = i; j > 0; j--)
				{
					if (arr[j] < arr[j - 1])
					{
						temp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - i] = temp;
					}
				}
			}
		}
		
		
		
		else if (arr.length == 23)
		{
			if (high == low)
			{
				return;
			}
			
			int l = low + 1;
			int h = high;
			int m = (low + high)/2;
			int temp;
			int pivot= arr[m];
			
			while (l < h)
			{
				while (l <= h && (arr[l] - pivot) <= 0 || (pivot - arr[h]) <= 0)
				{
					if ((arr[l] - pivot) <= 0)
					{
						l++;
					}
					if ((pivot - arr[h]) <= 0)
					{
						h--;
					}
				}
				if (l <= h)
				{
					temp = arr[l];
					arr[l] = arr[h];
					arr[h] = temp;
					l++;
					h--;
				}
					
			}
			l = low;
			while((arr[l + 1] - pivot) <= 0) 
			{
				arr[l] = arr[l + 1];
				l++;
				if(l == high)break;
			}
			
			arr[l] = pivot;
			if(l > low) {
				quickSort(arr, low, l-1);
			}
			if(l<high) {
				quickSort(arr, l+1, high);
			}
		}
		
		
		
		else if (arr.length >= 24 && arr.length <= 50)
		{
			if (high == low)
			{
				return;
			}
			
			int l = low + 1;
			int h = high;
			int m = (low + high)/2;
			int temp;
			int pivot= arr[m];
			
			while (l < h)
			{
				while (l <= h && (arr[l] - pivot) <= 0 || (pivot - arr[h]) <= 0)
				{
					if ((arr[l] - pivot) <= 0)
					{
						l++;
					}
					if ((pivot - arr[h]) <= 0)
					{
						h--;
					}
				}
				if (l <= h)
				{
					temp = arr[l];
					arr[l] = arr[h];
					arr[h] = temp;
					l++;
					h--;
				}
					
			}
			l = low;
			while((arr[l + 1] - pivot) <= 0) 
			{
				arr[l] = arr[l + 1];
				l++;
				if(l == high)break;
			}
			
			arr[l] = pivot;
			if(l > low) {
				quickSort(arr, low, l-1);
			}
			if(l<high) {
				quickSort(arr, l+1, high);
			}
		}
		
		else
		{
			if (high == low)
			{
				return;
			}
			
			int l = low + 1;
			int h = high;
			int m = (low + high)/2;
			int[] tempArr = new int[3];
			tempArr[0] = arr[l];
			tempArr[1] = arr[m];
			tempArr[2] = arr[h];
			int exchange;
			int index;
			
			for (int i = 0; i < tempArr.length - 1; i++)
			{
				index = i;
				for (int j = i + 1; j < tempArr.length; j++)
				{
					if (tempArr[j] < tempArr[index])
					{
						index = j;
					}
				}
				
				exchange = tempArr[index];
				tempArr[index] = tempArr[i];
				tempArr[i] = exchange;
				
			}
			
			int temp;
			int pivot = tempArr[1];
			
			while (l < h)
			{
				while (l <= h && (arr[l] - pivot) <= 0 || (pivot - arr[h]) <= 0)
				{
					if ((arr[l] - pivot) <= 0)
					{
						l++;
					}
					if ((pivot - arr[h]) <= 0)
					{
						h--;
					}
				}
				if (l <= h)
				{
					temp = arr[l];
					arr[l] = arr[h];
					arr[h] = temp;
					l++;
					h--;
				}
					
			}
			l = low;
			while((arr[l + 1] - pivot) <= 0) 
			{
				arr[l] = arr[l + 1];
				l++;
				if(l == high)break;
			}
			
			arr[l] = pivot;
			if(l > low) {
				quickSort(arr, low, l-1);
			}
			if(l<high) {
				quickSort(arr, l+1, high);
			}
		}
	}
}
