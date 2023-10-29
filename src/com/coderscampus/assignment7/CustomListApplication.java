package com.coderscampus.assignment7;

public class CustomListApplication {

	public static void main(String[] args) {
		CustomList<Integer> myCustomList = new CustomArrayList<>();

		addItemsToList(myCustomList);
		displayListInfo(myCustomList);
		testAddAtSpecificIndex(myCustomList);
		testRemoveFunction(myCustomList);
	}


	public static void addItemsToList(CustomList<Integer> list) {
		for (int i = 1; i <= 40; i++) {
			list.add(i);
		}
		System.out.println("List: " + list);
		System.out.println("Added items from 1 to 40.");
	}

	private static void displayListInfo(CustomList<Integer> list) {
		System.out.println("--------");
		System.out.println("Size of list: " + list.getSize());
		System.out.println("First item: " + list.get(0));
		System.out.println("--------");

		for (int i = 0; i < list.getSize(); i++) {
			System.out.println("Item at index " + i + ": " + list.get(i));
		}
	}

	private static void testAddAtSpecificIndex(CustomList<Integer> list) {
		System.out.println("--------");
		list.add(40, 42);
		System.out.println("Added 42 at index 40.");
		list.add(41);
		System.out.println("Added 41 at the end.");
	}

	private static void testRemoveFunction(CustomList<Integer> list) {
		System.out.println("--------");
		System.out.println("Removed item at index 5: " + list.remove(5));
		System.out.println("Updated size: " + list.getSize());
	}







//		CustomList<Integer> myCustomList = new CustomArrayList<>();
////		myCustomList.add("element 1");  and continue to add another 10, 20 or 40 more elements
//
////		for (int i = 1; i < 101; i++) {
////			myCustomList.add(i);
////		}
//
//
//		for (int i = 1; i < 41; i++) {
//			myCustomList.add(i);
//		}
//
//		myCustomList.add(40, 42);
//		System.out.println("LIST IS: " + myCustomList);
//		myCustomList.add(41);
//		System.out.println("LIST IS THROW: " + myCustomList);
//
//
//
//
//		System.out.println("getSize: " + myCustomList.getSize());
//		System.out.println("get: " + myCustomList.get(0));
//		System.out.println("--------");
//
//		// then you should validate that all the elements you've inserted actually exist
//		// in your data structure
//		for (int i = 0; i < myCustomList.getSize(); i++) {
//			System.out.println(myCustomList.get(i));
//		}
//		System.out.println("Removed item: " + myCustomList.remove(5));
//		System.out.println("getSize: " + myCustomList.getSize());

}

