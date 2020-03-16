package OLD;/*
 * Aaron Wu
 * 2/5/2020
 * Quadratic Sort Runner
 */

public class QuadraticSortRunner {

	public static void main(String[] args) {
		QuadraticSort arr1 = new QuadraticSort(500);
		QuadraticSort arr2 = new QuadraticSort(5000);
		QuadraticSort arr3 = new QuadraticSort(50000);

		arr1.fillAscending();
		arr1.sort();
		arr1.printStats();

		arr1.fillDescending();
		arr1.sort();
		arr1.printStats();

		arr1.fillRandom();
		arr1.sort();
		arr1.printStats();

		arr2.fillAscending();
		arr2.sort();
		arr2.printStats();

		arr2.fillDescending();
		arr2.sort();
		arr2.printStats();

		arr2.fillRandom();
		arr2.sort();
		arr2.printStats();

		arr3.fillAscending();
		arr3.sort();
		arr3.printStats();

		arr3.fillDescending();
		arr3.sort();
		arr3.printStats();

		arr3.fillRandom();
		arr3.sort();
		arr3.printStats();
	}

}

// OUTPUT

/*

Array Length: 500
comparisons: 124750
swaps: 0

Array Length: 500
comparisons: 124750
swaps: 250

Array Length: 500
comparisons: 124750
swaps: 490

Array Length: 5000
comparisons: 12497500
swaps: 0

Array Length: 5000
comparisons: 12497500
swaps: 2500

Array Length: 5000
comparisons: 12497500
swaps: 4996

Array Length: 50000
comparisons: 1249975000
swaps: 0

Array Length: 50000
comparisons: 1249975000
swaps: 25000

Array Length: 50000
comparisons: 1249975000
swaps: 49987

*/