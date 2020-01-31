
public class QuadraticSort {

	int[] array;
	int swap;
	int comp;

	public QuadraticSort(int length) {
		array = new int[length];
	}

	public void fillAscending() {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	public void fillDescending() {
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = i;
		}
	}

	public void fillRandom() {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.random() * (array.length + 1);
		}
	}

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
			swap++;
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

}
