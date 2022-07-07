package ds.array;

public class SortedRotatedArray {
    // Q: Given array which sorted and rotated t times, given sum. To find whether 2
    // elemnts of arry makes the sum .return tru or false
    // approach : in unsorted array it takes O(n^2) to compute the two numbers sum
    // equal to given ones. but with sorted array we can have two variables l and r
    // to both ends of array and to increment or decrement the pointerbased o the
    // sum.
    // with rotated sorted arry. we can find the value where it is started rotated
    // and nitiaze the pointer there instaed of doing at both rear ends.
    // eg.,{ 11,15,26,38,9,10 } => 11<15<26<38 all are sorted order but. 38>9 so
    // initiaze l=9 and r=38 and with mod operation we can form the circular motion
    // after nth elment to call 0 and so on.
    public static void main(String args[]) {
        int arr[] = { 11, 15, 26, 38, 9, 10 };
        SortedRotatedArray fmp = new SortedRotatedArray();
        System.out.println(fmp.sortedRotatedArray(arr, 35));
    }

    private boolean sortedRotatedArray(int[] arr, int sum) {

        int l = -1;
        int r = -1;
        int n = arr.length;
        // find pivot element l, r
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                l = (i + 1) % n;
                r = i;
                break;

            }
        }
        while (l != r) {
            if (arr[l] + arr[r] == sum) {
                return true;
            } else if (arr[l] + arr[r] < sum) {
                l = (l + 1) % n;
            } else if (arr[l] + arr[r] > sum) {
                r = (n + r - 1)% n;
            }

        }
        return false;
    }

    static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

    }
}
