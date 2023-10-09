import java.util.EmptyStackException;
import java.util.NoSuchElementException;
/**
 * Houses test methods for various data structures
 *
 * @author Jack Segil
 * @version 1.0
 */
public class Test
{
    public static void testIsBalanced() {
        if (!isBalanced("({[]})")) {
            System.out.println("Failed valid string");
        }
        if (isBalanced("({[})")) {
            System.out.println("Failed invalid string");
        }
    }
    
    public static boolean isBalanced(String input) {
        MyStackLL<String> stack = new MyStackLL<String>();
        String openChars = "({[";
        String closeChars = ")}]";
        for (int i = 0; i < input.length(); i++) {
            if (openChars.indexOf(input.substring(i, i + 1)) != -1) {
                stack.push(input.substring(i, i + 1));
            } else if (openChars.indexOf(stack.top()) == closeChars.indexOf((input.substring(i, i + 1)))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void reverse() {
        MyQueueLL<Integer> queue = new MyQueueLL<Integer>();
        MyStackLL<Integer> stack = new MyStackLL<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.toString());
        for (int i = 0; i < 5; i++) {
            stack.push(queue.dequeue());
        }
        for (int i = 0; i < 5; i++) {
            queue.enqueue(stack.pop());
        }
        System.out.println(queue.toString());
    }
    
    public static void testOtherThings() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        if (!list.isEmpty()) {
            System.out.println("Failed isEmpty");
        }
        list.addHead(3);
        list.addHead(4);
        list.addHead(5);
        list.addHead(3);
        System.out.println(list.toString());
        if (list.getHead() != 3) {
            System.out.println("Failed getHead");
        }
        if (list.removeHead() != 3) {
            System.out.println("Failed removeHead");
        }
        if (!list.toString().equals("5, 4, 3")) {
            System.out.println("Failed removeHead " + list.toString());
        }
        list.addTail(2);
        if (!list.toString().equals("5, 4, 3, 2")) {
            System.out.println("Failed addTail " + list.toString());
        }
    }
    
    public static void testLL() {
        MyStackLL<Integer> stack = new MyStackLL<Integer>();
        try {
            stack.pop();
        } catch (NoSuchElementException e){
            System.out.println("Tried to pop from an empty stack");
        }
        try {
            stack.top();
        } catch (NoSuchElementException e){
            System.out.println("Tried to top from an empty stack");
        }
        if (!stack.isEmpty()){
            System.out.println("Failed isEmpty");
        }
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

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
        
        MyQueueLL<Integer> queue = new MyQueueLL<Integer>();
        if (!queue.isEmpty()){
            System.out.println("Failed isEmpty");
        }
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
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
    
    public static void testAll() {
        MyStack<Integer> stack = new MyStack<Integer>();
        // try {
            // stack.pop();
        // } catch (EmptyStackException e){
            // System.out.println("Tried to pop from an empty stack");
        // }
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
        
        MyQueue<Integer> queue = new MyQueue<Integer>();
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
