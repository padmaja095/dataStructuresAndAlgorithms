package ds.array;

public class SingleNumber {
    // Q: to find the odd number occurance of element in given array
    // Best approach: to do XOR with all the lement in the array to the one odd
    // number. beacuse eg: (3 XOR 3)=0 and (3 XOR 3 XOR 3)=3
    public static void main(String args[]) {
        int arr[] = { 1, 2, 2, 4, 2, 4, 1 };
        SingleNumber fmp = new SingleNumber();
        int oddOccNum = fmp.singleNumber(arr);
        System.out.println(oddOccNum);

    }

    public int singleNumber(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num > 0 ? num : -1;
    }
}
