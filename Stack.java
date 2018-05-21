public class Stack<T> {
    private final static int CAPACITY = 8;

    private T[] stackArray;
    private int nItems;

    @SuppressWarnings("unchecked")
    public Stack() {
        stackArray = (T[])new Object[CAPACITY];
    }

    // O(1) if no resize
    public void push(T data) {
        if (nItems == stackArray.length) {
            resizeArray(nItems * 2);
        }

        stackArray[nItems++] = data;
    }

    // O(1) if no resize
    public T pop() {
        if (nItems == 0) {
            System.out.println("Exception: Pop for empty stack");
            return null;
        }
        else {
            T item = stackArray[--nItems];

            // obsolete reference
            stackArray[nItems] = null;

            if (nItems == (stackArray.length / 4)) {
                resizeArray(stackArray.length / 2);
            }

            return item;
        }
    }

    // O(1)
    public T peek() {
        if (nItems == 0) {
            return null;
        }

        return stackArray[nItems - 1];
    }

    // O(n) linear time complexity
    @SuppressWarnings("unchecked")
    private void resizeArray(int length) {
        T[] newArray = (T[])new Object[length];

        for (int i = 0; i < nItems; i++) {
            newArray[i] = stackArray[i];
        }

        stackArray = newArray;
    }

    public int size() {
        return nItems;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}