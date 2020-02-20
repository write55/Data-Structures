/*
Aaron Wu
2/19/20
RadixSort Program runner class
 */

public class RadixSortRunner {

    public static void main(String[] args) {
        RadixSort array = new RadixSort(50);
        array.fillRandom(1000);
        array.printArray();
        RadixSort.sort(array.getArr(), array.getLength(), array.max());
        array.printArray();
    }

}
