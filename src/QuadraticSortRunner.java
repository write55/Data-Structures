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
