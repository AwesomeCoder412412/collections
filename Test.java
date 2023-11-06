import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.*;
/**
 * Houses test methods for various data structures
 *
 * @author Jack Segil
 * @version 1.0
 */
public class Test
{
    public static void testCastaway() {
        String[] lastName = {"", "Grumby", "Howell", "Howell", "Grant", "Hinkley", "Summers"};
        String[] firstName = {"Gilligan", "Jonas", "Thurston", "Lovey", "Ginger", "Roy","Mary Ann"};
        int[] score = {72, 85, 82, 96, 90, 96, 88};
        String[] gender = {"M", "M", "M", "F", "F", "M", "F"};
        MyLinkedList<Castaway> list = new MyLinkedList<Castaway>();
        for (int i = 0; i < score.length; i++) {
            list.insertSorted(new Castaway(firstName[i], lastName[i], score[i], gender[i]));
        }
        System.out.println(list.toString()); 
        System.out.println(list.remove(new Castaway(firstName[0], lastName[0], score[0], gender[0])));
        System.out.println(list.toString());
        
    }
    
    public static double squareRoot(double input) {
        int iter = 0;
        double answer = input / 2;
        while (!(answer * answer >= input - 0.0001 && answer * answer <= input)) {
            if (answer * answer > input) {
                answer /= 2;
            } else {
                answer = answer + (answer / 2);
            }
            iter++;
        }
        System.out.println(iter);
        return answer;
    }
    
    public static double squareRootImproved(double input) {
        double answer = input / 2;
        int iter = 0;
        double min = 0;
        double max = input;
        while (!(answer * answer >= input - 0.0001 && answer * answer <= input)) {
            if (answer * answer > input) {
                max = answer;
            } else {
                min = answer;
            }
            answer = (min + max) / 2;
            iter++;
        }
        System.out.println(iter);
        return answer;
    }
    
    
    public static void testArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(3);
        arrayList.remove(0);
    }
    
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
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.addHead(1);
        if (list.remove(0) != 1) {
            System.out.println("Failed remove index");
        }
        list.addHead(1);
        list.addHead(2);
        if (list.remove(1) == null) {
            System.out.println("Failed remove index, is null");
        }
        if (list.get(0) != 2) {
           System.out.println("Failed get " + list.get(1));
        }
        list.addHead(3);
        list.add(1, 4);
        if (!list.toString().equals("3, 4, 2")) {
            System.out.println("Failed add with index " + list.toString());
        }
        list.add(0, 9);
        if (!list.toString().equals("9, 3, 4, 2")) {
            System.out.println("Failed add with index " + list.toString());
        }
        if (list.getHead() != 9) {
            System.out.println("Your add method does not set the head variable when inserting at index 0");
        }
        list.add(4, 10);
        list.addTail(5);
        if (!list.toString().equals("9, 3, 4, 2, 10, 5")) {
            System.out.println("Your add method does not set the tail variable when inserting at the index equal to the size of the list  " + list.toString());
        }
        list.remove(5);
        list.remove(4);
        
        
        if (list.remove(0) != 9) {
            System.out.println("Failed remove index " + list.toString());
        }
        if (!list.toString().equals("3, 4, 2")) {
            System.out.println("Failed remove index " + list.toString());
        }
        
        list.add(3, 9);
        if (!list.toString().equals("3, 4, 2, 9")) {
            System.out.println("Failed add with index " + list.toString());
        }
        list.remove(3);
        
        
        list.set(1, 9);
        if (!list.toString().equals("3, 9, 2")) {
            System.out.println("Failed set " + list.toString());
        }
        list.set(0, 9);
        if (!list.toString().equals("9, 9, 2")) {
            System.out.println("Failed set " + list.toString());
        }
        list.set(0, 3);
        list.set(2, 9);
        if (!list.toString().equals("3, 9, 9")) {
            System.out.println("Failed set " + list.toString());
        }
        list.set(2, 2);
        
        list.insertSorted(4);
        if (!list.toString().equals("3, 4, 9, 2")) {
            System.out.println("Failed insertSorted " + list.toString());
        }
        if (list.remove(new Integer(2)) == null) {
            System.out.println("Failed remove element, is null");
        }
        if (!list.toString().equals("3, 4, 9")) {
            System.out.println("Failed remove element " + list.toString());
        }
        MyLinkedList<Integer> listSorted = new MyLinkedList<Integer>();
        listSorted.insertSorted(6);
        listSorted.insertSorted(2);
        listSorted.insertSorted(8);
        listSorted.insertSorted(9);
        listSorted.insertSorted(67);
        listSorted.insertSorted(0);
        listSorted.insertSorted(-6);
        if (!listSorted.toString().equals("-6, 0, 2, 6, 8, 9, 67")) {
            System.out.println("Failed insertSorted " + listSorted.toString());
        }
        
        
        
        MyStackLL<Integer> stack = new MyStackLL<Integer>();
        try {
            stack.pop();
        } catch (NoSuchElementException e){
            System.out.println("Tried to pop from an empty stack.");
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
