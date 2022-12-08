package Heap;
import java.util.*;
public class KlargestElementInStreams {
    // to find the kth largest element in a stream of incoming numbers.note: in case
    // of standard array, we can do this by quick select or using heap
    // approach 1: Keep an array of size K. The idea is to keep the array sorted so
    // that the Kth largest element can be found in O(1) time (we just need to
    // return the first element of the array, if the array is sorted in increasing
    // order
    // T(n)= O(k) for every moment of stream coming thru. so O(k.n)
    // approach 2: to use min-heap.
    /*
     * using min heap DS
     * 
     * how data are stored in min Heap DS
     * 1
     * 2 3
     * if k==3 , then top element of heap
     * itself the kth largest largest element
     * 
     */ // T(n)= O(log k)
        // T(n)= O(n.log K) for n elements.
    static PriorityQueue<Integer> minHeap;
    static int k;
    public static void main(String args[]) {
        minHeap = new PriorityQueue<>();
        k = 3;
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        List<Integer> kList = getKthNumbersList(arr);
        for (int k : kList)
            System.out.print(k + " ");
    }
    private static List<Integer> getKthNumbersList(int[] arr) {
        List<Integer> klist = new ArrayList<>();
        for (int val : arr) {
            if (minHeap.size() < k) {
                minHeap.add(val);
            } else {
                if (val > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(val);
                }
            }
            if (minHeap.size() == k) {
                klist.add(minHeap.peek());
            } else {
                klist.add(-1);
            }
        }
        return klist;
    }
}
