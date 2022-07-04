package ds.array;

public class FindMissingNumber {
    //Find Missing number, given array arr[] and int n. where the array consists of 1 to n .
    //2 ways: 1. n(n+1)/2 to find addition of all value from 1 to n and subtract with sum of given array to find the missing number.
    //this method causes overflow
    //2. using XOR to do the same.the below will be implemented with this method
    public static void main(String args[])
    {
        int arr[] =    {1,2,5,4,6,10,9,8,7};
        FindMissingNumber fmp= new FindMissingNumber();
        int missingNum=fmp.findMissingNumber( arr , 10);
        System.out.println(missingNum);
        
    }
    public int findMissingNumber(int arr[],int n)
    {
        int x1=0;
        for(int i=1;i<=n;i++){
            x1=x1^i;
        }
        int x2=0;
        for(int i=0;i<arr.length;i++)
        {
            x2=x2^arr[i];
        }
        return x1^x2;
    }
    
}
