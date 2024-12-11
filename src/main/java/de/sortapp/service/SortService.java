package de.sortapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SortService {

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

    public List<Double> mergeSort(List<Double> input) {
        if (input.size() <= 1) {
            return input;
        }

        int mid = input.size() / 2;
        List<Double> left = mergeSort(input.subList(0, mid));
        List<Double> right = mergeSort(input.subList(mid, input.size()));

        return merge(left, right);
    }

    private List<Double> merge(List<Double> left, List<Double> right) {
        List<Double> result = new ArrayList<>(left.size() + right.size());
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }

    public List<Double> quickSort(List<Double> input) {
        if (input.size() <= 1) {
            return input;
        }
        
        return quickSortRecursive(input, 0, input.size() - 1);
    }

    private List<Double> quickSortRecursive(List<Double> input, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(input, low, high);
            quickSortRecursive(input, low, pivotIndex - 1);
            quickSortRecursive(input, pivotIndex + 1, high);
        }
        return input;
    }

    private int partition(List<Double> input, int low, int high) {
        Double pivot = input.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (input.get(j) <= pivot) {
                i++;
                // Tausche Elemente
                Double temp = input.get(i);
                input.set(i, input.get(j));
                input.set(j, temp);
            }
        }

        // Setze Pivot an die richtige Position
        Double temp = input.get(i + 1);
        input.set(i + 1, input.get(high));
        input.set(high, temp);

        return i + 1;
    }
}
