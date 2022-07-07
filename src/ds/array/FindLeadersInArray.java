package ds.array;

import java.util.ArrayList;
import java.util.List;

public class FindLeadersInArray {
    // Q: Find the large number from the current element to right side of the array
    // apprach : have a pointer traverse from right to left.and have a variable that
    // find the max element of all traversed elements in the array. -> O(n) times
    // and O(1) space
    public static void main(String args[]) {
        int arr[] = { 17, 18, 5, 4, 6, 1 };
        FindLeadersInArray fmp = new FindLeadersInArray();
        System.out.println(fmp.findLeadersInArray(arr));
    }

    private List findLeadersInArray(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int max = arr[n - 1];
        result.add(max);
        for (int i = arr.length - 2; i >= 0; i--) {

            max = arr[i] > max ? arr[i] : max;
            if (!result.contains(max)) {
                result.add(max);
            }

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
