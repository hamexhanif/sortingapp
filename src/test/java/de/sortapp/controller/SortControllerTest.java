package de.sortapp.controller;

import de.sortapp.service.SortService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SortControllerTest {

    private SortController sortController;
    private SortService sortService;

    @BeforeEach
    void setUp() {
        sortService = new SortService();
        sortController = new SortController(sortService);
    }

    @Test
    void testBubbleSortEndpoint() {
        List<Double> input = Arrays.asList(5.5, 3.2, 1.1, 4.4);
        ResponseEntity<List<Double>> response = sortController.bubbleSort(input);
        
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(Arrays.asList(1.1, 3.2, 4.4, 5.5), response.getBody());
    }

    @Test
    void testMergeSortEndpoint() {
        List<Double> input = Arrays.asList(5.5, 3.2, 1.1, 4.4);
        ResponseEntity<List<Double>> response = sortController.mergeSort(input);
        
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(Arrays.asList(1.1, 3.2, 4.4, 5.5), response.getBody());
    }

    @Test
    void testQuickSortEndpoint() {
        List<Double> input = Arrays.asList(5.5, 3.2, 1.1, 4.4);
        ResponseEntity<List<Double>> response = sortController.quickSort(input);
        
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(Arrays.asList(1.1, 3.2, 4.4, 5.5), response.getBody());
    }
}