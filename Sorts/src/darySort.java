import java.util.Random;
import java.util.SplittableRandom;
import java.util.stream.IntStream;

/**
 * Kelvin Kemper
 * CS 362
 * Program Assignment #2
 */


public class darySort {

    static final int n = 10;// number of elements to be sorted
    static final int d = 5;
    public void sort(int arr[])
    {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public void heapify(int arr[], int N, int i) {
        printArray(arr);
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

    /**
     * A utility function to print array of size n
     * */
    static void printArray(int arr[]) {
        int N = arr.length;
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver's code
    public static void main(String args[]) {

        // creating Random object using splittableRandom
        SplittableRandom random = new SplittableRandom();

        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(0,n);
        }
        //System.out.println("Before sorting: ");
        //printArray(arr1);

        // Function call
        darySort ob = new darySort();
        double startTime1 = System.currentTimeMillis();
        ob.sort(arr1);
        double elapsedTime1 = System.currentTimeMillis() - startTime1;
        System.out.println("It took " + elapsedTime1/1000 + " seconds to complete an insertion"
                + " sort of " + arr1.length + " elements\n");

        //System.out.println("Sorted array is");
        //printArray(arr1);

    }
}
