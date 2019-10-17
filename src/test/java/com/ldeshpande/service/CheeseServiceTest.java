package com.ldeshpande.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheeseServiceTest {

    private CheeseService cheeseService;

    @Before
    public void setup() {
        this.cheeseService = new CheeseService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMaximumConsecutiveCheeseForNullArray() {
        cheeseService.getMaxConsecutiveCheese(null);
    }

    @Test
    public void testGetMaximumConsecutiveCheeseForEmptyArray() {
        int[] array = new int[]{};
        assertEquals(0, cheeseService.getMaxConsecutiveCheese(array));
    }

    @Test
    public void testGetMaximumConsecutiveCheeseForSingleElementArray() {
        int[] array = new int[]{3};
        assertEquals(3, cheeseService.getMaxConsecutiveCheese(array));
    }

    @Test
    public void testGetMaximumConsecutiveCheeseForTwoElementArray() {
        int[] array = new int[]{3, 7};
        assertEquals(7, cheeseService.getMaxConsecutiveCheese(array));
    }

    @Test
    public void testGetMaximumConsecutiveCheeseForSuccess() {
        int[] array = new int[]{8, 5, 10, 100, 10, 5};
        assertEquals(113, cheeseService.getMaxConsecutiveCheese(array));
        array = new int[]{1, 2, 3};
        assertEquals(4, cheeseService.getMaxConsecutiveCheese(array));
    }
}