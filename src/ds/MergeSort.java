package ds;

public class MergeSort {

	public static void main(String[] args) {
		// initialize the array arr.
		// create a merge sort class object and caaling the sort method.
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		System.out.println("Given Array");
		printArray(arr);
		MergeSort ms = new MergeSort();
		ms.sort(arr, 0, arr.length - 1);
		System.out.println("\nSorted array");
		printArray(arr);

	}

	 void sort(int[] arr, int l, int r) {
		// using divide and conquer
		// using split the array to half and so on using recusrion untill with single
		// element.
		// from there comapre and swap the element in a array.
       System.out.println(l);
		if (l < r) {
			// Find the middle element
			int m = (l + r) / 2;
			//recursive call for left sub array
			sort(arr, l, m);
			//recursive call for right sub array
			sort(arr, m + 1, r);
			//merge the left and right sub array. eventually the entire array.
			merge(arr, l, m, r);
		}

	}

	 void merge(int[] arr, int l, int m, int r) {
		//Find sizes of two arrays that to be merged
		int n1 = m - l + 1; // n1 + m th element
		int n2 = r - m;
		
		//create the temp arrays
		int L[] = new int[n1];
        int R[] = new int[n2];
        
        //Copy data to temp arrays
        for (int i = 0; i< n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
        
        //Merge the temp arrays//
        
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        
        
	}

	 static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
		
	}

}
