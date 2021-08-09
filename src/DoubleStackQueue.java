import java.util.*;

public class DoubleStackQueue {
    private final Stack<Integer> primary = new Stack<>();

    public void enqueue(int i){
        Stack<Integer> secondary = new Stack<>();
        while(!primary.isEmpty()){
            secondary.push(primary.pop());
        }
        primary.push(i);
        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
    }

    public int dequeue() {
        if (!primary.isEmpty()) {
            return primary.pop();
        }
        return Integer.MAX_VALUE;
    }

    public void sort(){
        if(primary.isEmpty()) return;
        Stack<Integer> secondary = new Stack<>();
        while(!primary.isEmpty()){
            int temp = primary.pop();
            while(!secondary.isEmpty() && secondary.peek() > temp){
                primary.push(secondary.pop());
            }
            secondary.push(temp);
        }
        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
    }

    public void print(){
        Stack<Integer> secondary = new Stack<>();
        while(!primary.isEmpty()){
            System.out.println(primary.peek());
            secondary.push(primary.pop());
        }
        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
    }

    public static void main(String[] args) {
        DoubleStackQueue queue = new DoubleStackQueue();
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(0);
        queue.enqueue(6);

        queue.print();

        queue.sort();
        queue.print();
    }
}
