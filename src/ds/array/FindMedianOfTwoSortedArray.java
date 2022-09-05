package ds.array;

public class FindMedianOfTwoSortedArray {
    // Q: Median is arr(arraysize/2)+1 if odd,when even [arr(arraysize/2) +
    // arr(arraysize/2)+1]/2
    // Approach 1: Given two sorted array, we can leverage merge fn of mergesort to
    // sort into single array and then find the median based on formula of odd or
    // even.
    // it can be done by without using temporary array for output. as we know m+n
    // value, have a counter untill it reaches the counter(m+n) and then print the
    // value. time O(m+n) and space O(1) if not using temporary array.
    // Approach 2:Logarthmic algo.-> modifying the binary search
    public static void main(String args[]) {
        int m[] = { 1, 3, 5, 6, 7, 8, 9, 11 };
        int n[] = { 1, 4, 6, 8, 12, 14, 15, 17 };
        // int m[] = { 1,3,5,7};
        // int n[] = { 1,2,4};
        findMedianMergeSortedArray(m, n);
    }

    private static void findMedianMergeSortedArray(int[] m, int[] n) {
        int i = 0;
        int j = 0;
        int count = 0;
        boolean even =(m.length + n.length) % 2 == 0;
        while (i < m.length && j < n.length) {
            count++;
            if (count == ((m.length + n.length) / 2)) {
                if (!even) {
                    System.out.println(m[i]);
                } else {
                    System.out.println(m[i] + ":" + n[j]);
                }
                return;
            }
            if (m[i] < n[j]) {
                i++;
            } else if (m[i] >= n[j]) {
                j++;
            }
        }
    }
}
