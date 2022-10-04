package ds.Queue;

import javax.lang.model.util.ElementScanner14;

public class ImplementingQueueUsingArray {
    // Queue: FIFO . add in rear and delete or remove in front, and should work in
    // circular motion as well.
    static class Queue {
        static int front = -1;
        static int rear = -1;
        static int[] queue;
        Queue(int capacity) {
            this.queue = new int[capacity];
        }
    }
    public static void main(String args[]) {
        ImplementingQueueUsingArray QueueUsingArr = new ImplementingQueueUsingArray();
        int capacity = 5;
        Queue queue = new Queue(capacity);
        QueueUsingArr.enQueue(5, queue, capacity);
        QueueUsingArr.enQueue(10, queue, capacity);
        QueueUsingArr.enQueue(15, queue, capacity);
        QueueUsingArr.enQueue(20, queue, capacity);
        QueueUsingArr.enQueue(25, queue, capacity);
        QueueUsingArr.displayQueue(queue, capacity);
        QueueUsingArr.enQueue(30, queue, capacity);
        int front = QueueUsingArr.deQueue(queue, capacity);
        System.out.println("Dequeued Item:" + front);
        QueueUsingArr.displayQueue(queue, capacity);
        QueueUsingArr.enQueue(30, queue, capacity);
        QueueUsingArr.displayQueue(queue, capacity);
    }

    private int deQueue(Queue q, int capacity) {
        int item = q.queue[q.front];
        if (isQueueEmpty(q, capacity)) {
            System.out.println("Queue is Empty");
            return 0;
        } else {
            if (q.front == q.rear) {
                q.front = -1;
                q.rear = -1;
            } else if (q.front == capacity - 1) {
                q.front = 0;
            } else {
                q.front = q.front + 1;
            }
        }
        return item;
    }
    private void displayQueue(Queue q, int capacity) {
        if (isQueueEmpty(q, capacity)) {
            System.out.println("Queue is Empty");
            return;
        } else {
            System.out.print("Queue elements :\n");
            int item = q.front;
            if (q.front <= q.rear) {
                while (item <= q.rear)
                    System.out.print(q.queue[item++] + " ");
            } else {
                while (item <= capacity - 1)
                    System.out.print(q.queue[item++] + " ");
                item = 0;
                while (item <= q.rear)
                    System.out.print(q.queue[item++] + " ");
            }
        }
        System.out.println();
    }
    private boolean isQueueEmpty(Queue q, int capacity) {
        if (q.front == -1) {
            return true;
        }
        return false;
    }
    public void enQueue(int item, Queue q, int capacity) {
        if (isQueueFull(q, capacity)) {
            System.out.println("Queue is full");
            return;
        } else {
            if (q.front == -1) {
                q.front = 0;
            }
            if (q.rear == capacity-1) {
                q.rear = 0;
            } else {
                q.rear = q.rear + 1;
            }
            q.queue[q.rear] = item;
        }
    }
    private boolean isQueueFull(Queue q, int capacity) {
        if ((q.front == 0 && q.rear == capacity - 1) || (q.front == q.rear + 1)) {
            return true;
        }
        return false;
    }
}