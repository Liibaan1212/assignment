import java.util.Arrays;
import java.util.EmptyStackException;

public class Assignments<T> {
    private static final int DEFAULT_CAPACITY = 2;
    private static final int GROWTH_FACTOR = 2;
    private int topIndex;
    private T[] stackArray;

    @SuppressWarnings("unchecked")
    public Assignments() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public Assignments(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        topIndex = 0;
        stackArray = (T[]) new Object[initialCapacity];
    }

    public int size() {
        return topIndex;
    }

    public boolean isEmpty() {
        return topIndex == 0;
    }

    public void push(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot push a null element");
        }

        if (topIndex == stackArray.length) {
            expandCapacity();
        }

        stackArray[topIndex] = element;
        topIndex++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        topIndex--;
        T result = stackArray[topIndex];
        stackArray[topIndex] = null;
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[topIndex - 1];
    }

    private void expandCapacity() {
        int newCapacity = stackArray.length * GROWTH_FACTOR;
        stackArray = Arrays.copyOf(stackArray, newCapacity);
        System.out.println("Stack expanded to capacity: " + newCapacity);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements (top to bottom):");
        for (int i = topIndex - 1; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
        System.out.println();
    }

    public int getCapacity() {
        return stackArray.length;
    }


    public static void main(String[] args) {
        System.out.println("=== Testing Assignments Stack ===");


        Assignments<String> stack = new Assignments<>();


        System.out.println("Pushing elements...");
        stack.push("First Assignment");
        stack.push("Second Assignment");
        stack.push("Third Assignment");

        stack.display();
        System.out.println("Current size: " + stack.size());
        System.out.println("Current capacity: " + stack.getCapacity());


        System.out.println("Top element: " + stack.peek());

        System.out.println("\nPopping elements...");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();


        System.out.println("=== Testing with Integers ===");
        Assignments<Integer> intStack = new Assignments<>(3);

        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.push(40);

        intStack.display();


        System.out.println("=== Testing Empty Stack ===");
        Assignments<Double> emptyStack = new Assignments<>();
        emptyStack.display();

        System.out.println("Is empty: " + emptyStack.isEmpty());


    }
}