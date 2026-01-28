public class StackUsingArr {
    private int[] arr;
    int top;
    int capacity;
    public StackUsingArr(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;

    }

    public void push(int x){
        if(isFull()){
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = x;
    }
    private boolean isFull() {
        return top == capacity-1;
    }
    private boolean isEmpty(){
        return top == -1;
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        return arr[top--];
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        return arr[top];
    }
    public int size(){
        return top+1;
    }

    public static void main(String[] args) {
        StackUsingArr st = new StackUsingArr(5);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.peek());
        
    }
}
