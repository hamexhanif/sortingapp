package de.sortapp.controller;

import de.sortapp.service.SortService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/sort")
public class SortController {
    private static final Logger controllerLogger = LoggerFactory.getLogger(SortController.class);
    private static final Logger performanceLogger = LoggerFactory.getLogger("performance");

    private final SortService sortService;

    @Autowired
    public SortController(SortService sortService) {
        this.sortService = sortService;
    }

    @PostMapping("/bubblesort")
    public ResponseEntity<List<Double>> bubbleSort(@RequestBody List<Double> numbers) {
        controllerLogger.info("[CONTROLLER] Bubble Sort Anfrage erhalten");
        
        Instant start = Instant.now();
        List<Double> sortedList = sortService.bubbleSort(numbers);
        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();
        performanceLogger.debug("[PERFORMANCE] Bubble Sort Performance: {} ms, Listengroesse: {}", 
                               duration, numbers.size());

        if (duration > 1000) {
            performanceLogger.warn("[PERFORMANCE] Bubble Sort überschreitet 1 Sekunde. Dauer: {} ms", duration);
        }

        return ResponseEntity.ok(sortedList);
    }

    @PostMapping("/mergesort")
    public ResponseEntity<List<Double>> mergeSort(@RequestBody List<Double> numbers) {
        controllerLogger.info("[CONTROLLER] Merge Sort Anfrage erhalten");
        
        Instant start = Instant.now();
        List<Double> sortedList = sortService.mergeSort(numbers);
        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();
        performanceLogger.debug("[PERFORMANCE] Merge Sort Performance: {} ms, Listengroesse: {}", 
                               duration, numbers.size());

        if (duration > 500) {
            performanceLogger.warn("[PERFORMANCE] Merge Sort überschreitet 500 ms. Dauer: {} ms", duration);
        }

        return ResponseEntity.ok(sortedList);
    }

    @PostMapping("/quicksort")
    public ResponseEntity<List<Double>> quickSort(@RequestBody List<Double> numbers) {
        controllerLogger.info("[CONTROLLER] Quick Sort Anfrage erhalten");
        
        Instant start = Instant.now();
        List<Double> sortedList = sortService.quickSort(numbers);
        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();
        performanceLogger.debug("[PERFORMANCE] Quick Sort Performance: {} ms, Listengroesse: {}", 
                               duration, numbers.size());

        if (duration > 300) {
            performanceLogger.warn("[PERFORMANCE] Quick Sort überschreitet 300 ms. Dauer: {} ms", duration);
        }

        return ResponseEntity.ok(sortedList);
    }
}
