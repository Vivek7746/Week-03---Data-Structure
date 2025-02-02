package stack_and_queue.sorting_stack;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        sortStack.sort(stack);

        System.out.println("sorted stack is" + stack);


    }


}