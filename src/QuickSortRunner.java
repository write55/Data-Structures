public class QuickSortRunner {

    public static void main(String[] args) {
        QuadraticSort array1 = new QuadraticSort(3);
        array1.fillRandom();
        array1.runQuickSort();
        array1.printArray();
    }

}
