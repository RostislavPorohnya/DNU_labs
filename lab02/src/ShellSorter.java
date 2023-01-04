import java.util.ArrayList;

public class ShellSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input){
        int arrayLength = input.size();
        for (int gap = arrayLength/2; gap > 0; gap /= 2){
            for (int i = gap; i < arrayLength; i++){
                int currentElem = input.get(i);

                int j;
                for (j = i; j >= gap
                        && input.get(j - gap) > currentElem; j -= gap){
                    input.set(j, input.get(j - gap));
                }
                input.set(j, currentElem);
            }
        }
        return input;
    }
}
