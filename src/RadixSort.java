import java.util.ArrayList;

public class RadixSort {

    int[] arr;
    int length;

    public RadixSort(int l) {
        length = l;
        arr = new int[length];
    }

    public int[] getArr() {
        return arr;
    }

    public int getLength() {
        return length;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void fillRandom() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
    }

    public int max() {
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static ArrayList<Integer> bucket(int n, ArrayList<Integer> merge) {
        ArrayList<Integer> value = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < merge.size(); j++) {
                String number = Integer.toString(merge.get(j));
                int len = number.length();
                if (len - 1 - n >= 0) {
                    if (number.charAt(len - 1 - n) == i) {
                        value.add(merge.get(j));
                        merge.remove(j);
                    }
                }
            }
            merge.addAll(value);
            value.clear();
        }
        return merge;
    }

    public static void sort(RadixSort input) {
        String number = Integer.toString(input.max());
        int len = number.length();
        ArrayList<Integer> in = new ArrayList<Integer>();
        for (int num : input.getArr()) {
            in.add(num);
        }
        for (int i = 0; i < len; i++) {
            in = bucket(i, in);
        }
        input.setArr(convertIntegers(in));
    }

    public static int[] convertIntegers(ArrayList<Integer> input) {
        int[] out = new int[input.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = input.get(i).intValue();
        }
        return out;
    }

    public void printArray() {
        StringBuilder str = new StringBuilder("[ ");
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
            str.append(" ");
        }
        str.append("]");
        System.out.println(str.toString());
    }

    public static void main(String[] args) {
        RadixSort asdf = new RadixSort(10);
        asdf.fillRandom();
        asdf.printArray();
        sort(asdf);
        asdf.printArray();

    }
}
