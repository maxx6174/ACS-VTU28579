public class DesignCircularQueue {
    int[] q;
    int front;
    int rear;
    int size;
    int capacity;

    public DesignCircularQueue(int k) {
        q = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        q[rear] = value;
        size++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return q[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return q[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
