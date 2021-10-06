/*
Week 6
Programming Assignment for course
"Computer Science: Programming with a Purpose" by Princeton University.
Coursera link: https://www.coursera.org/learn/cs-programming-java

Specification details:
https://coursera.cs.princeton.edu/introcs/assignments/recursion/specification.php
The input and output standard libraries developed for this course:
https://introcs.cs.princeton.edu/java/stdlib/
*/

/**
 * @author stasbutuzov
 * @version Oct 5, 2021
 */

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        } else if (k < -n || k > n) {
            return 0;
        } else {
            long[][] trinom = new long[n + 1][n + 1];
            trinom[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        trinom[i][j] = trinom[i - 1][j] + 2 * trinom[i - 1][j + 1];
                    } else if (j == i) {
                        trinom[i][j] = trinom[i - 1][j - 1];
                    } else {
                        trinom[i][j] = trinom[i - 1][j - 1] + trinom[i - 1][j] + trinom[i - 1][j + 1];
                    }
                }
            }
            if (k < 0) {
                return trinom[n][Math.abs(k)];
            } else {
                return trinom[n][k];
            }
        }
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
