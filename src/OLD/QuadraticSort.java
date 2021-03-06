package OLD;/*
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

	public int[] getArray() {
		return array;
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

	public void oldSort() {
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

	public void sort() {
		comp = 0;
		swap = 0;
		quickSort(0, array.length - 1);
	}

	public void quickSort(int low, int high) {
		if (low < high) {
			// find median of three for pivot
			int pivot;
			int mid = (low + high) / 2;
			int median = medianOfThree(array[low], array[mid], array[high]);
			pivot = partition(low, high, median);
			quickSort(pivot + 1, high);
			quickSort(low, pivot - 1);
		}
	}

	public int partition(int low, int high, int pivot) {
		int i = low, j = high;
		while (true) {
			while (array[i] < pivot) {
				i++;
				comp++;
			}
			while (array[j] > pivot) {
				j--;
				comp++;
			}
			if (i >= j) {
				break;
			} else if (array[i] == array[j]) {
				i++;
			} else {
				swap(i, j);
			}
		}
		return i;
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

	public void swap(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		swap++;
	}

	public String toString() {
		return "\nArray Length: " + array.length + "\ncomparisons: " + this.getComp() + "\nswaps: " + this.getSwap();
	}

	public void printStats() {
		System.out.println(this.toString());
	}

	public void printArray() {
		StringBuilder str = new StringBuilder("[ ");
		for (int value : array) {
			str.append(value);
			str.append(" ");
		}
		str.append("]");
		System.out.println(str.toString());
	}

}