public class QueueUsingArr {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    public QueueUsingArr(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size  = 0;
    }
    public void enqueue(int x){
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }
        arr[++rear] = x;
        size++;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int item = arr[front];
        front++;
        size--;
        return item;
    }
    private int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }
    private boolean isFull(){
        return size==capacity;
    }
    private boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
    QueueUsingArr q = new QueueUsingArr(5);
    q.enqueue(1);
    q.enqueue(3);
    q.enqueue(5);
    q.enqueue(7);
    q.enqueue(9);
    q.dequeue();
    System.out.println(q.peek());

    }
}
