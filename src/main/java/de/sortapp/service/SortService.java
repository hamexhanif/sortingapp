package de.sortapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SortService {
    //TODO: implement 3 sorting algorithms (bubble sort, quicksort, merge sort)

    public List<Double> bubbleSort(List<Double> input) {
        int n = input.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    // Tausche Elemente
                    Double temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        return input;
    }

}
