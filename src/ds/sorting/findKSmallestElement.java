package ds.sorting;

import ds.QuickSort;

public class findKSmallestElement {

	public static void main(String[] args) {

		//Added Comments:
		//Intution: Divide and Conquer
		//Array A, pivot x- first element, place the first elemnet in the right position of sorting order
		// make recusive call of the same. at last merge the arrays.
		int arr[] =    {17,41,5,22,54,6,29,3,13};
		System.out.println("Given Array: before sort");
		printArray(arr);
		findKSmallestElement qs= new findKSmallestElement();
		int kSmallest=qs.quicksort(arr, 0, arr.length-1,9);
		System.out.println(kSmallest);
		

	

	}
	public int quicksort(int arr[],int p,int r,int kSmallest)
	{// p-1st lement, r- rear elemnt
		if(p<=r)
		{
			int q=partition(arr,p,r);
			if(kSmallest-1==q)
			{
				return arr[q];
			}
			else if (kSmallest-1<q)
			{
			return quicksort(arr, p, q-1,kSmallest);}
			else
			{
			return quicksort(arr, q+1, r,kSmallest);}
			
		}
		return 0;
	}
	private int partition(int[] arr, int p, int r) {
		int pivot=arr[p];
		int i=p;
		for(int j= p+1;j<=r;j++)
		{

			if (pivot > arr[j]) {
				i++;
				swap(arr, i, j);

			}

		}
		swap(arr,p,i);
		return i;
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
