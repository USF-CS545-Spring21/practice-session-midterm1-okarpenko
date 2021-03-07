package problem7;

// Problem 7:
// Assume the range of values in the array of integers A is from 1 to m,
// and that you have a modified counter array C from counting sort computed by first
// incrementing C[A[i]] for each element of A[i] and then setting each element of C for i from 1 to m to:
//        C[i] = C[i] + C[i-1].
// Write a function numBetween(int c[], int m, int low, int high)
// that takes as input this C array, m, and two values low and high,
// and returns the number of elements in the original list A whose values are between low and high, inclusive.
// Array A may contain duplicates, and you should be able to handle this.
// Running time of your function should be constant, Θ(1).

// Solution: see the code below.
// Consider the input array given in the main method [8, 4, 7, 1, 3, 4, 5, 4, 1, 6, 0, 1, 5, 4, 7],  assume
// the keys range from 0 to 8, and consider the corresponding counter array: [1, 4, 4, 5, 9, 11, 12, 14, 15].
// Observe c[i] contains the the number of elements in the original array that are less or equal to i.
// So c[high] contains the number of elements that are less than  or equal to high.
// For instance, to compute how many values we have that are less than or equal to 2,
// we can access c[2] = 4 (and indeed, in A, we have four numbers that are 2 or less:  0, 1, 1, 1).

//To compute the number of values in the range from low to high (inclusive),
// we can access c[high] to get the total number of values that are less than or equal to high,
// and then subtract the number of values that are strictly less than low - this value is stored in c[low - 1].

import java.util.Arrays;

public class Problem7 {
    public static int numBetween(int[] c, int m, int low, int high) {
        if (low == 0) // need to handle this case separately
            return c[high];
        else
            return c[high] - c[low - 1];
    }

    public static int[] createCounterArray(int[] arr, int m) {
        int[] c = new int[m + 1];
        for (int i = 0; i < arr.length; i++) {
            c[arr[i]]++;
        }
        //System.out.println(Arrays.toString(c));
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i-1];
        }
        System.out.println(Arrays.toString(c));

        return c;

    }
    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 1, 3, 4, 5, 4, 1, 6, 0, 1, 5, 4, 7};
        System.out.println(Arrays.toString(arr));
        int[] c = createCounterArray(arr, 8);
        System.out.println(Arrays.toString(c));
        System.out.println(numBetween(c, 8, 4, 7));

    }

}
