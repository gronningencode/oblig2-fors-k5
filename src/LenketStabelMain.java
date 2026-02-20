package dat102.f05.stabel.lenketstabel;

import dat102.f05.stabel.StabelADT;

public class LenketStabelMain {

    public static void main(String[] args) {
        testStackOperations();
        System.out.println("\n\nDone.");
    }

    public static void testStackOperations() {

        System.out.println("Create a stack:");
        StabelADT<String> myStack = new LenketStabel<>();
        System.out.println("isEmpty() returns " + myStack.isEmpty());

        System.out.println("\nAdd to stack to get\nJoe Jane Jill Jess Jim");

        myStack.push("Jim");
        myStack.push("Jess");
        myStack.push("Jill");
        myStack.push("Jane");
        myStack.push("Joe");

        System.out.println("\nisEmpty() returns " + myStack.isEmpty());

        System.out.println("\nTesting peek and pop:");

        while (!myStack.isEmpty()) {
            String top = myStack.peek();
            System.out.println(top + " is at the top of the stack.");

            top = myStack.pop();
            System.out.println(top + " is removed from the stack.\n");
        }

        System.out.println("The stack should be empty:");
        System.out.println("isEmpty() returns " + myStack.isEmpty());

        System.out.println("\nAdd to stack to get\nJim Jess Joe");

        myStack.push("Joe");
        myStack.push("Jess");
        myStack.push("Jim");

        System.out.println("\nTesting clear:");
        myStack.clear();

        System.out.println("The stack should be empty:");
        System.out.println("isEmpty() returns " + myStack.isEmpty());

        System.out.println("\nTesting peek() and pop() on empty stack:");

        try {
            myStack.peek();
        } catch (Exception e) {
            System.out.println("peek() kastet exception som forventet.");
        }

        try {
            myStack.pop();
        } catch (Exception e) {
            System.out.println("pop() kastet exception som forventet.");
        }
    }
}
