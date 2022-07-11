package ds.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingInterval {
    // Q: given two dimensiona array of intervals start and end. find the overapping
    // intervals
    // approach: sor the start of all intervals and using stack merge the
    // overlapping intervals one by one in O(n) times.
    public static void main(String[] args) {
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergeOverlappingInterval(arr);

    }

    private static void mergeOverlappingInterval(Interval[] arr) {
        // sort the arr with start interval.
        Arrays.sort(arr, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Stack<Interval> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=0;i<arr.length;i++)
        {
            Interval top= stack.peek();
            if(top.end>arr[i].start)
            {
                stack.pop();
                stack.push(new Interval(top.start, Math.max(top.end,arr[i].end)));
            }
            else {
                stack.push(arr[i]);

            }

        }
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty()) 
        { 
            Interval t = stack.pop(); 
            System.out.print("["+t.start+","+t.end+"] ");
        } 

    }

}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

}
