public class FactorySort {
    public static Sorter GetSorter(SortingType sortType){
        switch (sortType) {
            case MERGESORTER:
                return new MergeSorter();
            case QUICKSORTER:
                return new QuickSorter();
            case SHELLSORTER:
                return new ShellSorter();
            case BUBBLESORTER:
                return new BubbleSorter();
            default:
                throw new RuntimeException();
        }
    }

}
