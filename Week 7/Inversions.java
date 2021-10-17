/*
Week 7
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/performance/specification.php
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

/**
 * @author stasbutuzov
 * @version Oct 15, 2021
 */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int inversion = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((i < j) && (a[i] > a[j])) {
                    inversion++;
                }
            }
        }
        return inversion;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];

        if (k > (long) n * (n - 1) / 2) {
            return null;
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (k >= n - i - 1) {
                a[i] = n - 1 - j;
                j++;
                k -= a[i];
            } else {
                a[i] = i - j;
            }
        }
        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] a = generate(n, k);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }
}
