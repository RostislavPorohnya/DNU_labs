import java.util.ArrayList;
import java.util.Arrays;

public class MergeSorter implements Sorter {
    void mergesort(ArrayList<Integer> array, int left, int right){
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergesort(array, left, mid);
            mergesort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    void merge(ArrayList<Integer> array, int left, int mid, int right)
    {
        int leftLength = mid - left + 1;
        int rightLength = right - mid;

        ArrayList<Integer> LeftArr = new ArrayList<Integer>(leftLength);
        ArrayList<Integer> RightArr = new ArrayList<Integer>(rightLength);

        for (int i = 0; i < leftLength; ++i)
            LeftArr.add(i, array.get(left + i));
        for (int j = 0; j < rightLength; ++j)
            RightArr.add(j, array.get(mid + 1 + j));


        int i = 0, j = 0;

        int k = left;
        while (i < leftLength && j < rightLength) {
            if (LeftArr.get(i) <= RightArr.get(j)) {
                array.set(k, LeftArr.get(i));
                i++;
            }
            else {
                array.set(k, RightArr.get(j));
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array.set(k, LeftArr.get(i));
            i++;
            k++;
        }

        while (j < rightLength) {
            array.set(k, RightArr.get(j));
            j++;
            k++;
        }
    }

    public ArrayList<Integer> sort(ArrayList<Integer> input){
        mergesort(input, 0, input.size()-1);
        return input;
    }

}
