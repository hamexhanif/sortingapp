package de.sortapp.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class SortService {
    private static final Logger serviceLogger = LoggerFactory.getLogger(SortService.class);

    public List<Double> bubbleSort(List<Double> input) {
        try {
            serviceLogger.info("[SERVICE] Starte Bubble Sort fuer Liste mit {} Elementen", input.size());
            
            int n = input.size();
            int swaps = 0;
            for (int i = 0; i < n - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (input.get(j) > input.get(j + 1)) {
                        Double temp = input.get(j);
                        input.set(j, input.get(j + 1));
                        input.set(j + 1, temp);
                        swaps++;
                        swapped = true;
                    }
                }
                serviceLogger.debug("[SERVICE] Bubble Sort Durchlauf {}: {} Tauschoperationen bisher", i+1, swaps);
                if (!swapped) {
                    serviceLogger.debug("[SERVICE] Liste bereits sortiert nach {} Durchlaeufen", i+1);
                    break;
                }
            }
            
            serviceLogger.info("[SERVICE] Bubble Sort erfolgreich abgeschlossen mit {} Tauschoperationen", swaps);
            return input;
        } catch (Exception e) {
            serviceLogger.error("[SERVICE] Fehler beim Bubble Sort", e);
            throw e;
        }
    }

    public List<Double> mergeSort(List<Double> input) {
        try {
            serviceLogger.info("[SERVICE] Starte Merge Sort fuer Liste mit {} Elementen", input.size());
            
            if (input.size() <= 1) {
                return input;
            }

            List<Double> result = mergeSortRecursive(input);
            
            serviceLogger.info("[SERVICE] erge Sort erfolgreich abgeschlossen");
            return result;
        } catch (Exception e) {
            serviceLogger.error("[SERVICE] ehler beim Merge Sort", e);
            throw e;
        }
    }

    private List<Double> mergeSortRecursive(List<Double> input) {
    if (input.size() <= 1) {
        serviceLogger.debug("[SERVICE] Merge Sort: Teiliste mit Groesse {} wird zurueckgegeben", input.size());
        return input;
    }

    int mid = input.size() / 2;
    serviceLogger.debug("[SERVICE] Merge Sort: Teile Liste der Groesse {} bei Position {}", input.size(), mid);
    
    List<Double> left = mergeSortRecursive(input.subList(0, mid));
    List<Double> right = mergeSortRecursive(input.subList(mid, input.size()));

    List<Double> merged = merge(left, right);
    serviceLogger.debug("[SERVICE] Merge Sort: Fuege Teillisten der Groessen {} und {} zusammen", left.size(), right.size());
    
    return merged;
}

    private List<Double> merge(List<Double> left, List<Double> right) {
        List<Double> result = new ArrayList<>();
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
        try {
            serviceLogger.info("[SERVICE] Starte Quick Sort fuer Liste mit {} Elementen", input.size());
            
            if (input.size() <= 1) {
                return input;
            }

            List<Double> result = quickSortRecursive(input, 0, input.size() - 1);
            
            serviceLogger.info("[SERVICE] Quick Sort erfolgreich abgeschlossen");
            return result;
        } catch (Exception e) {
            serviceLogger.error("[SERVICE] Fehler beim Quick Sort", e);
            throw e;
        }
    }

    private List<Double> quickSortRecursive(List<Double> input, int low, int high) {
        if (low < high) {
            serviceLogger.debug("[SERVICE] Quick Sort: Verarbeite Teilbereich von Index {} bis {}", low, high);
            
            int pivotIndex = partition(input, low, high);
            serviceLogger.debug("[SERVICE] Quick Sort: Pivot-Element an Position {} eingefuegt", pivotIndex);
            
            quickSortRecursive(input, low, pivotIndex - 1);
            quickSortRecursive(input, pivotIndex + 1, high);
        }
        return input;
    }
    
    private int partition(List<Double> input, int low, int high) {
        Double pivot = input.get(high);
        serviceLogger.debug("[SERVICE] Quick Sort: Partition mit Pivot-Element {}", pivot);
        
        int i = low - 1;
        int swaps = 0;
    
        for (int j = low; j < high; j++) {
            if (input.get(j) <= pivot) {
                i++;
                // Tausche Elemente
                Double temp = input.get(i);
                input.set(i, input.get(j));
                input.set(j, temp);
                swaps++;
            }
        }

        // Setze Pivot an die richtige Position    
        Double temp = input.get(i + 1);
        input.set(i + 1, input.get(high));
        input.set(high, temp);
        swaps++;
    
        serviceLogger.debug("[SERVICE] Quick Sort: Partition abgeschlossen mit {} Tauschoperationen", swaps);
        return i + 1;
    }
}
