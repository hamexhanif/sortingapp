package de.sortapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

    private SortService sortService;

    @BeforeEach
    void setUp() {
        sortService = new SortService();
    }

    @Test
    void testMergeSortEmptyList() {
        List<Double> emptyList = new ArrayList<>();
        List<Double> result = sortService.mergeSort(emptyList);
        assertTrue(result.isEmpty());
    }

    @Test
    void testMergeSortSingleElement() {
        List<Double> singleElementList = Arrays.asList(5.5);
        List<Double> result = sortService.mergeSort(singleElementList);
        assertEquals(Arrays.asList(5.5), result);
    }

    @Test
    void testMergeSortMultipleElements() {
        List<Double> unsortedList = Arrays.asList(64.5, 34.2, 25.1, 12.7, 22.9, 11.0);
        List<Double> expectedList = Arrays.asList(11.0, 12.7, 22.9, 25.1, 34.2, 64.5);
        List<Double> result = sortService.mergeSort(unsortedList);
        assertEquals(expectedList, result);
    }

    @Test
    void testMergeSortNegativeNumbers() {
        List<Double> unsortedList = Arrays.asList(-5.5, -2.3, -10.1, 0.0, 3.7);
        List<Double> expectedList = Arrays.asList(-10.1, -5.5, -2.3, 0.0, 3.7);
        List<Double> result = sortService.mergeSort(unsortedList);
        assertEquals(expectedList, result);
    }
}
