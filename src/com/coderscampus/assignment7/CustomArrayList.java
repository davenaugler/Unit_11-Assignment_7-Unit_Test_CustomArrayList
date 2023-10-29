package com.coderscampus.assignment7;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int CAPACITY_MULTIPLIER = 2;
    private Object[] items;
    private int size;

    public CustomArrayList() {
        items = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(T item) { // Trevor Method #1
        System.out.println("---------------------");
        System.out.println("ran 'add(T item)' method");
        ensureCapacity(size + 1);
        items[size++] = item;
        System.out.println("Added " + item + " to list");
        // Test Comment: should_add_11_items_to_list()
//		System.out.println(item);
        return true;
    }

    @Override
    public boolean add(int index, T item) { // Trevor Method #2
        System.out.println("ran 'add(int index, T item)' method ");
        validateIndexForAdditionalItem(index);
        ensureCapacity(size + 1);
        System.arraycopy(items, index, items, index + 1, size - index); // Replaces original for-loop
        items[index] = item;
        size++;
        return true;
    }

    private void ensureCapacity(int minCapacity) { // Dave Method #1
        System.out.println("ran ensureCapacity method");
        if (minCapacity > items.length) {
            System.out.println("Need to increase capacity. minCapacity " + minCapacity);
            int newCapacity = items.length * CAPACITY_MULTIPLIER;
            items = Arrays.copyOf(items, newCapacity);
            System.out.println("Increased Capacity to: " + newCapacity);
        } else {
            // Remove else post testing
            System.out.println("Don't need to increase capacity. minCapacity " + minCapacity);
        }
    }

    @Override
    public int getSize() { // Trevor Method #3
        System.out.println("ran 'getSize()' method");
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) { // Trevor Method #4
        System.out.println("ran 'get(int index)' method");
        validateIndexForAccess(index);
        return (T) items[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) { // Trevor Method #5
        System.out.println("ran 'remove(int index)' method");
        validateIndexForAccess(index);
        T removedItem = (T) items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1); // Replaces original for-loop
        items[--size] = null;
        return removedItem;
    }

    private void validateIndexForAccess(int index) {
        System.out.println("ran 'validateIndexForAccess(int index)' method");
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void validateIndexForAdditionalItem(int index) {
        System.out.println("ran 'validateIndexForAdditionalItem(int index)' method");
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        System.out.println("ran 'toString()' method");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
