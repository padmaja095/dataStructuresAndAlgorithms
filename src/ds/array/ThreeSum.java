package ds.array;

import java.util.Arrays;

import javax.lang.model.util.ElementScanner14;

public class ThreeSum {
    // Q: find the all possible triplets where sum of the triplets and only triplets
    // not more orless sum up to 0.
    // approach 1: have three loops i, j,k i= 0 to n-2, j=i+1 to n-1 and k= j+1 to n
    // approach 2: having two pointers . and one loop i. in a for loop , having two
    // pointer one points to left most and another o right most. decrement or
    // incrementthe pointer to find the sum to 0.
    public static void main(String args[]) {
        int arr[] = { -1, 0, 1, 2, -1, -4 };
        threeSum(arr);

    }

    private static void threeSum(int[] arr) {
        int sum = 0;
        Arrays.sort(arr);
        printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {

                sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                    j++;k--;
                } else if (sum < 0) {
                    j++;

                }
                else{
                    k--;
                }
            }

        }

    }
    static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

    }
}
