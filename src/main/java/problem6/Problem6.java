package problem6;

// Problem 6:
//(a) Write down the recurrence relation for the recursive function shown below.
// Give both the base and the recursive case.
// This functions performs a binary search.
//T(1) = C1
//T(n) = T(n/2) + C

//(b) Solve the recurrence relation using the Master theorem. State what case of the Master theorem applies and show why.
// f(n) = C = Theta(1)
// a = 1, b = 2. log 1  = 0, n^(log 1) = n^0  = 1 = Theta(1)
// Case 2 of the Master theorem applies. The solution is Theta(log n).
public class Problem6 {
    static boolean func2(int[] arr, int start, int end, int elem) {
        int n = end - start + 1;
        if (n == 1) {
            if (arr[start] == elem)
                return true;
            else
                return false;
        } else {
            int m = (start + end) / 2;
            if (arr[m] == elem)
                return true;
            else if (elem < arr[m])
                return func2(arr, start, m - 1, elem);
            else
                return func2(arr, m + 1, end, elem);
        }
    }

    // The main method, if you'd like to run the function.
    public static void main(String[] args) {
        int[] arr = { 7, 10, 15, 19, 21, 45, 101};
        System.out.println(func2(arr, 0, 6, 22));
    }
}
