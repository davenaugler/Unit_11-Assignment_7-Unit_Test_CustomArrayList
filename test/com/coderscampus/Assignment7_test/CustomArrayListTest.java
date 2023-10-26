package com.coderscampus.Assignment7_test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coderscampus.Assignment7.CustomArrayList;

class CustomArrayListTest {
	// sut = System under test
	private CustomArrayList<Integer> sut;

	@BeforeEach
	void setUp() {
		sut = new CustomArrayList<>();
	}

	@Test
	void shouldAddItemToList() {
		assertTrue(sut.add(1));
		assertEquals(1, sut.getSize());
		assertEquals(1, sut.get(0));
	}

	@Test
	void shouldAddMultipleItemsToList() {
		for (int i = 0; i < 12; i++) {
			sut.add(i);
		}
		assertEquals(12, sut.getSize());
		assertEquals(11, sut.get(11));
	}

	@Test
	void shouldAddItemToSpecificIndex() {
		sut.add(1);
		sut.add(2);
		sut.add(1,3);
		assertEquals(3, sut.getSize());
		assertEquals(1, sut.get(0));
		assertEquals(3, sut.get(1));
		assertEquals(2, sut.get(2));
	}

	@Test
	void shouldThrowExceptionWhenGetOutOfBoundsIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> sut.get(0));
		sut.add(1);
		assertThrows(IndexOutOfBoundsException.class, () -> sut.get(2));
	}

	@Test
	void shouldRemoveItemFromList() {
		sut.add(1);
		sut.add(2);
		int removedItem = sut.remove(0);
		assertEquals(1, sut.getSize());
		assertEquals(1, removedItem);
		assertEquals(2, sut.get(0));
	}

	@Test
	void shouldThrowExceptionWhenRemoveOutOfBoundIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(0));
		sut.add(1);
		assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(2));
	}

	@Test
	void shouldCorrectlyRepresentListAsString() {
		sut.add(1);
		sut.add(2);
		assertEquals("[1, 2]", sut.toString());
	}








//	// sut = System Under Test
//
//	@Test // Test for adding items to the list
//	void shouldAddItemsToList() {
//		CustomArrayList<Integer> sut = new CustomArrayList<>();
//
//		for (int i = 1; i <= 100; i++){
//			sut.add(i);
//			System.out.println("ADDED: " + i);
//		}
//
//		for (int i = 0; i < 99; i++) {
//			assertEquals(i+1, sut.get(i));
//			System.out.println("GETTING: " + i);
//		}
//		assertEquals(100, sut.getSize());
//		System.out.println("SIZE SHOULD BE 100: " + sut.getSize());
//	}
//
//	@Test // Test f or list's capacity growth
//	void shouldGrowCapacityWhenAddingMoreItems() {
//		CustomArrayList<Integer> sut = new CustomArrayList<>();
//		for (int i = 1; i <= 11; i++) {
//			sut.add(i);
//			System.out.println("Added: " + i);
//		}
//		// Assert that the size has surpassed the initial capacity
//		assertTrue(sut.getSize() > 10);
//	}
//
//	@Test // Test for adding items at specific indexes
//	void shouldAddItemAtSpecificIndex() {
//		CustomArrayList<Integer> sut = new CustomArrayList<>();
//		sut.add(1);
////		System.out.println("Item at index 1: " + sut.get(0));
//		System.out.println("All items in the list: " + sut); // Calling the toString
//		sut.add(3); // intentionally skipping 2
////		System.out.println("Item at index 2: " + sut.get(1));
//		System.out.println("All items in the list: " + sut); // Calling the toString
//		sut.add(1, 2);
//		System.out.println("All items in the list: " + sut); // Calling the toString
//
//
//		System.out.println("All items in the list: " + sut); // Calling the toString
//		assertEquals(2, sut.get(1));
//		System.out.println("assertEquals: 2 -> " + sut.get(1));
//
//	}
//
//	@Test
//	void shouldThrowExceptionWhenAddingItemAtInvalidIndex() {
//		CustomArrayList<Integer> sut = new CustomArrayList<>();
//		assertThrows(IndexOutOfBoundsException.class, () -> sut.add(2,3));
////		System.out.println(sut.add(2,3)); // Sys-out displays IndexOutOfBoundsException: Index: 2, Size: 0
//	}
//
//	@Test // Test for getting items by index
//	void shouldReturnItemAtIndex() {
//		CustomArrayList<Integer> sut = new CustomArrayList<>();
//		sut.add(1);
//		assertEquals(Integer.valueOf(1), sut.get(0));
////		System.out.println("Should be 1: " + sut.get(0)); // Sys-out does display 1
//	}
//
//	@Test
//	void shouldThrowExceptionWhenAddingItemAtInvalidIndex2() {
//		CustomArrayList<Integer> sut = new CustomArrayList<>();
//		assertThrows(IndexOutOfBoundsException.class, () -> sut.get(1));
////		System.out.println(sut.get(1)); // Sys-out displays IndexOutOfBoundsException: Index: 1, Size: 0
//	}
//
//	@Test // Test for removing items
//	void shouldRemoveItemAtIndex() {
//		CustomArrayList<Integer> sut = new CustomArrayList<>();
//		sut.add(1);
//		System.out.println("All items in the list: " + sut); // Calling the toString
//		sut.add(2);
//		System.out.println("All items in the list: " + sut); // Calling the toString
//		sut.add(3);
//		System.out.println("All items in the list: " + sut); // Calling the toString
//
//		assertEquals(Integer.valueOf(2), sut.remove(1));
//		System.out.println("Removed #2: " + sut); // Calling the toString
//
//		assertEquals(2, sut.getSize());
//		System.out.println("Size should be 2: " + sut.getSize());
//	}
//
//	@Test
//	void shouldThrowExceptionWhenRemovingItemFromInvalidIndex() {
//		CustomArrayList<Integer> sut = new CustomArrayList<>();
//		assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(1));
////		System.out.println(sut.remove(1)); // Sys-Out displays IndexOutOfBoundsException: Index 1, Size: 0
//	}
//
//
//
//
//
//
//
//	// ChatGPT Assistance - End
//
//	@Test
//	void should_add_one_item_to_list() {
//		CustomList<Integer> customList = new CustomArrayList<>();
//
//		customList.add(10);
//		Integer expectedResult = customList.get(0);
//		Integer expectedSize = customList.getSize();
//
//		assertEquals(10, expectedResult);
//		assertEquals(1, expectedSize);
//	}
//
//	@Test
//	void should_add_11_items_to_list() {
//		CustomList<Integer> sut = new CustomArrayList<>();
//
//		for (int i = 1; i <= 11; i++) {
//			sut.add(i);
//		}
//
//		for (int i = 0; i < 10; i++) {
//			assertEquals(i+1, sut.get(i));
//		}
//		assertEquals(11, sut.getSize());
//	}
//
//	@Test
//	void should_add_21_items_to_list() {
//		CustomArrayList<Integer> sut = new CustomArrayList<>();
//
//		for (int i = 1; i <= 21; i++) {
//			sut.add(i);
//			System.out.println("ADDED: " + i);
//		}
//
//		System.out.println("------------");
//
//		for (int i = 0; i < 21; i++) {
//			assertEquals(i+1, sut.get(i));
//			System.out.println("GETTING: " + i);
//		}
//		assertEquals(21, sut.getSize());
//		System.out.println("Test getSize: " + sut.getSize());
//	}
}
