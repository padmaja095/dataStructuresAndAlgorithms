package ds.array;

import java.util.Arrays;

public class SmallerThanCurrentNumber {
    //Q: Given an array find the total number of smaller elements than current number for all elements in the array.
    //appraoch 1: sort the array and store the value as key and number of occurance of that as value in hashtable or hashmap. and compare the original array and form the output array from hashmap values. -> O(n log n)-time and O(n) - space
    //apprach 2: based on the constraint that numbers can be 1 to 100, we can form array of size 100 and initiaze all to 0. and loop the orginal array and increment the index for number present in array.
    //once done , find the prefix sum: like fibonacci adding the present and previos value.so that for number 8 . the previous index value is 4. means as we are adding . it tells the numbers less than 8. -> O(n) time and O(c) space c=100 constant
   public static void main(String args[])
   {
    int arr[] = { 8,1,2,2,3 };
    SmallerThanCurrentNumber fmp = new SmallerThanCurrentNumber();
    printArray(fmp.smallerThanCurrentNumber(arr));
   }
//second approach
private int[] smallerThanCurrentNumber(int[] arr) {

     int []bigArr= new int[101];
     int[] result= new int[arr.length];
    //Arrays.fill(bigArr, 0);
    for(int i=0;i<arr.length;i++)
    {
        bigArr[arr[i]]+=1;
    }
    for (int i=1;i<bigArr.length;i++)
    {
        bigArr[i]+=bigArr[i-1];

    }
    for(int i=0;i<arr.length;i++)
    {
        result[i]=bigArr[arr[i]-1];

    }
    return result;
}
static void printArray(int[] arr) {

    int n = arr.length;
    for (int i = 0; i < n; ++i)
        System.out.print(arr[i] + " ");
    System.out.println();

}
}
