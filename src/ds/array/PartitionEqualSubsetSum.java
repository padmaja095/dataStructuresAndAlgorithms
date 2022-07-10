package ds.array;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 1, 5, 5 };
        PartitionEqualSubsetSum ms = new PartitionEqualSubsetSum();
      //  System.out.println(ms.partitionEqualSubsetSumFirstMethod(arr)
        //        + "is the starting index where the subset sum is partitioned.");
                System.out.println(ms.partitionEqualSubsetSumSecondMethod(arr)
                + "is the starting index where the subset sum is partitioned.");
                
    }

    private int partitionEqualSubsetSumFirstMethod(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int leftSum = arr[0];
        int rightSum = arr[arr.length - 1];
        while (i < j - 1) {
            if (leftSum > rightSum) {
                j--;
                rightSum += arr[j];

            } else if (leftSum < rightSum) {
                i++;
                leftSum += arr[i];
            } else {
                System.out.println("full array is not processed.");
                i++;
                j--;
            }

        }
        return i;
    }

    private int partitionEqualSubsetSumSecondMethod(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int leftSum=0;int rightSum=sum;
        for(int i=0;i<arr.length;i++)
        { 
            leftSum+=arr[i];
            rightSum-=arr[i];
            
           if(leftSum==rightSum)
           {
            return i;
           }
         

        }
        return -1;
    }
}
