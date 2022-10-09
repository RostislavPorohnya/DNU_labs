import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class Main {
    static int randomElementLimit = 100;
    static String ArrayList = "ArrayList";
    static String LinkedList = "LinkedList";

    static Random random = new Random();

    static int FillArrayElementsNumber = 100000;
    static int InsertElementsNumber = 1000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        CheckInTimeFillList(arrayList, FillArrayElementsNumber, ArrayList);
        CheckInTimeFillList(linkedList, FillArrayElementsNumber, LinkedList);

        CheckInTimeRandomAccess(arrayList, ArrayList);
        CheckInTimeRandomAccess(linkedList, LinkedList);

        CheckInTimeSequentialAccess(arrayList, ArrayList);
        CheckInTimeSequentialAccess(linkedList, LinkedList);

        CheckInTimeInserts(arrayList, ArrayList);
        CheckInTimeInserts(linkedList, LinkedList);
    }

    public static int randomNumber(int randomLimit) {
        return random.nextInt(randomLimit);
    }

    public static void CheckInTimeFillList(List<Integer> list, int elementsNumber, String listType){
        long time = System.currentTimeMillis();

        for (int i = 0; i < elementsNumber; i++){
            list.add(randomNumber(randomElementLimit));
        }

        System.out.printf("Fill %s: %s%n", listType, System.currentTimeMillis() - time);
    }

    public static void CheckInTimeRandomAccess(List<Integer> list, String listType){
        long time = System.currentTimeMillis();

        for (int i = 0; i < FillArrayElementsNumber; i++){
            int temp = list.get(randomNumber(FillArrayElementsNumber));
        }

        System.out.printf("Random access %s: %s%n", listType, System.currentTimeMillis() - time);
    }

    public static void CheckInTimeSequentialAccess(List<Integer> list, String listType){
        long time = System.currentTimeMillis();

        for (int element : list){
            int temp = element;
        }

        System.out.printf("Sequential access %s: %s%n", listType, System.currentTimeMillis() - time);
    }

    public static void CheckInTimeInserts(List<Integer> list, String listType){
        CheckInTimeListTop(list, listType);
        CheckInTimeListBottom(list, listType);
        CheckInTimeListMiddle(list, listType);
    }

    public static void CheckInTimeListTop(List<Integer> list, String listType){
        long time = System.currentTimeMillis();

        for (int i = 0; i < InsertElementsNumber; i++){
            list.set(i, randomNumber(randomElementLimit));
        }

        System.out.printf("Insert to top %s: %s%n", listType, System.currentTimeMillis() - time);
    }

    public static void CheckInTimeListBottom(List<Integer> list, String listType){
        long time = System.currentTimeMillis();

        for (int i = InsertElementsNumber-1; i > -1; i--){
            list.set(i, randomNumber(randomElementLimit));
        }

        System.out.printf("Insert to bottom %s: %s%n", listType, System.currentTimeMillis() - time);
    }

    public static void CheckInTimeListMiddle(List<Integer> list, String listType){
        long time = System.currentTimeMillis();

        int listHalfSize = list.size() / 2;
        int listMiddleElement = listHalfSize - InsertElementsNumber / 2;

        for (int i = listMiddleElement; i < (listMiddleElement+InsertElementsNumber); i++){
            list.set(i, randomNumber(randomElementLimit));
        }

        System.out.printf("Insert to middle %s: %s%n", listType, System.currentTimeMillis() - time);
    }

}
