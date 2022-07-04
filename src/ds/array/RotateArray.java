package ds.array;

public class RotateArray {
    // Given Array rotate the array for given input k times.eg. input {
    // 1,2,3,4,5,6,7} output : {5,6,7,1,2,3,4}
    // approach 1: in a loop for k times. store the nth element and swap from n-1 to
    // n, n-2 to n-1 soon to 0th index -> O(n*k)-polynomial
    // approach 2: have auxillary array to store all k elements. swap all the from
    // n-k till 0th index i.e., from 4 to 1 in example.-> O(n+k) time and O(K) space
    // approach 3: reverse 5,6,7 ; reverse 1,2,3,4; reverse all elements -> O(n)+
    // O(n-k)+O(k)= O(n) time
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        RotateArray fmp = new RotateArray();
        // fmp.firstApproachRotateArray(arr,3);
       // fmp.secondApproachRotateArray(arr, 4);
       printArray(fmp.thirdApproachRotateArray(arr, 3));

    }

    public int[] firstApproachRotateArray(int[] arr, int k) {
        int n = arr.length;
        System.out.println(n);
        for (int i = 0; i < k; i++) {
            int temp = arr[n - 1];
            for (int j = 0; j < n - 1; j++) {
                swap(arr, n - j - 1, n - j - 2);
                printArray(arr);
            }
            arr[0] = temp;
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

    public int[] secondApproachRotateArray(int[] arr, int k) {
        int n = arr.length;
        int auxillary[] = new int[k];
        for (int i = 0; i < k; i++) {
            auxillary[i] = arr[n - k + i];

        }
        for (int j = n - k - 1, i = 0; j >= 0; j--, i++) {
            System.out.println(arr[j] + " " + arr[n - 1 - i]);
            swap(arr, j, n - 1 - i);
        }
        for (int aux = 0; aux < k; aux++) {
             arr[aux]=auxillary[aux];
        }
        printArray(arr);
        return arr;
    }
    public int[] thirdApproachRotateArray(int[] arr, int k) { 
        int n= arr.length;

        reverseArray(arr,n-k,n-1);
        reverseArray(arr,0,n-k-1);
        reverseArray(arr,0,n-1);
        return arr;
    }

    private int[] reverseArray(int[] arr, int i, int j) {
        while(i<j)
        {
            swap(arr,i,j);
            i++;
            j--;
        }
        return arr;
    }
}
