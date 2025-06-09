package dev.drtheo.yaar.util;

public class SparseSet<T> {

    private final int[] sparse;
    private final int[] dense;
    private final T[] values;

    private final int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public SparseSet(int capacity) {
        this.capacity = capacity;

        this.sparse = new int[capacity + 1];
        this.dense = new int[capacity];
        this.values = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int search(int x) {
        // check if the given element is out of range
        if (x > capacity)
            return -1; // if yes, return -1

        // check if the element exists in the set
        if (sparse[x] < size && dense[sparse[x]] == x)
            return sparse[x]; // if yes, return its index

        return -1; // if not, return -1
    }

    // Insert an element into the set
    public void add(int x, T t) {
        // check if the element is out of range or the set is full or
        // the element already exists in the set
        if (x > capacity || size >= capacity || search(x) != -1)
            return; // if yes, do nothing and return

        // add the element to the end of the dense array
        this.dense[size] = x;
        this.values[size] = t;

        // update the index of the element in the sparse array
        this.sparse[x] = size;

        this.size++; // increment the size of the set
    }

    public T get(int x) {
        int index = search(x); // find the index of the element

        // check if the element exists in the set
        if (index == -1)
            return null; // if not, do nothing and return

        return values[index];
    }

    // Delete an element from the set
    public void remove(int x) {
        int index = search(x); // find the index of the element

        // check if the element exists in the set
        if (index == -1)
            return; // if not, do nothing and return

        // swap the element with the last element in the dense array
        int temp = this.dense[size - 1];

        this.dense[index] = temp;
        this.values[index] = this.values[size - 1];
        this.sparse[temp] = index;

        this.size--; // decrement the size of the set
    }
}
