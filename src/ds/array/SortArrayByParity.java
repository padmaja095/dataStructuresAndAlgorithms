package ds.array;

public class SortArrayByParity {
    // Q: In given array, order in the elements of the array in the way that, even
    // numbers occurs first and odd number occurs last
    // approach 1: traverse thru the array . store the odd number in obe list and
    // even in another list and merge the list. O(n) - time and O(n)- space
    // approach 2; two pointers i at 0th position and j at n-1 th position.if i is
    // odd swap and decrement j .else if i is even then increment i. while i<j
    public static void main(String args[]) {
        int arr[] = { 8, 1, 2, 2, 3 };
        SortArrayByParity fmp = new SortArrayByParity();
        printArray(fmp.sortArrayByParity(arr));
    }

    private int[] sortArrayByParity(int[] arr) {

        int i = 0;
        int j = arr.length - 1;
        while (i < j) {

            if (arr[i] % 2 != 0) {
                swap(arr, i, j);
                j--;
            } else {
                i++;
            }

        }
        return arr;

    }

    public void swap(int arr[], int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

    }
}
