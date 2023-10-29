package com.coderscampus.assignment7test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coderscampus.assignment7.CustomArrayList;

class CustomArrayListTest {
    // sut = System under test
    private CustomArrayList<Integer> sut;

    @BeforeEach
    void setUp() {
        sut = new CustomArrayList<>();
    }

    // void should_ReturnTrue_When_SingleItemIsAddedToArrayList()
    @Test
    void should_add_single_item_to_list() {
        // Successfully adds 1 item to the array
        assertTrue(sut.add(10));
        System.out.println("Item at index 1: " + sut.get(0));
        assertEquals(1, sut.getSize());
        System.out.println("Get size of Array: " + sut.getSize());
        assertEquals(10, sut.get(0));
        System.out.println("Get item at index 1: " + sut.get(0));
    }

    // void should_ReturnTrue_When_AddingMultipleItemsToArrayList

    @Test
    void should_add_multiple_items_to_list() {
        for (int i = 0; i < 15; i++) {
            sut.add(i);
            System.out.println("TEST: Added #" + i + ", to array list");
//			System.out.println("Added #" + sut.add(i) + " to array list");
        }
        assertEquals(15, sut.getSize());
        System.out.println("Assert Equals - Expect 15: -> " + sut.getSize());
        assertEquals(14, sut.get(14));
        System.out.println("Assert Equals - Expect 14: -> " + sut.get(14));
    }

    @Test
        // Tests add(T item) and ensureCapacity(int minCapacity)
    void should_increase_internal_array_size() {
        for (int i = 0; i < 15; i++) {
            sut.add(i);
        }
        assertEquals(15, sut.getSize());

    }

    @Test // Tests add(T item) and ensureCapacity(int minCapacity)
    public void testEnsureCapacity() {
        for (int i = 0; i < 11; i++) {
            sut.add(i, i);
        }
        assertEquals(11, sut.getSize());
        System.out.println("Expect 11: -> " + sut.getSize());
        assertEquals(10, sut.get(10));
        System.out.println("Expect 10: -> " + sut.get(10));
    }

    // void should_ReturnTrue_When_AddingItemAtSpecificIndex ()
    @Test
    void should_add_item_at_specific_index() {
        sut.add(10);
        sut.add(20);
        sut.add(1, 15);
        assertEquals(3, sut.getSize());
        System.out.println("Expect 3 numbers: " + sut.getSize() + " - " + sut);
        assertEquals(10, sut.get(0));
        System.out.println("Expect #10 at index 0: -> " + sut.get(0) + " of " + sut);
        assertEquals(15, sut.get(1));
        System.out.println("Expect #15 at index 1: -> " + sut.get(1) + " of " + sut);
        assertEquals(20, sut.get(2));
        System.out.println("Expect #20 at index 2: -> " + sut.get(2) + " of " + sut);
    }

    @Test
        // Tests validateIndexForAdditionalItem(int index) directly
    void should_throw_exception_for_invalid_index() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.add(5, 10));
        // For Testing
        // System.out.println(sut.add(5, 10));
    }

    @Test
        // Runs add, ensureCapacity, get, validateIndexForAccess, toString,
    void should_shift_items_when_adding_in_middle_of_array_list() {
        sut.add(10); // Added to index 0
        System.out.println(sut.get(0) + " - " + sut);
        sut.add(20); // Added to index 1
        System.out.println(sut.get(1) + " - " + sut);
        sut.add(30); // Added to index 2
        System.out.println(sut.get(2) + " - " + sut);
        sut.add(1, 15); // Added to index 1, replacing 20, and pushing other numbers up one index.
        System.out.println(sut.get(1) + " - " + sut);
        assertEquals(4, sut.getSize());
        System.out.println("Expect size to be 4: -> " + sut.getSize());
        assertEquals(10, sut.get(0));
        System.out.println("Expect #10: " + sut.get(0));
        assertEquals(15, sut.get(1));
        System.out.println("Expect #15: " + sut.get(1));
        assertEquals(20, sut.get(2));
        System.out.println("Expect #20: " + sut.get(2));
        assertEquals(30, sut.get(3));
        System.out.println("Expect #30: " + sut.get(3));
    }

    @Test
        // Tests validateIndexForAdditionalItem using a negative index
    void should_throw_exception_for_negative_index_when_adding() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.add(-1, 10));
        // For Testing
        // System.out.println(sut.add(-1, 10));
    }

    @Test
    void should_return_correct_size() {
        assertEquals(0, sut.getSize());
        System.out.println("Size of array list: 0 -> " + sut.getSize());
        sut.add(10);
        assertEquals(1, sut.getSize());
        System.out.println("Size of array list: 1 -> " + sut.getSize());
    }

    @Test
    void should_return_and_remove_item() {
        sut.add(5); // Added 5 to index 0
        sut.add(10); // Added 10 to index 1
        sut.add(15); // Added 15 to index 2
        System.out.println("** Array list: " + sut + " Array size: " + sut.getSize());
        assertEquals(10, sut.remove(1)); // Removed 10 from index 1
        System.out.println("** Array list: " + sut + " Array size: " + sut.getSize());
        assertEquals(2, sut.getSize()); // Size should return 2
        System.out.println("** Array list: " + sut + " Array size: " + sut.getSize());
    }

    @Test
    void should_shift_items_when_removing_from_middle() {
        sut.add(1); // Add 1 to index 0
        sut.add(2); // Add 2 to index 1
        sut.add(3); // Add 3 to index 2
        assertEquals(3, sut.getSize());
        System.out.println("** Expect size to be 3: " + sut.getSize() + " - " + sut);
        assertEquals(2, sut.remove(1));
        System.out.println("** Removed #2 from index 1");
        assertEquals(1, sut.get(0));
        System.out.println("** Expect #1: " + sut.get(0) + " - " + sut);
        assertEquals(3, sut.get(1));
        System.out.println("** Expect #3: " + sut.get(1) + " - " + sut);
        assertEquals(2, sut.getSize());
        System.out.println("** Expect size to be 2: " + sut.getSize() + " - " + sut);

    }

    // Edge case Tests

    @Test
    void should_throw_exception_for_invalid_index_when_getting() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.get(1));
        // For Testing
//		 System.out.println(sut.get(1));
    }

    @Test
    void should_throw_exception_for_invalid_index_when_removing() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(0));
        // For Testing
        // System.out.println(sut.remove(0));
    }

    @Test
    void should_throw_exception_for_negative_index_when_removing() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(-1));
        // For Testing
        // System.out.println(sut.remove(-1));
    }

    @Test
    void should_throw_exception_for_negative_index_when_getting() {
        assertThrows(IndexOutOfBoundsException.class, () -> sut.get(-1));
        // For Testing
        // System.out.println(sut.get(-1));
    }

    @Test
    void should_produce_correct_string_representation() {
        assertEquals("[]", sut.toString());
        System.out.println("** Expect: [] - " + sut);
        sut.add(5);
        sut.add(10);
        sut.add(15);
        sut.add(20);
        assertEquals("[5, 10, 15, 20]", sut.toString());
        System.out.println("** Expect: [5, 10, 15, 20] - " + sut);
    }

}


