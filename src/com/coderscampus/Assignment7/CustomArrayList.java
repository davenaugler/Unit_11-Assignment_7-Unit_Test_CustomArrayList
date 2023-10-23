package com.coderscampus.Assignment7;

import java.util.Arrays;

public abstract class CustomArrayList<T> implements CustomList<T> {
	private int initialCapacity = 10;
	private Object[] items;
	private int size;

	public CustomArrayList() {
		items = new Object[initialCapacity];
		size = 0;
	}

//	@Override
//	public boolean add(T item) {
//		checkCapacity(size + 1);
//		items[size++] = item;
//		// Test Comment: should_add_11_items_to_list()
////		System.out.println(item);
//		return true;
//	}

	// Revised add method
	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		checkCapacity(size + 1);
		items[size++] = item;
		// Test Comment: should_add_11_items_to_list()
//		System.out.println(item);
		return true;
	}

	private void checkCapacity(int minCapacity) {
		int oldCapacity = items.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = oldCapacity * 2;
			items = Arrays.copyOf(items, newCapacity);
			System.out.println("New Capacity: " + newCapacity);
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return (T) items[index];
	}

	
//	@Override
//	public boolean add(int index, T item) throws IndexOutOfBoundsException {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// Step 1: Check bounds
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		// Step 2: Save the item to return
		T removedItem = (T) items[index];

		// Step 3: Shift elements
		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}

		// Set the last element to null to allow garbage collection of the removed element
		items[size - 1] = null;

		// Step 4: Decrease size
		size--;

		// Step 5: Return the removed item
		return removedItem;

	}

}
