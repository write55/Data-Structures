/*
Aaron Wu
RadixSort Program, RadixSort object class
2/19/20
 */

import java.util.ArrayList;

public class RadixSort {

    /**
     * arr - the integer array to be sorted
     */
    private int[] arr;
    /**
     * length - length of arr
     */
    private int length;

    /**
     * Constructor for RadixSort Object, takes parameter for array length
     *
     * @param l Integer for length of array
     */
    public RadixSort(int l) {
        length = l;
        arr = new int[length];
    }

    // GETTERS - Setters are never used so not included
    public int[] getArr() {
        return arr;
    }

    public int getLength() {
        return length;
    }

    /**
     * Fills array with random integers, range of 0-max
     *
     * @param max Integer for maximum possible random value
     */
    public void fillRandom(int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (max + 1));
        }
    }

    /**
     * returns maximum value in arr to be used later
     *
     * @return Integer, highest number in arr
     */
    public int max() {
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Method to create buckets for a given digit place of the values in input
     *
     * @param input Integer array to go through and create buckets for
     * @param n     length of input array
     * @param digit digit place of each number in input to be checked and sorted into buckets
     * @return ArrayList with buckets merged in ascending order
     */
    public static ArrayList<Integer> bucket(int[] input, int n, int digit) {
        ArrayList<ArrayList<Integer>> count = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> out = new ArrayList<Integer>();
        // Fill count with empty buckets
        for (int i = 0; i < 10; i++) {
            count.add(new ArrayList<>());
        }
        // Fill buckets
        for (int i = 0; i < n; i++) {
            count.get((input[i] / digit) % 10).add(input[i]);
        }
        // Merge buckets into input in proper order
        for (ArrayList<Integer> bucket : count) {
            for (Integer value : bucket) {
                out.add(value);
            }
        }
        return out;
    }

    /**
     * Carries out Radix sort on given input array, increments the digit place for bucket
     *
     * @param input Integer array to be sorted
     * @param n     length of input array
     * @param max   maximum value in input array
     */
    public static void sort(int[] input, int n, int max) {
        for (int pos = 1; max / pos > 0; pos *= 10) {
            ArrayList<Integer> temp = bucket(input, n, pos);
            for (int i = 0; i < n; i++) {
                input[i] = temp.get(i);
            }
        }
    }

    /**
     * Prints out arr from given RadixSort object
     */
    public void printArray() {
        StringBuilder str = new StringBuilder("[ ");
        for (int num : arr) {
            str.append(num);
            str.append(" ");
        }
        str.append("]");
        System.out.println(str.toString());
    }

}
