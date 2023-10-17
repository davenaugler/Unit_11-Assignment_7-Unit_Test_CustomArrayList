package com.coderscampus.Assignment7_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.coderscampus.Assignment7.CustomArrayList;
import com.coderscampus.Assignment7.CustomList;

class CustomArrayListTest {

	@Test
	void should_add_one_item_to_list() {
		CustomList<Integer> customList = new CustomArrayList<>();
		
		customList.add(10);
		Integer expectedResult = customList.get(0);
		Integer expectedSize = customList.getSize();
		
		assertEquals(10, expectedResult);
		assertEquals(1, expectedSize);
	}
	
	@Test
	void should_add_11_items_to_list() {
		CustomList<Integer> sut = new CustomArrayList<>();
		
		for (int i = 1; i <= 11; i++) {
			sut.add(i);
		}
		
		for (int i = 0; i < 10; i++) {
			assertEquals(i+1, sut.get(i));
		}
		assertEquals(11, sut.getSize());
	}
	
	@Test
	void should_add_21_items_to_list() {
		CustomList<Integer> sut = new CustomArrayList<>();
		
		for (int i = 1; i <= 21; i++) {
			sut.add(i);
			System.out.println(i);
		}
		
		for (int i = 0; i < 21; i++) {
			assertEquals(i+1, sut.get(i));
//			System.out.println(i);
		}
		assertEquals(21, sut.getSize());
//		System.out.println("Test getSize: " + sut.getSize());
	}
	
	

}
