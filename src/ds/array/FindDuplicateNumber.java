package ds.array;

public class FindDuplicateNumber {
    //Q: Find the duplicate number in the array, the numbers present in the array are between 0 to n-1
    //Approach 1: using hashmap. save the 0 to n-1 as key and increment the value on traversing the array. at last find the number which as more than 1 in their respective value. time - O(n) space - O(n)
    //Approach 2: On travesing the array, negate the respective array index value of the current a[i]. and so on. if the number is already negated then it means it is duplicate number that we already negated it before.so print the same number and so on.
    public static void main(String args[])
    {
        FindDuplicateNumber fdn= new FindDuplicateNumber();
        int [] arr={1,2,3,1,3,6,6,4,4};
        fdn.findDuplicateNumber(arr);
    }
    private void findDuplicateNumber(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[Math.abs(arr[i])]>0)
                arr[Math.abs(arr[i])]=Math.negateExact(arr[Math.abs(arr[i])]);         
            else{
                //As he array doesnot originally contains negative nums. Now it has . then it is dupliccate num.
                System.out.println(Math.abs(arr[i]));
            }   
        }
    } 
}
