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

// EXAMPLE OUTPUT
/*
[ 500 615 129 299 389 438 354 830 888 532 133 949 945 926 256 447 67 505 3 994 681 934 381 790 134 139 340 766 709 488 69 528 205 27 346 898 644 534 215 145 351 420 746 727 265 965 441 612 572 739 ]
[ 3 27 67 69 129 133 134 139 145 205 215 256 265 299 340 346 351 354 381 389 420 438 441 447 488 500 505 528 532 534 572 612 615 644 681 709 727 739 746 766 790 830 888 898 926 934 945 949 965 994 ]
 */