import java.util.ArrayList;

public class BubbleSorter implements Sorter {
    public ArrayList<Integer> sort(ArrayList<Integer> input){
        int arrLength = input.size();
        for (int i = 0; i < arrLength - 1; i++){
            for (int j = 0; j < arrLength - i - 1; j++){
                int currentElem = input.get(j);
                int nextElem = input.get(j+1);
                if (currentElem > nextElem){
                    input.set(j, nextElem);
                    input.set(j+1, currentElem);
                }
            }
        }
        return input;
    }
}
