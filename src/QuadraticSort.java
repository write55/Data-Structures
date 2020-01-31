
public class QuadraticSort {

    private int[] array;
    private int swap;
    private int comp;

    public QuadraticSort(int length) {
        array = new int[length];
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

    // I dunno of the swap counting is correct
    public void sort() {
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

    public String toString() {
        StringBuilder str = new StringBuilder("[ ");
        for (int i = 0; i < array.length; i++) {
            str.append(array[i]);
            str.append(" ");
        }
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {
        QuadraticSort arr = new QuadraticSort(10);
        arr.fillRandom();
        System.out.println(arr.toString());
    }

}
