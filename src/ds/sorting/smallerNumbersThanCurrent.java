package ds.sorting;

import java.util.Arrays;

public class smallerNumbersThanCurrent {

	public static void main(String[] args) {
		int nums[]=  {8,1,2,2,3};
		int arr[]=smallerNumbersThanCurrent(nums);
		printArray(arr);

	}
	 public static int[] smallerNumbersThanCurrent(int[] nums) {
		 //copy the original aray to new array for sorting.
		  int [] sortedArr=new int [nums.length];
		  for (int i = 0; i < nums.length; i++)
	            sortedArr[i] = nums[i];
	        Arrays.sort(sortedArr);
	        //create a new output array
	        int [] output=new int [nums.length];
	        //linear search(first occurance and then break) the element in the sorted array for all nums.
	        //the resaon for finding first occurance is , the index of it, is the actual number that is smaller then current.
	        //For eg. sorted arr: 12238 =>(0)-1,(1)-2,(2)-2,(3)-3,(4)-8
	        //return the output
	        for(int i=0;i<nums.length;i++)
	        {
	        	for (int j=0;j<sortedArr.length;j++)
	        	{
	        		if(nums[i]==sortedArr[j])
	        		{
	        			output[i]=j;
	        			break;
	        		}
	        	}
	        	 
	        }
	        return output;
	        
	    }
	 static void printArray(int[] arr) {

			int n = arr.length;
			for (int i = 0; i < n; ++i)
				System.out.print(arr[i] + " ");
			System.out.println();

		}

}
