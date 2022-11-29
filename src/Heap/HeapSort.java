package Heap;

public class HeapSort {
    // Using max_heapify
    //T(n)=> Theta(n lg n) even in worst case
    //S(n)=>O(n) beacuse of recursion
    public static void main(String args[]) {
        int arr[] = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        heapSort(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    // step1: heapify
    // step2: swap root in binary tree with last element
    // step3: reduce n to n-1 and recursively do the same.
    private static void heapSort(int[] arr, int length) {
        if (length > 0) {
            for (int i = (length / 2) - 1; i >= 0; i--) {
                heapify(arr, i, length);
            }
            swap(0, length - 1, arr);
            heapSort(arr, length - 1);
        }
    }
    private static void heapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[i]) {
            largest = left;

        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest, arr);
            heapify(arr, largest, n);
        }
    }
    private static void swap(int i, int largest, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}
