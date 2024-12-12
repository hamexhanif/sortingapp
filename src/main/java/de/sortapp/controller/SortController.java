package de.sortapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import de.sortapp.service.SortService;

import java.util.List;

@RestController
@RequestMapping("/api/sort")
public class SortController {
    
    private final SortService sortService;

    @Autowired
    public SortController(SortService sortService) {
        this.sortService = sortService;
    }

    @PostMapping("/bubblesort")
    public ResponseEntity<List<Double>> bubbleSort(@RequestBody List<Double> numbers) {
        return ResponseEntity.ok(sortService.bubbleSort(numbers));
    }

    @PostMapping("/mergesort")
    public ResponseEntity<List<Double>> mergeSort(@RequestBody List<Double> numbers) {
        return ResponseEntity.ok(sortService.mergeSort(numbers));
    }

    @PostMapping("/quicksort")
    public ResponseEntity<List<Double>> quickSort(@RequestBody List<Double> numbers) {
        return ResponseEntity.ok(sortService.quickSort(numbers));
    }
}
