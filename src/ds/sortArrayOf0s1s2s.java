package ds;

import java.util.Arrays;

public class sortArrayOf0s1s2s {
	// Problem statement: Sort array of 0's 1's 2's
	// Two ways to solve with O(n) .
	// 1. two times parsing the array.
	// 2. one time parsing the array
	public static void main(String args[]) {
	     int arr[] = {  0, 1, 0, 1, 2, 0, 0, 1, 2 };
		printArray(arr);
		//twoParsingToSortArray(arr);
		oneParsingToSortArray(arr);
		printArray(arr);


	}

	 
	private static void oneParsingToSortArray(int[] arr) {
		int C=0,L=0;
		int H=arr.length-1;
		while(C<=H)
		{
			if(arr[C]==0)
			{
				int temp=arr[C];
				arr[C]=arr[L];
				arr[L]=temp;
				C++;L++;
			}else if(arr[C]==1)
			{C++;
				
			}else if(arr[C]==2)
			{
				int temp=arr[C];
				arr[C]=arr[H];
				arr[H]=temp;
				H--;
			}
			
		}

	}

	private static void twoParsingToSortArray(int[] arr) {
		int arr0 = 0, arr1 = 0, arr2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr0 += 1;
			} else if (arr[i] == 1) {
				arr1 += 1;
			} else {
				arr2 += 1;
			}

		}
		for (int i = 0; i < arr0; i++) {
			arr[i] = 0;

		}
		for (int i = 0; i < arr1; i++) {
			arr[arr0 + i] = 1;
		}
		for (int i = 0; i < arr2; i++) {
			arr[arr0 + arr1 + i] = 2;
		}

	}

	static void printArray(int[] arr) {

		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();

	}
}
