import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static ArrayList<Integer> arraySizesToTest = new ArrayList<>(Arrays.asList(10, 100, 1000, 10000));

    public static void main(String[] args) {
        arraySizesToTest.forEach(arraySize -> testSorts(arraySize));
    }

    public static void testSorts(int arraySize){
        ArrayList<Integer> arrayToSort = createFilledArray(arraySize);

        for (SortingType sortType : SortingType.values()) {
            System.out.println("Sorting type: " + sortType.name());
            ArrayList<Integer> sortedList = checkSortInTime(arrayToSort, FactorySort.GetSorter(sortType));
        }
    }

    public static ArrayList<Integer> createFilledArray(int arraySize){
        ArrayList<Integer> filledArray = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < arraySize; i++){
            filledArray.add(rand.nextInt(arraySize));
        }
        return filledArray;
    }

    public static ArrayList<Integer> checkSortInTime(ArrayList<Integer> arrayToTest, Sorter sorter){
        ArrayList<Integer> arrayCopy = new ArrayList<>(arrayToTest);

        System.out.println("Array before sort: " + arrayCopy.subList(0, 10));
        long startTime = System.currentTimeMillis();
        sorter.sort(arrayCopy);
        System.out.printf("Sorting time: %s\nArray size: %d\n", System.currentTimeMillis() - startTime, arrayToTest.size());
        System.out.println("Array after sort: " + arrayCopy.subList(0, 10));
        System.out.println("-------------------------------------" );

        return arrayCopy;
    }
}