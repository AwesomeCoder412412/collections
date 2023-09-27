
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    public static void testAll() {
        MyStack<Integer> stack = new MyStack();
        if (!stack.isEmpty()){
            System.out.println("Failed isEmpty");
        }
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        if (!stack.isFull()){
            System.out.println("Failed isFull");
        }
        if (stack.size() != 5){
            System.out.println("Failed size");
        }
        if (stack.top() != 5){
            System.out.println("Failed top");
        }
        if (stack.pop() != 5){
            System.out.println("Failed pop");
        }
        if (!stack.toString().equals("4, 3, 2, 1")) {
            System.out.println("Failed toString " + stack.toString());
        }
        
        MyQueue<Integer> queue = new MyQueue();
        if (!queue.isEmpty()){
            System.out.println("Failed isEmpty");
        }
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        if (!queue.isFull()){
            System.out.println("Failed isFull");
        }
        if (queue.size() != 5){
            System.out.println("Failed size");
        }
        if (queue.front() != 1){
            System.out.println("Failed front");
        }
        if (queue.dequeue() != 1){
            System.out.println("Failed dequeue");
        }
        if (!queue.toString().equals("2, 3, 4, 5")) {
            System.out.println("Failed toString " + queue.toString());
        }
    }
}
