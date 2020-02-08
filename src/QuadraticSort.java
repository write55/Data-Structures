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

    public void quickSort() {
        int pivot = medianOfThree(array[0], array[(array.length / 2) + 1], array[array.length - 1]);

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
        arr1.sort();
        arr1.printStats();

        arr1.fillAscending();
        arr1.sort();
        arr1.printStats();

        arr1.fillRandom();
        arr1.sort();
        arr1.printStats();
    }
}