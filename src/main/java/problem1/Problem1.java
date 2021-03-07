package problem1;

// Give Theta of the running time (as a function of n) of the following code snippets:
// Your answer:
// (a) Theta(n^2)
//The m loop has log n iterations, and the l loop has n/5 iterations; since the loops are nested,
//the running time of m and l loops is Theta(n*log n).

// j depends on i, so we need to do a summation to compute the running time of both loops:
// 0 + 1 + ... + (n-1) = (n-1)*n / 2 = Theta(n^2)

// Total running time of func1:  Theta(n*log n) + Theta(n^2) = Theta(n^2).

// (b)
// First, note that the following statement has Theta(n^4) running time:
// sum = sum + func1(n*n);  (since func1(x) has a running time of Theta(x^2), and here we are calling
// it on  x = n^2).
// The number of iterations of the j loop depends on i. To find out the total number of times the statement inside the loops
// will be executed, we need to do a summation
// log 1 + log 2  + ... + log n  + C = Theta(n*log n) - see the proof in one of algorithm analysis lectures early in the semester.
// So the total running time of func2 is Theta(n^5 * log n).

public class Problem1 {

    // (a) n^2
    public static int func1(int n) {
        int sum1 = 0, sum2 = 0;
        // the loop below is n  * log n
        for (int m = 1; m <= n; m = m * 2) { // log n
            for (int l = 1; l <= n; l = l + 5) // n/5
                sum1++;

        }
        // the loop below is n^2: 1 + 2 + 3 + ... + n = n ( n + 1) / 2
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++)
                sum2++;
        }

        return sum1 * sum2;
    }

    // (b) n^5 * log n
    public static void func2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j = j * 2)
                sum = sum + func1(n*n); // here we call func1 from (a)  // n^4

        }
        System.out.println(sum);
    }
}
