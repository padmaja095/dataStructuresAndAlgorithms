package ds.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		
		//Intution: Divide and Conquer
		//Array A, pivot x- first element, place the first elemnet in the right position of sorting order
		// make recusive call of the same. at last merge the arrays.
		int arr[] =    {2,8,10,1,6,7,9,4,5};
		System.out.println("Given Array: before sort");
		printArray(arr);
		SelectionSort qs= new SelectionSort();
		qs.SelectionSort(arr);
		System.out.println("Given Array: after sort");
		printArray(arr);
		

	}
	private void SelectionSort(int[] arr) {
		
		for(int j=0;j<arr.length;j++)
		{ int iMin=j;
			for(int i=j+1;i<arr.length;i++)
			{
				if(arr[i]<arr[iMin])
				{
					iMin=i;
					
				}
			}
			if(iMin!=j)
			{
				int temp = arr[iMin];
				  arr[iMin] = arr[j]; arr[j] = temp;
			}
		}
	}
	static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
		
	}
}
