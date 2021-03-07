package problem3;
// Problem 3:
// (a) Fill in the code of the bubble sort:
// elements should be sorted from 0 to arr.length-1 in descending order
// (b) Copy the same code to method bubbleSortSubarray and
// change the code so that we sort the array from index low to arr.length - 1, in descending order
// See the solution below.
import java.util.Arrays;

public class Problem3 {
    // (a)
    public static void bubbleSortDescending(int[] arr) {
        for (int pos = 0; pos < arr.length - 1; pos++) {
            for (int  j = arr.length - 1; j > pos; j--) {
                if (arr[j]  > arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    // (b)
    public static void bubbleSortSubarrayDescending(int[] arr, int low) {
        for (int pos = low; pos < arr.length - 1; pos++) {
            for (int  j = arr.length - 1; j > pos; j--) {
                if (arr[j]  > arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 10, 4, 6, 1, 10, 45, 16, 78, 3, 5, 90, 2, 4, 87, 56, 45, 906, 246, 26, 73, 7, 3};
        // bubbleSortDescending(arr);
        bubbleSortSubarrayDescending(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}
