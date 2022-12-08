package Heap;
import java.util.PriorityQueue;
public class NropesWithMinimumCosts {
    // arr[] = {4,3,2,6} , N = 4
    // 4+3 + (4+3)+2 + (4+3+2)+6 = 30
    // but by sorting we get {2,3,4,6}
    // => 2+3 + (2+3)+4 + (2+3+4) +6 = 29
    // here, 2+3 are used at every occurance as they are smaller than 4+3 , the
    // final output is smaller. this is th key idea.
    // First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths
    // 4, 6, and 5.
    // Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and
    // 9.
    // Finally connect the two ropes and all ropes have connected.
    // this can be solved by comparison sorting T(n)=> O(n^2)
    // by using minheap T(n)=> O(n log n)
    // priortyqueues are the implementation of min heap. we can make use of that.
    public static void main(String args[]) {
        int arr[] = { 4, 3, 2, 6 };
        System.out.println("minimum cost is" + minimumCost(arr));
    }
    private static int minimumCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int val : arr) {
            minHeap.add(val);
        }
        int result = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            result += first + second;
            minHeap.add(first + second);
        }
        return result;
    }
}
