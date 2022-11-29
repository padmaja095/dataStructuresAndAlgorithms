package ds.stacks;
public class ImplementTwoStacksInArray {
    // idea is that, in given array first stack can be pushed and top from index 0
    // and stack 2 startes from maxsize and goes on .
    int arr[];
    int size;
    int top1 = -1;
    int top2;
    ImplementTwoStacksInArray(int maxSize) {
        this.arr = new int[maxSize];
        this.top2 = maxSize;
        this.size = maxSize;
    }
    public static void main(String args[]) {
        ImplementTwoStacksInArray twoStack = new ImplementTwoStacksInArray(100);
        twoStack.push1(1);
        twoStack.push2(2);
        twoStack.push1(3);
        twoStack.push2(4);

        int x1 = twoStack.pop1();
        System.out.println(x1 + " is popped");
        int x2 = twoStack.pop2();
        System.out.println(x2 + " is popped");
    }
    private int pop2() {
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack2 is empty");
        }
        return 0;
    }
    private int pop1() {
        if (top1 > -1) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack1 is empty");
        }
        return 0;
    }
    private void push2(int val) {
        if (top2 - 1 > top1) {
            arr[--top2] = val;
        } else {
            System.out.println("stack2 Full");
        }
    }
    private void push1(int val) {
        if (top1 < top2 - 1) {
            arr[++top1] = val;
        } else {
            System.out.println("Stack1 Full");
        }
    }
}
