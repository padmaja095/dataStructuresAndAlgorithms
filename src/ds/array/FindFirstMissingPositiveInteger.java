package ds.array;

public class FindFirstMissingPositiveInteger {
    //Q: Given an unsorted integer array, find the smallest missing positive integer. also contains negative numbers
    //Appraoch 1: sort the array. exclude the neagtive numbers its no one.on the next traversal, have a varable for noting the postive number. if the difference of the current and previous is 1. move on. if not print the number as missing. time O(n log n)
    //Approach 2: Bit tricky. it is based on finding the duplicate number in the array problem with sime modulation(refer the problem that solved)
    //step 1: if 1 is not present in the array print 1 else ,update the negative , 0, array value that has more than n To 1
    //step 2: On travesing the array, negate the respective array index value of the current a[i] . if it already negated leave it as so.
    //step 3: Find the firstof : the index of array which value is not negative and break.
    public static void main(String args[])
    {
        FindFirstMissingPositiveInteger fmpi= new FindFirstMissingPositiveInteger();
         int[] arr={3,4,-1,-2,1,5,16,0,2,0};
        fmpi.findFirstMissingPositiveInteger(arr);
    }

    private void findFirstMissingPositiveInteger(int[] arr) {
       int n=arr.length;
       boolean isOnePresent=false;
       for(int i=0;i<n;i++)
       {
        if(arr[i]==1)
        {
            isOnePresent=true;
        }
    }
        if(isOnePresent)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[j]<=0 || arr[j]>n)
                {
                    arr[j]=1;
                }
            }
            for(int k=0;k<n;k++)
            {
                if(arr[Math.abs(arr[k])]>0)
                    arr[arr[k]]=Math.negateExact(arr[arr[k]]);
            }
            for(int l=1;l<n;l++)
            {
                if(arr[l]>0)
                {
                    System.out.println("positive interher is "+ l);
                    break;
                }
            }
        }
        else{
            System.out.println("The first Missing Positive integer is 1");
        }
       }
       static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

    }
    
    
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           