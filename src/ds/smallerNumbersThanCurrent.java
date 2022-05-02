package ds;

import java.util.Arrays;

public class smallerNumbersThanCurrent {

	public static void main(String[] args) {
		int nums[]=  {8,1,2,2,3};
		int arr[]=smallerNumbersThanCurrent(nums);
		printArray(arr);

	}
	 public static int[] smallerNumbersThanCurrent(int[] nums) {
		  int [] sortedArr=new int [nums.length];
		  for (int i = 0; i < nums.length; i++)
	            sortedArr[i] = nums[i];
	        Arrays.sort(sortedArr);
	        int [] output=new int [nums.length];
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
