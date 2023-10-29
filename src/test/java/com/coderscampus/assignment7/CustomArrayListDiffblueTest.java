package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CustomArrayListDiffblueTest {
    /**
     * Method under test: {@link CustomArrayList#toString()}
     */
    @Test
    void testToString() {
        CustomArrayList<Object> customArrayList = new CustomArrayList<>();
        assertEquals("[]", customArrayList.toString());
    }

    /**
     * Method under test: {@link CustomArrayList#toString()}
     */
    @Test
    void testToString2() {
        CustomArrayList<Object> customArrayList = new CustomArrayList<>();
        customArrayList.add("Item");
        assertEquals("[Item]", customArrayList.toString());
    }

    /**
     * Method under test: {@link CustomArrayList#toString()}
     */
    @Test
    void testToString3() {
        CustomArrayList<Object> customArrayList = new CustomArrayList<>();
        customArrayList.add("Item");
        customArrayList.add("Item");
        assertEquals("[Item, Item]", customArrayList.toString());
    }
}

