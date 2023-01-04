import java.util.ArrayList;

import static java.util.Collections.swap;

public class QuickSorter implements Sorter {
    int partition(ArrayList<Integer> input, int left, int right){
        int pivot = input.get(right);
        int smallest = left-1;

        for (int i = left; i < right; i++){
            if (input.get(i) < pivot){
                smallest++;
                swap(input, smallest, i);
            }
        }

        swap(input, smallest+1, right);


        return smallest+1;
    }

    void quicksort(ArrayList<Integer> input, int left, int right){
        if (left < right){
            int pivotIndex = partition(input, left, right);
            quicksort(input, left, pivotIndex-1);
            quicksort(input, pivotIndex+1, right);
        }
    }
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int right = input.size() - 1;
        quicksort(input, 0, right);

        return input;
    }

}
