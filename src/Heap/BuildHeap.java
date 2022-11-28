package Heap;

public class BuildHeap {
    // using array implementation
    public static void main(String arg[]) {
        int arr[] = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        buildMaxHeap(arr, arr.length);
       for(int i=0;i<arr.length;i++)
       {
        System.out.print(arr[i]+" ");
       }
    }
    private static void buildMaxHeap(int[] arr, int n) {
        for (int i = (n/2)-1; i >=0; i--) {
            System.out.println(i);
            heapify(arr, i, n);
        }
    }
    private static void heapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[i]) {
            largest = left;

        }  if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i,largest,arr);
            heapify(arr, largest, n);
        }
    }

    private static void swap(int i, int largest, int[] arr) {
        int temp=arr[i];
        arr[i]=arr[largest];
        arr[largest]=temp;
    }
}
