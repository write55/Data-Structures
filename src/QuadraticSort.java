/*
 * Aaron Wu
 * 2/5/2020
 * Quadratic Sort Assignment
 */

public class QuadraticSort {

    private int[] array;
    private int swap;
    private int comp;

    public QuadraticSort(int length) {
        array = new int[length];
    }

    public int getSwap() {
        return swap;
    }

    public int getComp() {
        return comp;
    }

    public void setSwap(int swap) {
        this.swap = swap;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    public void fillAscending() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public void fillDescending() {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i - 1;
        }
    }

    public void fillRandom() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (array.length + 1));
        }
    }

    public void sort() {
        comp = 0;
        swap = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comp++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (array[minIndex] != array[i]) {
                swap++;
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public void runQuickSort() {
        comp = 0;
        swap = 0;
        quickSort(0, array.length - 1);
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            // find median of three for pivot
            int mid = (low + high) / 2;
            int median = medianOfThree(array[low], array[mid], array[high]);
            // swap with the last for pivot
            int temp = array[high];
            array[high] = median;
            if (median == array[low]) {
                array[low] = temp;
            } else if (median == array[mid]) {
                array[mid] = temp;
            }
            // set pivot, start recursion
            int pivot = partition(low, high);
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }

    public int partition(int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                swap++;
            }
            comp++;
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        swap++;
        return i + 1;
    }

    public int medianOfThree(int a, int b, int c) {
        if ((a > b) != (a > c)) {
            return a;
        } else if ((b > a) != (b > c)) {
            return b;
        } else {
            return c;
        }
    }

    public String toString() {
        return "\nArray Length: " + array.length + "\ncomparisons: " + this.getComp() + "\nswaps: " + this.getSwap();
    }

    public void printStats() {
        System.out.println(this.toString());
    }

    public void printArray() {
        StringBuilder str = new StringBuilder("[ ");
        for (int i = 0; i < array.length; i++) {
            str.append(array[i]);
            str.append(" ");
        }
        str.append("]");
        System.out.println(str.toString());
    }

    public static void main(String[] args) {
        QuadraticSort arr1 = new QuadraticSort(10);

        arr1.fillDescending();
        arr1.printArray();
        arr1.runQuickSort();
        arr1.printArray();
        arr1.printStats();

    }
}