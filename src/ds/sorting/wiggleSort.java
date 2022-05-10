package ds.sorting;

import java.util.Arrays;

import ds.MergeSort;

public class wiggleSort {

	public static void main(String[] args) {
		int arr[] = { 3, 5, 2, 1, 6, 0};
		System.out.println("Given Array");
		printArray(arr);
		wiggleSort ws = new wiggleSort();
		//ws.firstApproach(arr,arr.length);
		ws.secondApproach(arr,arr.length);
		System.out.println("After Applying Wiggle Sort:");
		printArray(arr);

	}

	 private void secondApproach(int[] arr, int length) {
		//O(n) - as we parsing th ewhole array only once n elements.
		 //{3,5,1,6,2,4}
		 for(int i=1;i<length;i+=2)
		 {
			 if(arr[i]<arr[i-1])
			 {
				 swap(arr,i,i-1);
			 }
			 if( i<length-1 && arr[i]<arr[i+1] )
			 {
				 swap(arr,i,i+1);
				 
			 }
			 
		 }
		
	}

	private void firstApproach(int[] arr, int length) { 
		//O(nlogn) - beacuse of using sorting algorithm
		Arrays.sort(arr);
		//{1,2,3,4,5,6}
		for(int i=1;i<length-1;i+=2)
		{
			swap(arr,i,i+1);
		}
		
		
	}

	  static void swap(int arr[],int i, int j) { if(i!=j) { int temp = arr[i];
	  arr[i] = arr[j]; arr[j] = temp; }
	
		
	}

	static void printArray(int[] arr) {

	        int n = arr.length;
	        for (int i = 0; i < n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
			
		}
}
